package com.example.user.drgamsystech.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.user.drgamsystech.adapters.EmergencyPatientAdapter;
import com.example.user.drgamsystech.pojo.EmergencyPatientsPojo;

import java.util.ArrayList;
import java.util.List;

public class EmergencyPatient extends AppCompatActivity implements View.OnClickListener
{

    FloatingActionButton floatemergency;
    Toolbar eptoolbar;
    TextView txtepname;

    RecyclerView eprecycleview;
    EmergencyPatientAdapter emergencyPatientAdapter;
    private List<EmergencyPatientsPojo> emergencyPatientsPojoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_patient);

        /*initilization*/
        floatemergency = findViewById(R.id.floatemergency);
        //txtepname = findViewById(R.id.txtepname);
        eptoolbar = (Toolbar) findViewById(R.id.eptoolbar);
        setSupportActionBar(eptoolbar);

        eprecycleview = findViewById(R.id.eprecycleview);
        eprecycleview.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        eprecycleview.setLayoutManager(layoutManager);
        eprecycleview.setItemAnimator(new DefaultItemAnimator());
        emergencyPatientAdapter = new EmergencyPatientAdapter(this,emergencyPatientsPojoList,this);

        //intilize the list of refered patients
        emergencypatientdata();
        eprecycleview.setAdapter(emergencyPatientAdapter);

        /*set icon to option menus*/
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        eptoolbar.setOverflowIcon(drawable);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);

        floatemergency.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(EmergencyPatient.this,AddUser.class));
            }
        });

       /* txtepname.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(EmergencyPatient.this,UserHistory.class));

            }
        });*/
    }
    /*OnCreate closed*/
    private void emergencypatientdata()
    {
        EmergencyPatientsPojo  emergencyPatientsPojo = new EmergencyPatientsPojo("11 May 2019","Shaddy","M",5,42,34,34,53);
        emergencyPatientsPojoList.add(emergencyPatientsPojo);

        emergencyPatientsPojo = new EmergencyPatientsPojo("11 May 2018","Shaddy","M",6,200,140,53,40);
        emergencyPatientsPojoList.add(emergencyPatientsPojo);

        emergencyPatientsPojo = new EmergencyPatientsPojo("11  May 2018","Joben","M",6,200,140,53,40);
        emergencyPatientsPojoList.add(emergencyPatientsPojo);

        emergencyPatientsPojo = new EmergencyPatientsPojo("11 May 2018","Salman","M",6,200,140,53,40);
        emergencyPatientsPojoList.add(emergencyPatientsPojo);

        emergencyPatientsPojo = new EmergencyPatientsPojo("11 May 2018","Rohan","M",6,200,140,53,40);
        emergencyPatientsPojoList.add(emergencyPatientsPojo);

        emergencyPatientsPojo = new EmergencyPatientsPojo("11 May 2018","Mayur","M",6,200,140,53,40);
        emergencyPatientsPojoList.add(emergencyPatientsPojo);

        emergencyPatientsPojo = new EmergencyPatientsPojo("11 May 2018","Nayna","F",6,200,140,53,40);
        emergencyPatientsPojoList.add(emergencyPatientsPojo);

        emergencyPatientAdapter.notifyDataSetChanged();


    }


    @Override
    public void onClick(View view)
    {
        /*switch (view.getId())
        {
            case R.id.imgemergency:
                    startActivity(new Intent(EmergencyPatient.this,AddUser.class));
        }
*/
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
