package com.example.user.drgamsystech.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.activity.RedoxerUserDetails;
import com.example.user.drgamsystech.pojo.RedoxerUser;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

public class RedoxerUserAdapter extends RecyclerView.Adapter<RedoxerUserAdapter.MyViewHolder>
{
    private List<RedoxerUser> redoxerUserslist;
    private LayoutInflater layoutInflater;
    Activity activity;
    private final static int FADE_DURATION = 1000; //FADE_DURATION in milliseconds


    /*constructor of RedoxerUserAdapter*/
    public RedoxerUserAdapter(Context context,List<RedoxerUser> redoxerUserslist,Activity activity)
    {
        this.redoxerUserslist = redoxerUserslist;
        layoutInflater = LayoutInflater.from(context);
        this.activity = activity;
    }
    //MyView Holder class extends viewholder method
    public class MyViewHolder extends ViewHolder
    {
        public TextView name,age,gender;
        public ImageView image;
        public CardView card_viewredoxer;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            /*Initlilization*/
            image =  itemView.findViewById(R.id.imgruprofile);
            name = (TextView) itemView.findViewById(R.id.redoxuname);
            age = (TextView) itemView.findViewById(R.id.redoxuage);
            gender = (TextView) itemView.findViewById(R.id.redoxugender);
            card_viewredoxer = itemView.findViewById(R.id.card_viewredoxer);


        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //inilization of layout with adapter in view
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.redoxerusers, parent,false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position)
    {
        //mapping with redoxer user pojo with viewholder
        RedoxerUser redoxerUser = redoxerUserslist.get(position);
        myViewHolder.image.setBackgroundResource(redoxerUser.getImage());
        myViewHolder.name.setText(redoxerUser.getName());
        myViewHolder.age.setText(redoxerUser.getAge());
        myViewHolder.gender.setText(redoxerUser.getGender());
        setFadeAnimation(myViewHolder.itemView);
       
        myViewHolder.card_viewredoxer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                activity.startActivity(new Intent(activity.getApplicationContext(),RedoxerUserDetails.class));
            }
        });
    }

    private void setFadeAnimation(View itemView)
    {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        itemView.startAnimation(anim);
    }

    @Override
    public int getItemCount()
    {
        return redoxerUserslist.size();
    }
}
