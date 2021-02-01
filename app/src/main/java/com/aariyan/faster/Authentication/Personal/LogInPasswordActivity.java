package com.aariyan.faster.Authentication.Personal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.aariyan.faster.Authentication.AccountType;
import com.aariyan.faster.MainActivity;
import com.aariyan.faster.R;

import static com.aariyan.faster.Common.Common.editor;
import static com.aariyan.faster.Common.Common.sharedPreferences;

public class LogInPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_password);

        initUI();
    }

    private void initUI() {
        findViewById(R.id.logInBtnForPassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInPasswordActivity.this, MainActivity.class));
                //to know who is actually logged in:
                saveLogInStatus();
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        findViewById(R.id.backFromLogInPass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.signUpTextOverLogInPass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInPasswordActivity.this, AccountType.class));
            }
        });
    }

    @SuppressLint("CommitPrefEdits")
    private void saveLogInStatus() {

        sharedPreferences = getSharedPreferences("AuthenticationTypes", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("type","0");
        editor.commit();

    }
}