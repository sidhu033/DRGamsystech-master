package com.example.user.drgamsystech.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.drgamsystech.R;
public  class UserHistory extends AppCompatActivity
{

    Toolbar uhutoolbar;
    private ActionBarDrawerToggle drabardrawertog;
    private DrawerLayout drdrawer;
    Button btnviewhistory;
    FloatingActionButton imguhadd;
    PopupMenu popup;
    SwipeRefreshLayout swipereferesh;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_history);

        /*Intilization*/

        Initilization();
        onclicklistner();



    }

    private void Initilization()
    {
        swipereferesh = findViewById(R.id.swipereferesh);
        uhutoolbar = (Toolbar) findViewById(R.id.uhutoolbar);
        setSupportActionBar(uhutoolbar);
        btnviewhistory = findViewById(R.id.btnviewhistory);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        uhutoolbar.setOverflowIcon(drawable);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);




    }
    /*On create closed*/





    private void onclicklistner()
    {
        swipereferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipereferesh.setRefreshing(false);

                boolean connection=isNetworkAvailable();
                if(connection){
                    btnviewhistory.setText("internet connect");
                    btnviewhistory.setTextColor(Color.GREEN);
                }
                else{
                    btnviewhistory.setText("not connected");
                    btnviewhistory.setTextColor(Color.RED);
                }
            }
        });
    }

    private boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo !=null;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.right_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {

        }
        if(drabardrawertog.onOptionsItemSelected(item))
            return super.onOptionsItemSelected(item);
        return true;

    }

    /*@Override
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
    }*/
}
