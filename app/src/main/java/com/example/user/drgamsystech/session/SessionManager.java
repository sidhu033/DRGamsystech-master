package com.example.user.drgamsystech.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.user.drgamsystech.activity.Login;

import java.util.HashMap;

public class SessionManager
{

    SharedPreferences pref;                                      //shared Preferences
    SharedPreferences.Editor editor;            // Editor for Shared preferences
    Context context;                                             //Contexts
    int PRIVATE_MODE = 0;                                           // Shared pref mode
    private static final String PREF_NAME = "Drpref";      // Sharedpref file name
    private static final String IS_LOGIN = "IsLoggedIn";                  // All Shared Preferences Keys
    public static final String KEY_NAME = "name";                         // User name (make variable public to access from outside)
    public static final String KEY_EMAIL = "Email";                       // Email address (make variable public to access from outside)
    public static final String KEY_PASSWORD = "txtPassword";              // password

    public SessionManager(Context context)
    {
        this.context = context;
        pref  = (SharedPreferences) context.getSharedPreferences("Mypref",PRIVATE_MODE);
        editor = pref.edit();

    }
    //Create login session
    public void createLoginSession(String email)
    {

        editor.putBoolean(IS_LOGIN, true);                   // Storing login value as TRUE
        editor.putString(KEY_EMAIL, email);                      // Storing email in pref
       // editor.putString(KEY_PASSWORD, pass);                    // Storing pass in pref
        editor.commit();                                     // commit changes
    }
    /**
     * Check login method wil check user login status
     * * If false it will redirect user to login page
     * Else won't do anything
     * */

    public void checkLogin()
    {
        // Check login status
        if(!this.isloggedIn())
        {
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(context, Login.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);             // Closing all the Activities
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);              // Add new Flag to start new Activity
            // Staring Login Activity
            context.startActivity(i);
        }

    }
    /** Get stored session data **/

    public HashMap<String, String> getUserDetails()
    {
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));           // user email id
        // return user
        return user;
    }
    /** Clear session details * */
    public  void Logoutuser()
    {
            // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(context, Login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);     // Closing all the Activities
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);          // Add new Flag to start new Activity

        // Staring Login Activity
        context.startActivity(i);

    }

    public boolean isloggedIn()
    {
        return  pref.getBoolean(IS_LOGIN,false);
    }
    public void logoutsession()
    {
        Logoutuser();
        Toast.makeText(context,"Logout sucessfully",Toast.LENGTH_SHORT).show();
    }

}

