package com.example.user.drgamsystech.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.adapters.RedoxerUserAdapter;
import com.example.user.drgamsystech.pojo.RedoxerUser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RedoxerUsers extends AppCompatActivity
{
    Toolbar rutoolbar,searchtollbar;
    TextView redoxuname;
    FloatingActionButton imgrueradd;
    Menu search_menu;
    MenuItem item_search;
    EditText txtSearch;
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

        setsearchtoolbar();
    }

    //set custom search toolbar
    public void setsearchtoolbar()
    {
        searchtollbar = findViewById(R.id.searchtoolbar);

        if(searchtollbar != null) {
            searchtollbar.inflateMenu(R.menu.menu_search);
            search_menu = searchtollbar.getMenu();

            searchtollbar.setNavigationOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        circleReveal(R.id.searchtoolbar, 1, true, false);
                    else
                        searchtollbar.setVisibility(View.GONE);
                }
            });

            item_search = search_menu.findItem(R.id.action_filter_search);

            MenuItemCompat.setOnActionExpandListener(item_search, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionExpand(MenuItem menuItem) {
                    // Do something when collapsed
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        circleReveal(R.id.searchtoolbar, 1, true, false);
                    } else
                        searchtollbar.setVisibility(View.GONE);
                    return true;
                }

                @Override
                public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    // Do something when expanded
                    return true;
                }
            });
            initSearchView();
        }
        else
        {
            Log.d("toolbar", "setSearchtollbar: NULL");
        }
    }

    //set init serach view for custom serach toolbar
    public void initSearchView()
    {
        //search view initilization
       // SearchView  searchView = (SearchView) search_menu.findItem(R.id.action_filter_search).getActionView();
        SearchView  searchView = (SearchView) search_menu.findItem(R.id.action_filter_search).getActionView();

        // Enable/Disable Submit button in the keyboard
        searchView.setSubmitButtonEnabled(false);

        // Change search close button image

        // set hint and the text colors
       /* txtSearch = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        txtSearch.setHint("Search..");
        txtSearch.setHintTextColor(Color.DKGRAY);
        txtSearch.setTextColor(getResources().getColor(R.color.colorPrimary));
*/
        // set the cursor
        AutoCompleteTextView searchTextView = (AutoCompleteTextView) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        try
        {
            Field mCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            mCursorDrawableRes.setAccessible(true);

            mCursorDrawableRes.set(searchTextView, R.drawable.search); //This sets the cursor resource ID to 0 or @null which will make it visible on white background
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                callSearch(newText);
                return true;
            }

            public void callSearch(String query) {
                //Do searching
                Log.i("query", "" + query);

            }

        });

    }

    //circuleReveal
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void circleReveal(int viewID, int posFromRight, boolean containsOverflow, final boolean isShow)
    {
        final View myView = findViewById(viewID);
        int width=myView.getWidth();

        if(posFromRight>0)

            width-=(posFromRight*getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_material))-(getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_material)/ 2);

        if(containsOverflow)
            width-=getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_overflow_material);
        int cx=width;
        int cy=myView.getHeight()/2;

        Animator anim;
        if(isShow)
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0,(float)width);
        else
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, (float)width, 0);

        anim.setDuration((long)220);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if(!isShow)
                {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.INVISIBLE);
                }
            }
        });

        // make the view visible and start the animation
        if(isShow)
            myView.setVisibility(View.VISIBLE);

        // start the animation
        anim.start();

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
        getMenuInflater().inflate(R.menu.menu_search, menu);

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
