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

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.activity.ReferedPatientsDetail;
import com.example.user.drgamsystech.activity.UserHistory;
import com.example.user.drgamsystech.pojo.EmergencyPatientsPojo;

import java.util.List;

public class EmergencyPatientAdapter extends RecyclerView.Adapter<EmergencyPatientAdapter.MyViewHolder>
{
    private List<EmergencyPatientsPojo> emergencyPatientsPojoList;
    private LayoutInflater layoutInflater;
    Activity epactivity;
    /*constructor of Adapter class*/
    public EmergencyPatientAdapter(Context context, List<EmergencyPatientsPojo> emergencyPatientsPojoList, Activity epactivity)
    {
        this.emergencyPatientsPojoList = emergencyPatientsPojoList;
        layoutInflater = LayoutInflater.from(context);
        this.epactivity = epactivity;
    }
    /*viewholder for holding recycleview*/
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView EpDate, EpName, EpTime,EpAge, EpGender,EpSys,EpDia,EpPulse;
        CardView cardemergency;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            EpDate = (TextView) itemView.findViewById(R.id.epdate);
            EpName = (TextView) itemView.findViewById(R.id.epname);
            EpTime = (TextView) itemView.findViewById(R.id.eptime);
            EpAge = (TextView) itemView.findViewById(R.id.epdate);
            EpGender = (TextView) itemView.findViewById(R.id.epgender);
            EpSys = (TextView) itemView.findViewById(R.id.epsys);
            EpDia = (TextView) itemView.findViewById(R.id.epdia);
            EpPulse = (TextView) itemView.findViewById(R.id.eppulse);
            cardemergency = (CardView) itemView.findViewById(R.id.cardemergency);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emergencypatients, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        EmergencyPatientsPojo emergencyPatientsPojo = emergencyPatientsPojoList.get(position);

        holder.EpDate.setText(emergencyPatientsPojo.getEPDate());
        holder.EpName.setText(emergencyPatientsPojo.getEpName());
        holder.EpGender.setText(emergencyPatientsPojo.getEpGender());
        holder.EpAge.setText(emergencyPatientsPojo.getEPDate());
       /* holder.EpSys.setText(emergencyPatientsPojo.getEpsys());
        holder.EpDia.setText(emergencyPatientsPojo.getEpDia());
        holder.EpPulse.setText(emergencyPatientsPojo.getEpPulse());*/


        holder.EpSys.setText(Integer.toString(emergencyPatientsPojo.getEpsys()));
        holder.EpDia.setText(Integer.toString(emergencyPatientsPojo.getEpDia()));
        holder.EpPulse.setText(Integer.toString(emergencyPatientsPojo.getEpPulse()));


        holder.cardemergency.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                epactivity.startActivity(new Intent(epactivity.getApplicationContext(),UserHistory.class));
            }
        });


    }

    @Override
    public int getItemCount()
    {
        return emergencyPatientsPojoList.size();
    }




}
