package com.example.myapplication.controller.advertentie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AdvertDetailActivity extends AppCompatActivity {
    //simple fragment holder for advert details. only sets content view. this activity is called upon by the previous activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert_detail);
    }

}
