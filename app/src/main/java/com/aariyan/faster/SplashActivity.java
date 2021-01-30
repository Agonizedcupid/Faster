package com.aariyan.faster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

import com.aariyan.faster.Authentication.AccountType;
import com.aariyan.faster.Common.Common;
import com.aariyan.faster.OnBoarding.OnBoardingScreen;


//Splash Activity to show the Splash Scree:
// Using the direct images for showing the screen:
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        //Instantiate the SharedPreference to keep track the OnBoarding screen showing:
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        //to awake the Splash screen for few second using Thread:
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Checking whether OnBoarding scree already shown to the user or not:
                // if, true then already shown to the user
                //if, false then not shown yet to the user
                if (!sharedPreferences.getBoolean(Common.onBoardingCompletedStatus, false)) {

                    //First time showing the Screen to the user:
                    startActivity(new Intent(SplashActivity.this, OnBoardingScreen.class));
                    //Removing from the backStack, therefore it will come back :
                } else {
                    //if false, that means, Screen already shown
                    //It not show then redirect to the MainActivity:
                    startActivity(new Intent(SplashActivity.this, AccountType.class));
                    //Removing from the backStack, therefore it will come back :
                }

                //startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();

            }
        }, 1000);
    }
}