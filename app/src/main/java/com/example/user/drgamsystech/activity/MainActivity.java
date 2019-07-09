package com.example.user.drgamsystech.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.FontsContract;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.Fragment.ExpectedEarningFragment;
import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.adapters.MenusAdapter;
import com.example.user.drgamsystech.pojo.MenuVo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.mtoolbar)
    android.support.v7.widget.Toolbar mtoolbar;
  /*  @BindView(R.id.recMenus)*/
    RecyclerView recMenus;
    private DrawerLayout drdrawer;
    private ActionBarDrawerToggle drabardrawertog;
    private NavigationView drnavigation;
    private TextView txtnewdate,doctorretd;
    FloatingActionButton floatingActionButton;
    CardView cardmainappbar;

    List<MenuVo> mMenuList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);

        //intilize menus items in card view
        initializeMenuItemList();
        //recycle view menus for viewing all menus

        recMenus = findViewById(R.id.recMenus);
        recMenus.setLayoutManager( new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));

        MenusAdapter adapter = new MenusAdapter(mMenuList, this);
        recMenus.setAdapter(adapter);

        recMenus =(RecyclerView) findViewById(R.id.recMenus);
        setSingleEvent(recMenus);


        /*Intilizing of components*/

        mtoolbar = findViewById(R.id.mtoolbar);
        setSupportActionBar(mtoolbar);
        mtoolbar.setNavigationIcon(R.drawable.gham);

         //*action bar drawer toggle*//*
       // cardmainappbar = findViewById(R.id.cardmainappbar);
//        cardmainappbar.setBackgroundResource(R.drawable.card_view_bg);
        doctorretd  = findViewById(R.id.doctorretd);

        /*Toolbar of dr */
        floatingActionButton = findViewById(R.id.imgmainadd);
        drdrawer = findViewById(R.id.drdrawer);

        drabardrawertog = new ActionBarDrawerToggle(this,drdrawer,R.string.Open,R.string.Close);
        drdrawer.addDrawerListener(drabardrawertog);
        drabardrawertog.syncState();

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);



        /*set icon to option menus*/
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.right_dot_menu);
        mtoolbar.setOverflowIcon(drawable);

        /*Navigation view*/
        drnavigation = findViewById(R.id.drnavigation);
        NavigationMenuView drmenuView = (NavigationMenuView) drnavigation.getChildAt(0);
        drmenuView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        drnavigation.setItemTextColor(new ColorStateList            //to change colour of menus
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

        doctorretd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,ReferedPatients.class));
            }
        });
        drnavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int id = menuItem.getItemId();
                menuItem.setCheckable(true);
                drdrawer.closeDrawers();

                switch (id)
                {

                    case R.id.account:
                        if(id ==R.id.account)
                        {
                            Fragment fragment = new ExpectedEarningFragment();
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

        /* set on click on floating button*/
        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,AddUser.class));
            }
        });

        /*setting date to navigation view*/
        View headerview = drnavigation.getHeaderView(0);
        String Date= DateFormat.getDateTimeInstance().format(new Date());
        txtnewdate= headerview.findViewById(R.id.txtnewdate);
        txtnewdate.setText(Date);
        txtnewdate.setTextColor(Color.WHITE);

        String[] results = Date.split(" ",2);
        results[0] = results[0].trim();


    }
    //on create closed
    private void setSingleEvent(RecyclerView recyclerView)
    {
        for(int i = 0 ;i < recMenus.getChildCount();i++)
        {
            GridLayout gridLayout = (GridLayout) recMenus.getChildAt(i);
            final int finalI = i;


        }

    }
    private void initializeMenuItemList()
    {
        if(mMenuList == null)
        {
            mMenuList = new ArrayList<MenuVo>();
            mMenuList.add(new MenuVo("56","REFERED PATIENTS"));
            mMenuList.add(new MenuVo("2","REDXOER USERS"));

            mMenuList.add(new MenuVo("38","FOLLOW UPS"));
            mMenuList.add(new MenuVo("13","EMERGENCY PATIENTS"));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu )
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.right_menu, menu);

        //changing the color of menus items
        int positionOfMenuItem = 0; // or whatever...
        MenuItem item = menu.getItem(positionOfMenuItem);
        SpannableString s = new SpannableString("My red MenuItem");
        s.setSpan(new ForegroundColorSpan(Color.RED), 0, s.length(), 0);
        item.setTitle(s);

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




  /*  @Override
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
*/
}
