package com.aariyan.faster.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aariyan.faster.Authentication.Personal.LogInActivity;
import com.aariyan.faster.R;

public class ForgetPassSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_second);

        initUI();
    }

    private void initUI() {
        findViewById(R.id.resetPasswordSendBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassSecondActivity.this,ForgetPassThirdActivity.class));
            }
        });

        findViewById(R.id.logInBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassSecondActivity.this, LogInActivity.class));
                finish();
            }
        });
    }
}