package com.aariyan.faster.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.aariyan.faster.Common.Common;
import com.aariyan.faster.R;

public class AccountType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);

        SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(AccountType.this).edit();
        sharedPreferencesEditor.putBoolean(
                Common.onBoardingCompletedStatus, true);
        sharedPreferencesEditor.apply();

        initUI();
    }

    private void initUI() {

        findViewById(R.id.backFromTypeSelection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });

        findViewById(R.id.logInTextOverTypeSelection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountType.this,LogInActivity.class));
            }
        });

        findViewById(R.id.personalTypeSelectionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountType.this, SignUpActivity.class));
                findViewById(R.id.personalTypeSelectionButton).setBackgroundResource(R.drawable.button_background);
            }
        });

        findViewById(R.id.businessTypesSelectionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountType.this, SignUpActivity.class));
                findViewById(R.id.businessTypesSelectionButton).setBackgroundResource(R.drawable.button_background);
            }
        });
    }
}