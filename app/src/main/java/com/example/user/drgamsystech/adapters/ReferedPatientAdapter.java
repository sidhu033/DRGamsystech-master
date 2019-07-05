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
import com.example.user.drgamsystech.pojo.Referedpatients;
import java.util.List;

public class ReferedPatientAdapter extends RecyclerView.Adapter<ReferedPatientAdapter.MyViewHolder>
{
    private List<Referedpatients> referedpatientsList;
    private LayoutInflater inflater;
    private Activity rpactivity;
    public ReferedPatientAdapter(Context context,List<Referedpatients> referedpatientsList,Activity rpactivity)
    {
        inflater = LayoutInflater.from(context);
        this.referedpatientsList = referedpatientsList;
        this.rpactivity = rpactivity;
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder
    {
        public TextView Date, Name, status,status2;
        public CardView cardrefpatient;

        public MyViewHolder(@NonNull View view)
        {
            super(view);
            //intilization
            Date = (TextView) view.findViewById(R.id.txtrpdate);
            Name = (TextView) view.findViewById(R.id.txtrpname);
            // status = (TextView) view.findViewById(R.id.txtrpstatus);
            status2 = (TextView) view.findViewById(R.id.txtrpstatus2);
            cardrefpatient = view.findViewById(R.id.cardrefpatient);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.referedpatients, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position)
    {
        Referedpatients referedpatients = referedpatientsList.get(position);
        holder.Date.setText(referedpatients.getDate());
        holder.Name.setText(referedpatients.getName());
        holder.status2.setText(referedpatients.getStatus2());


        holder.cardrefpatient.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rpactivity.startActivity(new Intent(rpactivity.getApplicationContext(),ReferedPatientsDetail.class));
            }
        });
    }


    @Override
    public int getItemCount()
    {
        return referedpatientsList.size();
    }
}
