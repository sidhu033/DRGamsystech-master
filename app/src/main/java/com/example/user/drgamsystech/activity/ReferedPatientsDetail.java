package com.example.user.drgamsystech.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.databasehelper.DatabaseHelper;
import com.example.user.drgamsystech.pojo.User;
import com.example.user.drgamsystech.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ReferedPatientsDetail extends AppCompatActivity
{
    Toolbar refdtoolbar;
    ImageView dolimgview;
    Button btnback;

    Context refpatientcontext =this;
    List<User> replist;
    ArrayAdapter<User> adapter;
    TextView edurefdname;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refered_patient_detail);

        /*Intilization */

        Initilization();
        clicklistner();
        createobj();


    }

    private void createobj()
    {
        refpatientcontext = getApplicationContext();
    }

    private void Initilization()
    {
        refdtoolbar = findViewById(R.id.refdtoolbar);
        setSupportActionBar(refdtoolbar);
        dolimgview = findViewById(R.id.dolimgview);
        btnback = findViewById(R.id.btnback);

        edurefdname = findViewById(R.id.edurefdname);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        refdtoolbar.setOverflowIcon(drawable);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);

    }



    private void clicklistner()
    {
        dolimgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                setContentView(R.layout.editall);

            }
        });
        btnback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onBackPressed();
            }
        });

    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    /*end of oncreate*/

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
}
