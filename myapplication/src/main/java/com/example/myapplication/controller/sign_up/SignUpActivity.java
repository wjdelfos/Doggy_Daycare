package com.example.myapplication.controller.sign_up;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SignUpActivity extends AppCompatActivity {
    //simple fragment holder for the sign up page. only sets content view. this activity is called upon by the previous activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }

}
