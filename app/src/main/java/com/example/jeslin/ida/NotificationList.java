package com.example.jeslin.ida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jeslin.ida.AdaptersAndClasses.NotificationClass;
import com.example.jeslin.ida.AdaptersAndClasses.Notification_Adapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationList extends AppCompatActivity {
    List<NotificationClass> notificationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_list);

        getSupportActionBar().setTitle("Notifications");

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.notification_RV);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);



        notificationList=new ArrayList<>();
        initializedata();
        Notification_Adapter adapter=new Notification_Adapter(notificationList);
        recyclerView.setAdapter(adapter);
    }

    public void initializedata()
    {

        notificationList.add(new NotificationClass("Prime minister dead","There are many variations of passages of Lorem","feb 1 2017"));
        notificationList.add(new NotificationClass("Road accident","There are many variations of passages of Lorem ","feb 1 2017"));
        notificationList.add(new NotificationClass("Relicopter landed","There are many variations of passages of Lorem Ipsum available, but the","feb 1 2017"));
    }
}
