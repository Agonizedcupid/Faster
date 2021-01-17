package com.aariyan.faster.Authentication.Personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.aariyan.faster.Authentication.Business.SignUpSecondPart;
import com.aariyan.faster.MainActivity;
import com.aariyan.faster.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    private String checkAccountType = "";

    private TextInputLayout emailEditTextHint,phoneNumberLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        if (getIntent() != null) {
            checkAccountType = getIntent().getStringExtra("accountType");
        }

        initUI();
    }

    private void initUI() {

        emailEditTextHint = findViewById(R.id.emailLayout);
        phoneNumberLayout = findViewById(R.id.phoneNumberLayout);
        if (checkAccountType.equals("Personal")) {
            emailEditTextHint.setHint("Email");
            phoneNumberLayout.setVisibility(View.VISIBLE);
        } else {
            emailEditTextHint.setHint("Business Email");
            phoneNumberLayout.setVisibility(View.GONE);
        }

        findViewById(R.id.backFromSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        findViewById(R.id.logInTextOverSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
            }
        });

        findViewById(R.id.signUpBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkAccountType.equals("Personal")) {
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SignUpActivity.this, SignUpSecondPart.class));
                }

                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }
}