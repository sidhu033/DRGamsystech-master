package com.example.user.drgamsystech.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.adapters.FollowUpAdapter;
import com.example.user.drgamsystech.adapters.ReferedPatientAdapter;
import com.example.user.drgamsystech.pojo.Follouppojo;
import com.example.user.drgamsystech.pojo.Referedpatients;

import java.util.ArrayList;
import java.util.List;

public class FollowUp extends AppCompatActivity
{
    Toolbar folwtoolbar;
    /*recycle view*/
    RecyclerView furecycleview;
    FollowUpAdapter followUpAdapter;
    private List<Follouppojo> follouppojoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_up);

        /*Intilization*/
        folwtoolbar = findViewById(R.id.folwtoolbar);
        setSupportActionBar(folwtoolbar);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        folwtoolbar.setOverflowIcon(drawable);

        /*recyleview initilizaiton*/
        furecycleview = findViewById(R.id.furecycleview);
        furecycleview.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        furecycleview.setLayoutManager(layoutManager);
        furecycleview.setItemAnimator(new DefaultItemAnimator());
        followUpAdapter = new FollowUpAdapter(this,follouppojoList,this);


        //intilize the list of refered patients
        FollupupData();
        furecycleview.setAdapter(followUpAdapter);
    }
    /*Oncreate closed*/


    private void FollupupData()
    {

        Follouppojo rp = new Follouppojo("12 May 2018","Siddharth Bhore ","In progress");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","Delivery scheduled");
        follouppojoList.add(rp);


        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","Follow UP");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","Dilivery Scheduled");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","In progress");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","In progress");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","In progress");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","In progress");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","In progress");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","In progress");
        follouppojoList.add(rp);

        rp =  new Follouppojo("12 May 2018","Siddharth Bhore ","In progress");
        follouppojoList.add(rp);

        followUpAdapter.notifyDataSetChanged();
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
}
