package com.example.user.drgamsystech.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.Interface.ApiInterface;
import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.customclass.AlertDailogManager;
import com.example.user.drgamsystech.session.SessionManager;
import com.example.user.drgamsystech.utils.ApiClient;
import com.example.user.drgamsystech.utils.Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.UserDictionary.Words.APP_ID;

public class Login extends AppCompatActivity
{

    private Button btnSignIn;
    private TextView txtforgpass ,loguname,edulogpass;
    private android.support.v7.widget.Toolbar logintoolbar;
    private ProgressBar loginprogress;
    private ImageView imgpassiconvis,imgpassiconnon;

    //custom class of util

    AlertDailogManager  alert = new AlertDailogManager();       //alert dialog class
    SessionManager session;                                     //session manager class
    String uname,upass;
    Context logincontext;


    private void createObj()
    {
        logincontext = getApplicationContext();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Intilization*/
        Initilization();
        onclicklistner();


    }

    /*on create closed*/
    protected void Initilization()
    {
        txtforgpass = findViewById(R.id.txtforgpass);
        btnSignIn = findViewById(R.id.btnSignIn);
        loginprogress = findViewById(R.id.loginprogress);
        loguname = findViewById(R.id.loguname);
        edulogpass = findViewById(R.id.edulogpass);
        imgpassiconnon = findViewById(R.id.imgpassiconnon);
        imgpassiconvis  =findViewById(R.id.imgpassiconvis);

        logintoolbar = findViewById(R.id.logintoolbar);             //toolbar
        setSupportActionBar(logintoolbar);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        logintoolbar.setOverflowIcon(drawable);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);
        // Session Manager
        session = new SessionManager(getApplicationContext());


        //for weather
        double lat = 40.712774, lon = -74.006091;
        String units = "imperial";
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&units=%s&appid=%s",
                lat, lon, units, APP_ID);
        //new HTTPGetRequest(txtforgpass).execute(url);
    }



    /*onclick listner*/
    private void onclicklistner() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onloginclick();


            }
        });


        txtforgpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginprogress.setVisibility(view.VISIBLE);

                startActivity(new Intent(Login.this, ForgetPass.class));

                Toast.makeText(getApplicationContext(), "PASSWORD RESET LINK SUCCESSFULLY SENT ON YOUR REGISTERD EMAIL ID AND MOBILE NO.", Toast.LENGTH_LONG).show();
            }
        });

        imgpassiconnon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                edulogpass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imgpassiconvis.setVisibility(View.VISIBLE);
                imgpassiconnon.setVisibility(View.GONE);

               /* if(edulogpass.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
                {
                    edulogpass.setInputType( InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imgpassiconvis.setVisibility(View.VISIBLE);
                    imgpassiconnon.setVisibility(View.GONE);

                }else
                {
                    edulogpass.setInputType( InputType.TYPE_TEXT_VARIATION_PASSWORD );
                }*/

            }
        });
        imgpassiconvis.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                edulogpass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imgpassiconnon.setVisibility(View.VISIBLE);
                imgpassiconvis.setVisibility(View.GONE);
            }
        });

    }
    //on login click
    public void onloginclick()
    {
        uname = loguname.getText().toString();
        upass = edulogpass.getText().toString();


        if (Utils.isNetworkAvailable(getApplicationContext()))
        {

            // Check if username, password is filled
            if (uname.trim().length() > 0 && upass.trim().length() > 0)
            {
                if (uname.equals("a") && upass.equals("a")) {
                    Utils.showToastMsg(getApplicationContext(), "user Login Status" + session.isloggedIn());
                    session.createLoginSession("sbhore301@gmail.com");

                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else
                {
                    // username / password doesn't match
                    alert.showAlertDialog(Login.this, "LOGIN FAILED", "Username/Password is incorrect", false);

                }
            } else {
                // user didn't entered username or password
                alert.showAlertDialog(Login.this, "LOGIN FAILED", "Please enter username and password", false);
            }
        }
        else
        {

                Utils.showToastMsg(getApplicationContext(),"internet not connected");



        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.right_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.Help:
                Toast.makeText(getApplicationContext(),"Help Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Support:
                Toast.makeText(getApplicationContext(),"Support Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Contact:
                Toast.makeText(getApplicationContext(),"Contact Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //asychrnous task
    public class  HTTPGetRequest extends  AsyncTask<String,Void,String>
    {
        public static final String REQUEST_METHOD = "POST";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        String finaldata="";

        TextView  textView;

        public HTTPGetRequest(TextView textView)
        {
            this.textView = textView;
        }

        @Override
        protected String doInBackground(String... strings)
        {

            String stringurl= strings[0];
            String result="";
            String inputLine;

            try
            {
                URL myurl =new URL(stringurl);       // Create a URL object holding our url
                HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();       //Create a connection
                connection.setRequestMethod(REQUEST_METHOD);//Set methods and timeouts
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.connect();           //connect to our url

                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());        //Create a new InputStreamReader
                BufferedReader reader= new BufferedReader(streamReader);      //Create a new buffered reader and String Builder
                StringBuilder stringBuilder =new StringBuilder();

                while ((inputLine =reader.readLine())!= null)
                {
                    stringBuilder.append(inputLine);
                }
                reader.close();                //Close our InputStream and Buffered reader
                streamReader.close();
                result = stringBuilder.toString();                        //Set our result equal to our stringBuilder

                JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                JSONObject   main = jsonObject.getJSONObject("main");
                result = String.valueOf(main.get("temp"));
                connection.disconnect();

            }

            catch (IOException e)
            {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result)
        {

            super.onPostExecute(result);


        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
           textView.setText("current weather"+values);
            super.onProgressUpdate(values);
        }
    }
}
