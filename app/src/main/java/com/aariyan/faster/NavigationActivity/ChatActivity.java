package com.aariyan.faster.NavigationActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.aariyan.faster.Fragment.InboxFragment;
import com.aariyan.faster.Fragment.RequestFragment;
import com.aariyan.faster.R;
import com.google.android.material.tabs.TabLayout;

public class ChatActivity extends AppCompatActivity {

    //Tab layout for Request and Inbox:
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initUI();
    }

    //instantiate the UI:
    private void initUI() {

        //instantiate the tab layout:
        tabLayout = findViewById(R.id.tabLayout);

        //starting the default fragment:
        startFragment(new RequestFragment());

        //tab action event:
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {



                //confirming the tab position:
                //First tab if 0:
                if(tab.getPosition() == 0) {
                    startFragment(new RequestFragment());
                }

                //second tab if 1
                if(tab.getPosition() == 1) {
                    startFragment(new InboxFragment());
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        //go to the parent:
        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    //entrenched the default and selected fragment:
    private void startFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, fragment).commit();
    }
}