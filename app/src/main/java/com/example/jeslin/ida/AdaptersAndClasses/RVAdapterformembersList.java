package com.example.jeslin.ida.AdaptersAndClasses;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeslin.ida.ViewPages.MemberView;
import com.example.jeslin.ida.R;

import java.util.List;


/**
 * Created by JeSLiN on 03-07-2017.
 */


public class RVAdapterformembersList extends RecyclerView.Adapter<RVAdapterformembersList.PersonViewHolder> {
    List<MemberClass> persons;
    Context context;
   public RVAdapterformembersList(Context context, List<MemberClass> persons)
    {
        this.context = context;
        this.persons=persons;

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RVAdapterformembersList.PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.membersadapterlayout,viewGroup,false);
        PersonViewHolder phold=new PersonViewHolder(view);
        return phold;
    }

    @Override
    public void onBindViewHolder(RVAdapterformembersList.PersonViewHolder holder,final int position) {
        holder.PersonName.setText(persons.get(position).getFullname());
        holder.PersonAge.setText(persons.get(position).getAddress());
        holder.cv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                      Toast.makeText(v.getContext(),"Pos : "+persons.get(position).getFullname(),Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(v.getContext(),MemberView.class);
                        v.getContext().startActivity(intent1);


            }
        });


    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {


        CardView cv;
        TextView PersonName,PersonAge;


        PersonViewHolder(View view)
        {
            super(view);


            cv=(CardView)view.findViewById(R.id.cv);
            PersonName=(TextView)view.findViewById(R.id.nametxt);
            PersonAge=(TextView)view.findViewById(R.id.descriptiontxt);

        }
    }
}
