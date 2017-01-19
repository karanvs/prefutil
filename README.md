# prefutil

This is simple library to ease the use of Android SharedPreference, you can put and get String, Boolean and Integer data using same function call.
The class is designed to be singleton. This is library make use of gson library from google.

## Getting Started

*  Add this to build.gradle
```
repositories
{ 
 jcenter() 
 maven 
{
 url “https://jitpack.io” 
}
}
```

*  Add dependency for library
```
dependencies {  compile 'com.github.karanvs:prefutil:v1.0' }
```

## Usage

* Get the PrefUtil instance, 

```
PrefsUtils prefsUtils = PrefsUtils.getInstance(this);
```

* Use putData function to store either String,Integer or Boolean

```
For String
prefsUtils.putData(key, "This is pref utils");

For Integer
prefsUtils.putData(key, 1);

For Boolean
prefsUtils.putData(key, true);

```
* Use getData function to get stored data.

```
Specify the type as second parameter

prefsUtils.getData(key, ""); 
prefsUtils.getData(key, 0);
prefsUtils.getData(key, false);

```


### License

This project is licensed under the Apache 2.0 License - see the [LICENSE.txt](LICENSE.txt) file for details

