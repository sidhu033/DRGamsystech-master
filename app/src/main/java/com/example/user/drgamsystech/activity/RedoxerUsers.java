package com.example.user.drgamsystech.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.adapters.RedoxerUserAdapter;
import com.example.user.drgamsystech.pojo.RedoxerUser;

import java.util.ArrayList;
import java.util.List;

public class RedoxerUsers extends AppCompatActivity
{
    Toolbar rutoolbar;
    TextView redoxuname;
    FloatingActionButton imgrueradd;
    //CardView card_viewredoxer;

    //for recycle view and redoxeruser adapter intilization
    private RecyclerView redoxeruserrv;
    private RedoxerUserAdapter redoxerUserAdapter;
    private List<RedoxerUser> redoxerUserList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redoxer_users);

        /*Intilization*/
        imgrueradd = findViewById(R.id.imgrueradd);                 //redoxer user's floating button
        redoxuname = findViewById(R.id.redoxuname);
       // card_viewredoxer = findViewById(R.id.card_viewredoxer);
        rutoolbar = findViewById(R.id.rutoolbar);
        setSupportActionBar(rutoolbar);

        /*recycle view intilization*/
        redoxeruserrv = findViewById(R.id.rurecycleview);
        redoxeruserrv.setHasFixedSize(true);

        LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        redoxeruserrv.setLayoutManager(layoutManager);
        redoxeruserrv.setItemAnimator(new DefaultItemAnimator());
        redoxerUserAdapter = new RedoxerUserAdapter(this,redoxerUserList,this);


        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);       //right dotted menus
        rutoolbar.setOverflowIcon(drawable);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);

        //intilize the list of refered patients
        redoxeruser();


        /* set on click on floating button*/
        imgrueradd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(RedoxerUsers.this,AddUser.class));
            }
        });

       /*  card_viewredoxer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
                {
                    startActivity(new Intent(RedoxerUsers.this,RedoxerUserDetails.class));
                }
        });
        */
        redoxeruserrv.setAdapter(redoxerUserAdapter);
    }
    /*OnCreate closed*/
    private void redoxeruser()
    {

        RedoxerUser redoxerUser = new RedoxerUser(R.drawable.user,"siddharth ","25","M");
        redoxerUserList.add(redoxerUser);

        redoxerUser = new RedoxerUser(R.drawable.user,"shaddy","25","M");
        redoxerUserList.add(redoxerUser);

        redoxerUser = new RedoxerUser(R.drawable.user,"shaddy","25","M");
        redoxerUserList.add(redoxerUser);

        redoxerUser = new RedoxerUser(R.drawable.user,"Joben","40","M");
        redoxerUserList.add(redoxerUser);

        redoxerUser = new RedoxerUser(R.drawable.user,"shaddy","25","M");
        redoxerUserList.add(redoxerUser);

        redoxerUser = new RedoxerUser(R.drawable.user,"shaddy","25","M");
        redoxerUserList.add(redoxerUser);

        redoxerUser = new RedoxerUser(R.drawable.user,"shaddy","25","M");
        redoxerUserList.add(redoxerUser);

        redoxerUser = new RedoxerUser(R.drawable.user,"shaddy","25","M");
        redoxerUserList.add(redoxerUser);

        redoxerUser = new RedoxerUser(R.drawable.user,"shaddy","25","M");
        redoxerUserList.add(redoxerUser);
        redoxerUserAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);

        Drawable yourdrawable = menu.getItem(0).getIcon(); // change 0 with 1,2 ...
        yourdrawable.mutate();
        yourdrawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
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
