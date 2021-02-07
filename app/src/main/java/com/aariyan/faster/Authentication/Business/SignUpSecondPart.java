package com.aariyan.faster.Authentication.Business;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aariyan.faster.Adapter.BusinessIndustryAdapter;
import com.aariyan.faster.MainActivity;
import com.aariyan.faster.Model.BusinessIndustriesModel;
import com.aariyan.faster.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class SignUpSecondPart extends AppCompatActivity {

    private ImageView selectBusinessIndustry;
    public static BottomSheetBehavior bottomSheetBehavior;
    View bottomSheet;

    BusinessIndustryAdapter adapter;
    private RecyclerView recyclerView;

    private List<BusinessIndustriesModel> list = new ArrayList<>();
    private String[] businessList = {"A","B","C","D","E","F"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_second_part);

        initUI();

        loadBusinessName();
    }

    private void loadBusinessName() {
        list.clear();

        for (int i = 0; i<businessList.length; i++) {
            list.add(new BusinessIndustriesModel(
                    i,businessList[i]
            ));
        }

        adapter = new BusinessIndustryAdapter(this,list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initUI() {

        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        recyclerView = findViewById(R.id.industriesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bottomSheet = findViewById(R.id.bottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        findViewById(R.id.closeBottomSheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        selectBusinessIndustry = findViewById(R.id.selectBusinessIndustry);
        selectBusinessIndustry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        findViewById(R.id.continueBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpSecondPart.this,SignUpThirdPart.class));
                overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
            }
        });

        findViewById(R.id.skipBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpSecondPart.this, SignUpThirdPart.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
            }
        });
    }
}