package com.example.jeslin.ida.AdaptersAndClasses;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeslin.ida.ViewPages.NewsViewDetails;
import com.example.jeslin.ida.R;

import java.util.List;

/**
 * Created by JeSLiN on 07-09-2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<News> newsList;
    public NewsAdapter(List<News> newsList)
    {
        this.newsList=newsList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_events_adapter_layout,viewGroup,false);
        NewsAdapter.NewsViewHolder phold=new NewsAdapter.NewsViewHolder(view);
        return phold;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.NewsViewHolder holder,final int position) {
        holder.Title.setText(newsList.get(position).title);
        holder.Desc.setText(newsList.get(position).desc);
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

                Toast.makeText(v.getContext(),"Pos : "+newsList.get(position).title,Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(v.getContext(),NewsViewDetails.class);
                v.getContext().startActivity(intent1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {


        CardView cv;
        TextView Title,Desc;


        NewsViewHolder(View view)
        {
            super(view);


            cv=(CardView)view.findViewById(R.id.cardnews);
            Title=(TextView)view.findViewById(R.id.newstitle);
            Desc=(TextView)view.findViewById(R.id.news_desc);

        }
    }
}
