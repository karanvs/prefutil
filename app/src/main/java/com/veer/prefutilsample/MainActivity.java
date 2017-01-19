package com.veer.prefutilsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.veer.prefutil.PrefsUtils;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    showPrefUtilSample("pref Util");
  }

  private <T> void showPrefUtilSample(String putData) {
    String key = "string_key";
    PrefsUtils prefsUtils = PrefsUtils.getInstance(this);
    prefsUtils.putData(key, "This is pref utils");
    String data = prefsUtils.getData(key, putData);
    Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
  }
}
