package com.example.user.drgamsystech.activity;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.user.drgamsystech.R;
public class ForgetPass extends AppCompatActivity
{
    Toolbar forgtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);


        /*Intilization*/
        forgtoolbar = findViewById(R.id.forgtoolbar);
        setSupportActionBar(forgtoolbar);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        forgtoolbar.setOverflowIcon(drawable);


    }
    /*OnCreate closed*/


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
