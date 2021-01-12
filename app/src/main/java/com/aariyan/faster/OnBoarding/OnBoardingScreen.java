package com.aariyan.faster.OnBoarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aariyan.faster.R;


//For showing the OnBoarding Screen after ending the SplashScreen:
public class OnBoardingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);
    }
}