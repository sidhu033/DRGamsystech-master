package com.example.user.drgamsystech.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.R;

import java.io.FileInputStream;


public class RedoxerUserDetails extends AppCompatActivity
{
   /*Toolbar uhutoolbar;
    FloatingActionButton floatdouadd;
    Button trackhealth,btnshow;
    TextView edurefdname,edemail,edurefdmob1,edurefdmob2 ,txtrepdadd1,txtrepdadd2 ,txtrepdadd3;
    String rudname;
    String rudemail;
    String rudmob1;
    String rudmob2;
    String rudadd1;
    String rudadd2;
    String rudadd3;*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redoxer_user_details2);

        /*Intilization*/
      //  initilization();
       // onclicklistner();


    }
    //oncreate closed

   /* private void initilization()
    {
        floatdouadd = findViewById(R.id.floatdouadd);
        trackhealth = findViewById(R.id.btntrackhelath);
        uhutoolbar = findViewById(R.id.uhutoolbar);
        setSupportActionBar(uhutoolbar);

        edurefdname = findViewById(R.id.edurefdname);
        edemail = findViewById(R.id.edemail);
        edurefdmob1 = findViewById(R.id.edurefdmob1);
        edurefdmob2 = findViewById(R.id.edurefdmob2);
        txtrepdadd1 = findViewById(R.id.txtrepdadd1);
        txtrepdadd2 = findViewById(R.id.txtrepdadd2);
        txtrepdadd3 = findViewById(R.id.txtrepdadd3);
        btnshow = findViewById(R.id.btnshow);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        uhutoolbar.setOverflowIcon(drawable);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);

    }*/

   /* private void onclicklistner()
    {
        floatdouadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(RedoxerUserDetails.this, AddUser.class));
            }
        });

        trackhealth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                load(view);
                startActivity(new Intent(RedoxerUserDetails.this, UserHistory.class));
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                load(view);

            }
        });


    }*/
   /* public void load(View view)
    {
        try
        {
            FileInputStream fileInputStream = openFileInput("User.txt");
            int read = -1;

            StringBuffer buffer = new StringBuffer();
            while((read = fileInputStream.read())!= -1)
            {
                buffer.append((char)read);
            }
            Log.d("code",buffer.toString());

            rudname  =buffer.substring(buffer.indexOf(""),5);

           // rudname = buffer.substring(0,buffer.indexOf(""));
            rudemail = buffer.substring(buffer.indexOf("")+5, 5);
            rudmob1 = buffer.substring(buffer.indexOf(""),6);
            rudmob2 = buffer.substring(buffer.indexOf(""),8);
            rudadd1 = buffer.substring(buffer.indexOf(""),5);
            rudadd2 = buffer.substring(buffer.indexOf(""),5);
            rudadd3 = buffer.substring(buffer.indexOf("")+5

                    ,5);
            edurefdname.setText(rudname);
            edemail.setText(rudemail);
            edurefdmob1.setText(rudmob1);
            edurefdmob2.setText(rudmob2);
            txtrepdadd1.setText(rudadd1);
            txtrepdadd2.setText(rudadd2);
            txtrepdadd3.setText(rudadd3);

           *//* rudname = buffer.substring(0,buffer.indexOf(""));
            rudemail = buffer.substring(buffer.indexOf(""));
            rudmob1 = buffer.substring(buffer.indexOf(""));
            rudmob2 = buffer.substring(buffer.indexOf(""));
            rudadd1 = buffer.substring(buffer.indexOf(""));
            rudadd2 = buffer.substring(buffer.indexOf(""));
            rudadd3 = buffer.substring(buffer.indexOf(""));

            edurefdname.setText(rudname);
            edemail.setText(rudemail);
            edurefdmob1.setText(rudmob1);
            edurefdmob2.setText(rudmob2);
            txtrepdadd1.setText(rudadd1);
            txtrepdadd2.setText(rudadd2);
            txtrepdadd3.setText(rudadd3);*//*

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Toast.makeText(this,"Loaded", Toast.LENGTH_SHORT).show();

    }
*/
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
