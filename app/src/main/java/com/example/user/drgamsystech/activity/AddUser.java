package com.example.user.drgamsystech.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.databasehelper.DatabaseHelper;
import com.example.user.drgamsystech.pojo.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class AddUser extends AppCompatActivity {
    Button btnad;
    EditText eduname, edemail, edumobile, edualtmob, edupincode, eduhouseno,edustreet,eduarea,educity,edustate;
    Toolbar adutoolbar;
    User user;

    String uname ,uemail, umobile,ualmobile,upincode,uhouseno,ustreet,uarea,ucity,ustate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        /*Initilization*/

        initilization();
        //onclicklistner();




    }
//close user

    private void initilization()
    {

        btnad = findViewById(R.id.btnad);
        eduname = findViewById(R.id.eduname);
        edemail = findViewById(R.id.edemail);
        edumobile = findViewById(R.id.edumobile);
        edualtmob = findViewById(R.id.edualtmob);
        edupincode = findViewById(R.id.edupincode);
        eduhouseno = findViewById(R.id.eduhouseno);
        eduarea = findViewById(R.id.eduarea);
        educity = findViewById(R.id.educity);
        edustate = findViewById(R.id.edustate);
        edustreet = findViewById(R.id.edustreet);
        user = new User();

        adutoolbar = (Toolbar) findViewById(R.id.adutoolbar);
        setSupportActionBar(adutoolbar);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_dot_menu);
        adutoolbar.setOverflowIcon(drawable);
    }


    private void onclicklistner()
    {
        btnad.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
              //  adduserdatabase();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.right_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.Help:
                Toast.makeText(getApplicationContext(), "Help Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Support:
                Toast.makeText(getApplicationContext(), "Support Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Contact:
                Toast.makeText(getApplicationContext(), "Contact Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //save to internal storage
    public void save(View view) throws IOException
    {
        File file = null;
        uname  =eduname.getText().toString();
        uemail =edemail.getText().toString();
        umobile =edumobile.getText().toString();
        ualmobile= edualtmob.getText().toString();
        upincode = edupincode.getText().toString();
        uhouseno = eduhouseno.getText().toString();
        uarea = eduarea.getText().toString();
        ucity = educity.getText().toString();
        ustate = edustate.getText().toString();
        ustreet=  edustreet.getText().toString();
        FileOutputStream fileOutputStream = null;
        try
        {
            file= getFilesDir();
            fileOutputStream = openFileOutput("User.txt",Context.MODE_PRIVATE);
            fileOutputStream.write(uname.getBytes());
            fileOutputStream.write(uemail.getBytes());
            fileOutputStream.write(umobile.getBytes());
            fileOutputStream.write(ualmobile.getBytes());
            fileOutputStream.write(upincode.getBytes());
            fileOutputStream.write(uhouseno.getBytes());
            fileOutputStream.write(uarea.getBytes());
            fileOutputStream.write(ustreet.getBytes());
            fileOutputStream.write(ucity.getBytes());
            fileOutputStream.write(ustate.getBytes());
            Toast.makeText(this, "Saved \n" + "Path --" + file + "\t User.txt", Toast.LENGTH_SHORT).show();
            /*eduname.setText(" ");
            edemail.setText(" ");
            edumobile.setText(" ");
            edualtmob.setText(" ");
            edupincode.setText(" ");
            eduhouseno.setText(" ");
            eduarea.setText(" ");
            edustreet.setText("");
            educity.setText(" ");
            edustate.setText(" ");*/
            return;
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
        finally
        {
            fileOutputStream.close();
        }

    }

    public void show(View view)
    {
        Intent intent= new Intent(this, RedoxerUserDetails.class);
        startActivity(intent);
    }

    //save using sqllite
    private void adduserdatabase()
    {
        DatabaseHelper dbUser = new DatabaseHelper(getApplicationContext());
        dbUser.addUser(user);
        Toast.makeText(this, "User Added Suceessfully", Toast.LENGTH_LONG).show();
    }
}
