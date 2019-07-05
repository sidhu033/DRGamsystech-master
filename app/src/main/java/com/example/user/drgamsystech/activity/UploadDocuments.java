package com.example.user.drgamsystech.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.drgamsystech.R;

public class UploadDocuments extends AppCompatActivity implements View.OnClickListener
{
    Button btnulag, btnuldoc1, btnuldoc2, btnuldoc3;
    Toolbar udtoolbar;
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_documents);


        initilization();

    }
    //on create closed

    private void initilization()
    {

        udtoolbar = findViewById(R.id.udtoolbar);
        setSupportActionBar(udtoolbar);

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_dot_menu);
        udtoolbar.setOverflowIcon(drawable);

        /*initlization*/
      btnulag = findViewById(R.id.btnulag);
        btnuldoc1 = findViewById(R.id.btnuldoc1);
        btnuldoc2 = findViewById(R.id.btnuldoc2);
        btnuldoc3 = findViewById(R.id.btnuldoc3);

        setSupportActionBar(udtoolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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



    @Override
    public void onClick(View view)
    {
        /*Button ud = (Button) view;

        switch (ud.getId())
        {
            case R.id.btnulag:
            {
                Toast.makeText(getApplicationContext(), "Upload Agreement sucessfully", Toast.LENGTH_LONG).show();
                break;
            }

            case R.id.btnuldoc1:

                Toast.makeText(getApplicationContext(), "Upload Documents 1 Sucessfully", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnuldoc2:

                Toast.makeText(getApplicationContext(), "Upload Documents 2 Sucessfully", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnuldoc3:

                Toast.makeText(getApplicationContext(), "Upload Documents 3 Sucessfully", Toast.LENGTH_LONG).show();
                break;
        }*/

    }
}

