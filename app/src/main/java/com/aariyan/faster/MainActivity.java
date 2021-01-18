package com.aariyan.faster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.aariyan.faster.Common.Common;

public class MainActivity extends AppCompatActivity {

    //main layout, containing first Mode menu:
    private RelativeLayout modeLayout;
    //Layout that contain all the menu list:
    private LinearLayout expandedModeMenu;
    //For Collapsing the expanded Mode menu:
    private ImageView collapseExpandedModeMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
        sharedPreferencesEditor.putBoolean(
                Common.onBoardingCompletedStatus, true);
        sharedPreferencesEditor.apply();

        initUI();
    }

    private void initUI() {
        //Main menu instantiation:
        modeLayout = findViewById(R.id.modeLayout);
        //List of menu layout instantiate:
        expandedModeMenu = findViewById(R.id.expandedModeMenu);
        //collapsing button instantiate:
        collapseExpandedModeMenu = findViewById(R.id.collapseExpandedModeMenu);

        //OnAction Event for all the layout:
        //it's triggers time:
        modeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This is the only layout that should be visible
                //after it's triggers, make it Invisible to show the expanded menu list:
                modeLayout.setVisibility(View.GONE);
                //this will be visible and will show all the menu to perform
                expandedModeMenu.setVisibility(View.VISIBLE);
                //this is a button for triggering or collapsing the expanded menu:
                collapseExpandedModeMenu.setVisibility(View.VISIBLE);
            }
        });

        //Triggers when you need to collapse all the menu:
        collapseExpandedModeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This is the only layout that should be visible
                //This is the main menu or the first menu or the menu to expand the further menu:
                modeLayout.setVisibility(View.VISIBLE);
                //Contains all the menu in this layout:
                //when collapse, remove all the menu list and make visible the first menu:
                expandedModeMenu.setVisibility(View.GONE);
                //this is a button for triggering the collapsing:
                collapseExpandedModeMenu.setVisibility(View.GONE);
            }
        });
    }
}