package com.example.myapplication.controller.afspraken;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AfspraakDetailActivity extends AppCompatActivity {
    //simple fragment holder for deal details. only sets content view. this activity is called upon by the previous activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afspraak_detail);
    }

}
