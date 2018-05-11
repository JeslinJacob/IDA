package com.example.jeslin.ida.AdaptersAndClasses;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeslin.ida.R;

import java.util.List;

/**
 * Created by JeSLiN on 08-09-2017.
 */

public class Notification_Adapter  extends RecyclerView.Adapter<Notification_Adapter.NotificationViewHolder> {
    List<NotificationClass> notificationList;
    public Notification_Adapter(List<NotificationClass> notificationList)
    {
        this.notificationList=notificationList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public Notification_Adapter.NotificationViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notification_adapter,viewGroup,false);
        Notification_Adapter.NotificationViewHolder phold=new Notification_Adapter.NotificationViewHolder(view);
        return phold;
    }

    @Override
    public void onBindViewHolder(Notification_Adapter.NotificationViewHolder holder,final int position) {
        holder.Title.setText(notificationList.get(position).title);
        holder.Desc.setText(notificationList.get(position).desc);
        holder.time.setText(notificationList.get(position).time);
        holder.cv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                switch (position){
//                    case 0:
//                        Toast.makeText(v.getContext(),"Pos : "+newsList.get(position).title,Toast.LENGTH_SHORT).show();
////                        Intent intent1=new Intent(v.getContext(),MemberView.class);
////                        v.getContext().startActivity(intent1);
//                        break;
//                    case 1:
//                        Toast.makeText(v.getContext(),"Pos : "+newsList.get(position).title,Toast.LENGTH_SHORT).show();
////                        Intent intent1=new Intent(v.getContext(),SunfeastActivity.class);
////                        v.getContext().startActivity(intent1);
//                        break;
//                    case 2:
//                        Toast.makeText(v.getContext(),"Pos : "+newsList.get(position).title,Toast.LENGTH_SHORT).show();
//                        break;
//
//                }

                Toast.makeText(v.getContext(),"Pos : "+notificationList.get(position).title,Toast.LENGTH_SHORT).show();
//                Intent intent1=new Intent(v.getContext(),NewsViewDetails.class);
//                v.getContext().startActivity(intent1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {


        CardView cv;
        TextView Title,Desc,time;


        NotificationViewHolder(View view)
        {
            super(view);


            cv=(CardView)view.findViewById(R.id.n_card);
            Title=(TextView)view.findViewById(R.id.n_titile);
            Desc=(TextView)view.findViewById(R.id.n_desc);
            time=(TextView)view.findViewById(R.id.n_timetxt);
        }
    }}