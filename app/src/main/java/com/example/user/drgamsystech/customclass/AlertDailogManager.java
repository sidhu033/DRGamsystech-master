package com.example.user.drgamsystech.customclass;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;

import com.example.user.drgamsystech.R;

public class AlertDailogManager
{
    public  void  showAlertDialog(Context context,String title,String message, Boolean status)
    {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        alertDialog.setTitle(title);            // Setting Dialog Title
        alertDialog.setMessage(message);        // Setting Dialog Message

        if(status != null)
            // Setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.arrow: R.drawable.gham);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener()
        {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
         alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.YELLOW);
            }
        });
                // Showing Alert Message
                alertDialog.show();
    }
}
