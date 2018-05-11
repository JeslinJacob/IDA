package com.example.jeslin.ida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        getSupportActionBar().hide();
    }
    public void login(View v)
    {
        Intent intent= new Intent(this,HomePage.class);
        startActivity(intent);
    }
}
