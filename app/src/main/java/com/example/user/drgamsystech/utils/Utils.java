package com.example.user.drgamsystech.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.UUID;

public class Utils
{
    private static final String TAG = Utils.class.getSimpleName();

    //has permission or not
    public static boolean hasPermissions(Context context, String... permissions)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    //isnetwork available
    public static boolean isNetworkAvailable(Context context)
    {
        // Reference --
        // http://stackoverflow.com/questions/4238921/android-detect-whether-there-is-an-internet-connection-available

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    //check BT Permission for app
    public static boolean checkBTPermissions(Context context)
    {

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP)
        {
            int permissionCheck = 0;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                permissionCheck = context.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                permissionCheck += context.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            }
            if (permissionCheck != 0)
            {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {

                   // context.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001); //Any number
                }
            }
        }
        else
        {
            Log.d(TAG, "checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP.");
        }
        return true;
    }
    //get uiid
    public static String getUUID(Context context)
    {
        String strUUID = "";

        strUUID = UUID.randomUUID().toString();
        strUUID = strUUID + "_EPOCH_" + System.currentTimeMillis();
        return strUUID;
    }

    //get device IMEI no


    //custom toast
    public static void showToastMsg(Context context, String msg) {
        if (Utils.isObjNotNull(context))
        {
            if (Utils.isStringNotNull(msg))
            {
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            }
        }
    }
    public static boolean isObjNotNull(Object object)
    {
        boolean isValide = true;
        try
        {
            if (object == null)
            {
                isValide = false;
                Log.d(TAG, "In isObjNull()---1st");
            } else {
                if (object.equals("")) {
                    isValide = false;
                    Log.d(TAG, "In isObjNull()---2nd");
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "Error In isObjNull()---" + e.getMessage());
        }
        Log.d(TAG, "In isObjNull()---3th");
        return isValide;

    }

    public static boolean isStringNotNull(String object)
    {
        boolean isValide = true;
        try {

            if (object == null) {
                isValide = false;
                Log.d(TAG, "In isStringNull()---1st");
            } else {
                if (object.trim().equals("")) {
                    isValide = false;
                    Log.d(TAG, "In isStringNull()---2nd");
                }
                if (object.trim().equalsIgnoreCase("null")) {
                    isValide = false;
                    Log.d(TAG, "In isStringNull()---3rd");
                }
            }

        } catch (Exception e) {
            Log.d(TAG, "Error In isStringNull()---" + e.getMessage());
        }
        Log.d(TAG, "In isStringNull()---4th");
        return isValide;
    }

}
