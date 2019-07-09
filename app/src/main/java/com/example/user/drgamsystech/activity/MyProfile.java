package com.example.user.drgamsystech.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.R;

import java.net.URI;

public class MyProfile extends AppCompatActivity implements View.OnClickListener
{

    DrawerLayout drmydrawer;
    private ActionBarDrawerToggle myprofileabd;
    NavigationView drmynavigation;
    Toolbar myprotoolbar;
    FloatingActionButton floatmpradd;
    ImageView imgmyrofile;
    TextView mypcpname,mypdocname,myppdname,mypbankname,myptxtname;

    public static final int TAKE_PIC_REQUEST_CODE = 0;
    public static final int CHOOSE_PIC_REQUEST_CODE = 1;
    public static final int MEDIA_TYPE_IMAGE = 2;
    private URI mMediaUri;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profilenew);

        /*Intilization*/

        myprotoolbar = findViewById(R.id.myprotoolbar);
        setSupportActionBar(myprotoolbar);
        myppdname = findViewById(R.id.myppdname);
        imgmyrofile = findViewById(R.id.imgmyrofile);
        floatmpradd = findViewById(R.id.floatmpradd);

        mypbankname = findViewById(R.id.mypbankname);
        mypbankname.setOnClickListener(this);

        mypcpname = findViewById(R.id.mypcpname);
        mypcpname.setOnClickListener(this);

        mypdocname = findViewById(R.id.mypdocname);
        mypdocname.setOnClickListener(this);

        drmydrawer = findViewById(R.id.drmydrawer);
        drmynavigation = findViewById(R.id.drmynavigation);

        myptxtname = findViewById(R.id.myptxtname);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        myprotoolbar.setOverflowIcon(drawable);


        myprofileabd = new ActionBarDrawerToggle(this,drmydrawer,R.string.Open,R.string.Close);
        drmydrawer.addDrawerListener(myprofileabd);
        myprofileabd.syncState();


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);


        //onclicklistner();
        myptxtname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyProfile.this,PersonalProfile.class));
            }
        });


        myppdname.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(),ProfessionalDetails.class));
            }
        });

        drmynavigation.setItemTextColor(new ColorStateList            //to change colour of menus
                (

                        new int [] []
                                {
                                        new int [] {android.R.attr.state_checked},
                                        new int [] {}
                                },
                        new int []
                                {
                                        Color.parseColor("#f8a519"),
                                        // Color.rgb (97, 65, 10),
                                        Color.WHITE
                                }
                ));


        drmynavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int id = menuItem.getItemId();
                menuItem.setCheckable(true);
                drmydrawer.closeDrawers();

                switch (id)
                {

                    case R.id.account:
                        if(id ==R.id.account)
                        {
                            startActivity(new Intent(getApplicationContext(),MyProfile.class));
                        }

                    case R.id.emergencyp:
                        if(id ==R.id.emergencyp)
                        {
                            startActivity(new Intent(getApplicationContext(),EmergencyPatient.class));
                        }
                    case R.id.refp:
                        if(id ==R.id.refp)
                        {
                            startActivity(new Intent(getApplicationContext(),ReferedPatients.class));
                        }
                    case R.id.redxuser:
                        if(id ==R.id.redxuser)
                        {
                            startActivity(new Intent(getApplicationContext(),RedoxerUsers.class));
                        }
                    case R.id.nrp:
                        if(id ==R.id.nrp)
                        {
                            startActivity(new Intent(getApplicationContext(),FollowUp.class));
                        }

                    case R.id.foolowup:
                        if(id ==R.id.foolowup)
                        {
                            startActivity(new Intent(getApplicationContext(),FollowUp.class));
                        }
                    case R.id.earning:
                        if(id ==R.id.earning)
                        {
                            startActivity(new Intent(getApplicationContext(),ExpectedEarnings.class));
                        }

                    case R.id.logout:
                        if(id ==R.id.logout)
                        {

                            Toast.makeText(getApplicationContext(),"Logout Sucessfully",Toast.LENGTH_LONG).show();
                        }
                }
                return true;


            }
        });

    }
    /*on create closed*/
    /*intilization*/


    private void onclicklistner()
    {
        floatmpradd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(),AddUser.class));
            }
        });

        imgmyrofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), "Change Pic Pressed", Toast.LENGTH_SHORT).show();

                //show dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MyProfile.this);
                builder.setTitle("Upload or Take a photo");
                builder.setPositiveButton("Upload", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //upload image
                        Intent choosePictureIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        choosePictureIntent.setType("image/*");
                        startActivityForResult(choosePictureIntent, CHOOSE_PIC_REQUEST_CODE);

                      //  mSaveChangesBtn.setEnabled(true);

                    }
                });
                builder.setNegativeButton("Take Photo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //take photo
                        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //mMediaUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
                        if (mMediaUri == null) {
                            //display error
                            Toast.makeText(getApplicationContext(), "Sorry there was an error! Try again.", Toast.LENGTH_LONG).show();

                            // mSaveChangesBtn.setEnabled(false);

                        } else {
                            takePicture.putExtra(MediaStore.EXTRA_OUTPUT, mMediaUri);
                            startActivityForResult(takePicture, TAKE_PIC_REQUEST_CODE);

                            //mSaveChangesBtn.setEnabled(true);
                        }
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });

        /*on click on professional details*/

        //show exapandable image


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

    @Override
    public void onClick(View view)
    {
        TextView t =(TextView) view;
        switch(t.getId())
        {
            case R.id.mypcpname:

                startActivity(new Intent(getApplicationContext(),ChangePassword.class));
                break;


            case R.id.mypdocname:
                startActivity(new Intent(getApplicationContext(),UploadDocuments.class));
                break;

            case R.id.mypbankname:
                startActivity(new Intent(getApplicationContext(),BankDetails.class));
                break;
        }

    }
}
