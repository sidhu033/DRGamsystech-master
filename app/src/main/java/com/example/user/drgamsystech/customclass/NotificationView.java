package com.example.user.drgamsystech.customclass;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class NotificationView extends AppCompatActivity
{


   public  void checkphonestate()
    {
        //check phone state
        TelephonyManager telephonyManager =
                (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        PhoneStateListener callStateListener = new PhoneStateListener()
        {
            public void onCallStateChanged(int state, String incomingNumber)
            {
                if(state==TelephonyManager.CALL_STATE_RINGING){
                    Toast.makeText(getApplicationContext(),"Phone Is Riging",
                            Toast.LENGTH_LONG).show();
                }
                if(state==TelephonyManager.CALL_STATE_OFFHOOK){
                    Toast.makeText(getApplicationContext(),"Phone is Currently in A call",
                            Toast.LENGTH_LONG).show();
                }

                if(state==TelephonyManager.CALL_STATE_IDLE){
                    Toast.makeText(getApplicationContext(),"phone is neither ringing nor in a call",
                            Toast.LENGTH_LONG).show();
                }
            }
        };
        telephonyManager.listen(callStateListener,PhoneStateListener.LISTEN_CALL_STATE);
    }

    //find IMEI No


    public  void findIMEI()
    {
        String IMEI= "";
        final  int REQUEST_READ_PHONE_STATE = 10;
        TelephonyManager telephonyManager =(TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]
                    {
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.READ_PHONE_STATE
                    },      REQUEST_READ_PHONE_STATE
            );

            return;
        }
        if(telephonyManager.getDeviceId()!= null)
        {
            IMEI = telephonyManager.getDeviceId();
            Toast.makeText(getApplicationContext(),"IMEI"+IMEI,Toast.LENGTH_SHORT).show();

            //txtimei.setText(IMEI);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"IMEI NO not exist",Toast.LENGTH_SHORT).show();
            //txtimei.setText("not exist");
        }
        // IMEI = telephonyManager.getDeviceId();
        // txtimei.setText(IMEI);

    }
}
