package com.example.user.drgamsystech.activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.Interface.ApiInterface;
import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.customclass.AlertDailogManager;
import com.example.user.drgamsystech.customclass.NotificationView;
import com.example.user.drgamsystech.pojo.ChangePinPojo;
import com.example.user.drgamsystech.pojo.ChangePinResPojo;
import com.example.user.drgamsystech.session.SessionManager;
import com.example.user.drgamsystech.utils.ApiClient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChangePassword extends AppCompatActivity implements View.OnClickListener {

    AlertDailogManager alert = new AlertDailogManager();
    SessionManager session;                               // Session Manager Class
    Toolbar chptoolbar;
    Button btnupdate, btnlogout;
    Context context;

    TextView educhgepass, edunewpass, educonnewp, cpuname, lblcplabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        /*intilization*/
        Initlization();
        clicklistner();


    }

    private void Initlization()
    {
        chptoolbar = findViewById(R.id.chptoolbar);
        setSupportActionBar(chptoolbar);

        lblcplabel = findViewById(R.id.lblcplabel);
        btnupdate = findViewById(R.id.btnupdate);
        btnupdate.setOnClickListener(this);

        edunewpass = findViewById(R.id.edunewpass);
        educonnewp = findViewById(R.id.educonnewp);
        cpuname = findViewById(R.id.cpuname);
        btnlogout = findViewById(R.id.btnlogout);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_dot_menu);
        chptoolbar.setOverflowIcon(drawable);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);

        session = new SessionManager(getApplicationContext());

        // get user data from session
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isloggedIn(), Toast.LENGTH_LONG).show();
        session.checkLogin();

        // displaying user data
        HashMap<String, String> user = session.getUserDetails();
        String email = user.get(SessionManager.KEY_EMAIL);
        cpuname.setText(Html.fromHtml(email));                      // email

    }

    //on create closed
    private void clicklistner()
    {

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 addnotification();
                 //getdata();

            }
        });
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.logoutsession();
            }
        });
    }

    public void getdata()
    {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ChangePinResPojo> call = apiInterface.getChangePinCall(1004, "123", "345");

        call.enqueue(new Callback<ChangePinResPojo>() {
            @Override
            public void onResponse(Call<ChangePinResPojo> call, Response<ChangePinResPojo> response)
            {

                if(response.body()!=null)
                {
                    Log.d("RESPONSE", response.body().toString());
                    ChangePinResPojo changepinresponse = response.body();
                    String changePinPojo =changepinresponse.getMessage();

                    Toast.makeText(ChangePassword.this, "Sucess"+changePinPojo, Toast.LENGTH_LONG).show();

                    lblcplabel.setText("" + response);

                    lblcplabel.setText("Sucesss");
                }

            }

            @Override
            public void onFailure(Call<ChangePinResPojo> call, Throwable t) {
                Log.e("ERROROROR", t.getMessage());
                call.cancel();
                Toast.makeText(ChangePassword.this, "ERROR occured", Toast.LENGTH_LONG).show();
                lblcplabel.setText("Connection Failed");
            }
        });
    }

        private void addnotification ()
        {

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.call)
                    .setContentTitle("Change Password Sucessfully")
                    .setContentText("Password Changed")
                    .setAutoCancel(false)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            Intent notificationintent = new Intent(this, Login.class);
            notificationintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            notificationintent.putExtra("message", "Password Changed");


            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationintent, PendingIntent.FLAG_UPDATE_CURRENT);

            //addnotification
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());


            //check phone state
            TelephonyManager telephonyManager =
                    (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

            PhoneStateListener callStateListener = new PhoneStateListener() {
                public void onCallStateChanged(int state, String incomingNumber) {
                    if (state == TelephonyManager.CALL_STATE_RINGING) {
                        Toast.makeText(getApplicationContext(), "Phone Is Riging",
                                Toast.LENGTH_LONG).show();
                    }
                    if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
                        Toast.makeText(getApplicationContext(), "Phone is Currently in A call",
                                Toast.LENGTH_LONG).show();
                    }

                    if (state == TelephonyManager.CALL_STATE_IDLE) {
                        Toast.makeText(getApplicationContext(), "phone is neither ringing nor in a call",
                                Toast.LENGTH_LONG).show();
                    }
                }
            };
            telephonyManager.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
            //custom class for checking phone state*/

        }


        @Override
        public boolean onCreateOptionsMenu (Menu menu)
        {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.right_menu, menu);
            return true;
        }


        @Override
        public boolean onOptionsItemSelected (MenuItem item)
        {
            int id = item.getItemId();
            switch (id) {
                case R.id.Help:
                    Toast.makeText(getApplicationContext(), "Help Selected", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.Support:
                    Toast.makeText(getApplicationContext(), "Support Selected", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.Contact:
                    Toast.makeText(getApplicationContext(), "Contact Selected", Toast.LENGTH_LONG).show();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        @Override
        public void onClick (View view)
        {
            Button b = (Button) view;
            String newpass = edunewpass.toString().trim();
            String conpass = educonnewp.toString().trim();
            switch (b.getId()) {
                case R.id.btnupdate:
                    if (newpass.isEmpty() || conpass.isEmpty()) {
                        educonnewp.setError("Password should not be empty");
                    } else if (newpass.equals(conpass)) {

                        educonnewp.setError("Password Does not matched");
                        Toast.makeText(getApplicationContext(), "Password  Does not Matched", Toast.LENGTH_LONG).show();
                    } else {
                        educonnewp.setError("Password matched sucessfully");
                        Toast.makeText(getApplicationContext(), "Password Updated Sucessfully", Toast.LENGTH_LONG).show();

                    }

            }

        }
    }

