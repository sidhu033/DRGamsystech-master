package com.example.user.drgamsystech.databasehelper;


import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences
{
    public static final String APP_PREFERENCE = "appPrefs";
    public static final String IS_LOGIN = "isLogin";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";
    public static final String LAST_TIME = "lastTime";


    //shared preference instnace variable
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static AppPreferences instance;

    //constructor of app preferences
    public AppPreferences(SharedPreferences preferences, SharedPreferences.Editor editor)
    {
        this.preferences = preferences;
        this.editor = editor;
    }

    //instance of app preferences
    public static AppPreferences getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new AppPreferences(context);
        }
        return instance;
    }
    //app preference context
    public AppPreferences(Context context)
    {
        preferences = context.getSharedPreferences(APP_PREFERENCE,Context.MODE_PRIVATE);

    }

    //edit SharedPreferences
    public void edit()
    {
        editor = preferences.edit();
    }

    //commit SharedPreferencs
    public void commit()
    {
        editor.commit();
    }

    //clear preference
     public void clearPreference()
    {
        editor.clear();
        editor.commit();
    }

    //remove keyvalue pair in preferences
    public void removeKeyValue(String key)
    {
        editor.remove(key);
        editor.commit();
    }

    //put value into SharedPreferences
    public void putValue(String key, Object value)
    {
        if(value instanceof String)
        {
            editor.putString(key,(String) value);
        }
        else if(value instanceof  Integer)
        {
            editor.putInt(key,(int) value);
        }
        else if (value instanceof Float)
        {
            editor.putFloat(key, (float) value);
        } else if (value instanceof Boolean)
        {
            editor.putBoolean(key, (boolean) value);
        } else if (value instanceof Long)
        {
            editor.putLong(key, (long) value);
        }

    }


    //to get object of get value
    public Object getValue(String key, Object obj)
    {

        if (obj instanceof String) {
            return preferences.getString(key, null);
        } else if (obj instanceof Boolean) {
            return preferences.getBoolean(key, false);
        } else if (obj instanceof Long) {
            long value = 1;
            return preferences.getLong(key, value);
        } else if (obj instanceof Integer) {
            return preferences.getInt(key, 0);
        } else if (obj instanceof Float) {
            return preferences.getFloat(key, 0f);
        }
        return null;
    }
}
