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
import android.widget.TextView;

import com.example.user.drgamsystech.activity.FollowupDetails;
import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.activity.ReferedPatientsDetail;
import com.example.user.drgamsystech.pojo.Follouppojo;

import java.util.List;

public class FollowUpAdapter extends RecyclerView.Adapter<FollowUpAdapter.MyViewHolder>
{
    private List<Follouppojo> follouppojoList;
    private LayoutInflater inflater;
    Activity fuactivity;
    /*follow up adapter constructor*/
    public FollowUpAdapter(Context context, List<Follouppojo> follouppojoList, Activity fuactivity)
    {
        inflater = LayoutInflater.from(context);
        this.follouppojoList = follouppojoList;
        this.fuactivity = fuactivity;
    }

    public class  MyViewHolder extends  RecyclerView.ViewHolder
    {
        public TextView fDate, fName, fstatus;
        public CardView cardfolpatient;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            //intilization
            fDate = (TextView) itemView.findViewById(R.id.txtfudate);
            fName = (TextView) itemView.findViewById(R.id.txtfuname);
            fstatus = (TextView) itemView.findViewById(R.id.txtfustatus2);
            cardfolpatient = itemView.findViewById(R.id.cardfolpatient);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.followup, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Follouppojo follouppojo = follouppojoList.get(position);
        holder.fDate.setText(follouppojo.getfDate());
        holder.fName.setText(follouppojo.getfName());
        holder.fstatus.setText(follouppojo.getFstatus());
        holder.cardfolpatient.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                fuactivity.startActivity(new Intent(fuactivity.getApplicationContext(),FollowupDetails.class));
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return follouppojoList.size();
    }





}
