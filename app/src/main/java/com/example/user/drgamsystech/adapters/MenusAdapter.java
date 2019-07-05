package com.example.user.drgamsystech.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.drgamsystech.R;
import com.example.user.drgamsystech.activity.EmergencyPatient;
import com.example.user.drgamsystech.activity.FollowUp;
import com.example.user.drgamsystech.activity.ReferedPatients;
import com.example.user.drgamsystech.activity.RedoxerUsers;
import com.example.user.drgamsystech.pojo.MenuVo;

import java.util.List;

import butterknife.ButterKnife;

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MenusHolder>
{
    private Activity mactivity;
    private List<MenuVo> mMenuList ;            //list of type MenuVo pojo
    TextView img;

    /*Constructor*/
    public MenusAdapter(List<MenuVo> mMenuList ,Activity mactivity)
    {
        this.mactivity = mactivity;
        this.mMenuList = mMenuList;
    }

    @NonNull
    @Override
    public MenusHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        //bind layout menus
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutmenusnew,viewGroup,false);
        return new MenusHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MenusHolder viewholder, final int position)
    {
        MenuVo menuVo = mMenuList.get(position);

        viewholder.img.setText(menuVo.img);
        viewholder.txtImgName.setText(menuVo.imgName);

        viewholder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(position == 0)
                {
                    Intent intent = new Intent(mactivity.getApplicationContext(),ReferedPatients.class);
                    mactivity.startActivity(intent);
                }


                if(position == 1)
                {
                    Intent intent = new Intent(mactivity.getApplicationContext(),RedoxerUsers.class);
                    mactivity.startActivity(intent);
                }
                if(position == 2)
                {
                    Intent intent = new Intent(mactivity.getApplicationContext(),FollowUp.class);
                    mactivity.startActivity(intent);
                }
                if(position == 3)
                {
                    Intent intent = new Intent(mactivity.getApplicationContext(),EmergencyPatient.class);
                    mactivity.startActivity(intent);
                }
            }
        });
    }

    @NonNull
    @Override
    public int getItemCount()
    {

        return mMenuList.size();
    }

    /*Annonymous class*/

    public class MenusHolder extends RecyclerView.ViewHolder
    {

        /*@BindView(R.id.img)*/
        TextView img;

      /*  @BindView(R.id.txtImgName)*/
        TextView txtImgName;
        public MenusHolder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);

            img = itemView.findViewById(R.id.img);
            txtImgName = itemView.findViewById(R.id.txtImgName);
        }
    }
}
