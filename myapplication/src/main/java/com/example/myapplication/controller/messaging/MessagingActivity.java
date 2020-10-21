package com.example.myapplication.controller.messaging;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MessagingActivity extends AppCompatActivity {
    //simple fragment holder for a chat. only sets content view. this activity is called upon by the previous activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);
    }

}
