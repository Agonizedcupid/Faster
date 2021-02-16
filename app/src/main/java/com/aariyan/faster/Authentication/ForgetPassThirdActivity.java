package com.aariyan.faster.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aariyan.faster.Authentication.Personal.LogInActivity;
import com.aariyan.faster.R;

public class ForgetPassThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_third);

        initUI();
    }

    private void initUI() {
        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.confirmBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassThirdActivity.this, LogInActivity.class));
                finish();
            }
        });

        findViewById(R.id.logInBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassThirdActivity.this, LogInActivity.class));
                finish();
            }
        });
    }
}