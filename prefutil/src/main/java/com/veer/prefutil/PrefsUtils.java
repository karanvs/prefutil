package com.veer.prefutil;

/**
 * Created by Brajendr on 7/19/2016.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefsUtils {

    private Context context;
    private static PrefsUtils ourInstance;
    private SharedPreferences preferences;

    public static PrefsUtils getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new PrefsUtils(context);

        }
        return ourInstance;
    }

    private PrefsUtils(Context context) {
        this.context = context;
    }

    public SharedPreferences getPreferences() {
        if (preferences == null) {
            preferences = context.getSharedPreferences("prefs", Context.MODE_MULTI_PROCESS);
        }
        return preferences;
    }

    public <T> void putData(String key, T obj) {

        SharedPreferences.Editor editor = getPreferences().edit();
        if (obj instanceof String) {
            editor.putString(key, (String) obj);
        } else if (obj instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            editor.putInt(key, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(key, ((Long) obj).longValue());
        }
        editor.commit();
    }


    public <T> T getData(String key, T obj) {
        if (obj instanceof String) {
            return (T) getPreferences().getString(key, (String) obj);
        } else if (obj instanceof Boolean) {
            return (T) (Boolean) getPreferences().getBoolean(key, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            return (T) (Integer) getPreferences().getInt(key, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            return (T) (Long) getPreferences().getLong(key, ((Long) obj).longValue());
        }
        return null;
    }

    public void removeKeyData(String key) {
        getPreferences().edit().remove(key).commit();
    }

    public void clearAll() {
        preferences.edit().clear().commit();
    }

    public Typeface getTypeFaceByName(String fontName) {
        return Typeface.createFromAsset(context.getAssets(), fontName);
    }
}

