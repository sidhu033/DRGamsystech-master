package com.example.user.drgamsystech.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.utils.Constants;
import com.example.user.drgamsystech.utils.DateTimeFormater;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.example.user.drgamsystech.utils.Constants.*;

import static com.example.user.drgamsystech.utils.Constants.CAMERA_PIC_REQUEST;

public class PersonalProfile extends AppCompatActivity
{
    //declaration
    ImageView dolimgview ,imgmyrofile;

    File imageFile;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_profile);
        /*   setContentView(R.layout.activity_my_profilenew);*/

        /*initlization*/
        initilization();
        onclicklistner();
    }


    private void initilization()
    {
        dolimgview = findViewById(R.id.dolimgview);
        imgmyrofile = findViewById(R.id.imgmyrofile);
    }

    /*onclick listner*/
    private void onclicklistner()
    {
        dolimgview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });


        imgmyrofile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_PIC_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode == CAMERA_PIC_REQUEST)
        {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imgmyrofile.setImageBitmap(image);
            imageFile  = getFile(image,DateTimeFormater.getCurrentTime());
        }
    }


    private File getFile(Bitmap bitmapimg,String filename)
    {
        File f = new File(Environment.getExternalStorageDirectory() + "/" + File.separator + filename+".png");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //        File f = new File(path, filename);

        //f.createNewFile(); (No need to call as FileOutputStream will automatically create the file)

        //Convert bitmap to byte array
        Bitmap bitmap = bitmapimg;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

        //write the bytes in file
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return f;
    }
}
