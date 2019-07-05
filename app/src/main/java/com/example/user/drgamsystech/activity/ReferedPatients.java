package com.example.user.drgamsystech.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.adapters.ReferedPatientAdapter;
import com.example.user.drgamsystech.pojo.Referedpatients;

import java.util.ArrayList;
import java.util.List;


public class ReferedPatients extends AppCompatActivity
{
    TextView txtrpname;
    ImageView  imglol;
    Toolbar loltoolbar;
    CardView cardrefpatient;
    RecyclerView refrecycleview;
    ReferedPatientAdapter referedPatientAdapter;
    private List<Referedpatients> referedpatientsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refered_patients);

        /* intilization */
        loltoolbar = (Toolbar) findViewById(R.id.loltoolbar);
        setSupportActionBar(loltoolbar);


        imglol = findViewById(R.id.imglol);
        cardrefpatient = findViewById(R.id.cardrefpatient);
        txtrpname = findViewById(R.id.txtrpname);
        refrecycleview = findViewById(R.id.refrecycleview);
        refrecycleview.setHasFixedSize(true);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        refrecycleview.setLayoutManager(layoutManager);
        refrecycleview.setItemAnimator(new DefaultItemAnimator());
        referedPatientAdapter = new ReferedPatientAdapter(this,referedpatientsList,this);

        /*set icon to option menus*/
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        loltoolbar.setOverflowIcon(drawable);


        //intilize the list of refered patients
        preparerpData();
        refrecycleview.setAdapter(referedPatientAdapter);

        /*onclick button menus*/
        imglol.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(ReferedPatients.this,AddUser.class));
            }
        });

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);

       /* txtrpname.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               cardview();




            }
        });
        */

        //recycle view

    }

    private void cardview()
    {
        startActivity(new Intent(ReferedPatients.this,ReferedPatientsDetail.class));
    }

    /*on create closed*/
    private void preparerpData()
    {

        Referedpatients rp = new Referedpatients("12 May 2018","Siddharth Bhore ","In progress");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("14 May 2018","Shaddy","In Delivery");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("15 May 2019","Shankar","Delivery Scheduled");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("15 May 2018","Joben","IN progress");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("15 May 2018","Joben","IN progress");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("15 May 2018","Joben","IN progress");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("15 May 2018","Joben","IN progress");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("15 May 2018","Joben","IN progress");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("15 May 2018","Joben","IN progress");
        referedpatientsList.add(rp);

        rp =  new Referedpatients("15 May 2018","Joben","IN progress");
        referedpatientsList.add(rp);

        referedPatientAdapter.notifyDataSetChanged();
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
