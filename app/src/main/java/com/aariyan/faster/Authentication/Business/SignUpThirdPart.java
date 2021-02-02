package com.aariyan.faster.Authentication.Business;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aariyan.faster.MainActivity;
import com.aariyan.faster.R;

import static com.aariyan.faster.Common.Common.editor;
import static com.aariyan.faster.Common.Common.sharedPreferences;

public class SignUpThirdPart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_third_part);

        initUi();
    }

    private void initUi() {
        findViewById(R.id.continueBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLogInStatus();
                startActivity(new Intent(SignUpThirdPart.this, MainActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
            }
        });

        findViewById(R.id.skipBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLogInStatus();
                startActivity(new Intent(SignUpThirdPart.this, MainActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
            }
        });
    }

    @SuppressLint("CommitPrefEdits")
    private void saveLogInStatus() {

        sharedPreferences = getSharedPreferences("AuthenticationTypes", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("type","1");
        editor.commit();

    }
}