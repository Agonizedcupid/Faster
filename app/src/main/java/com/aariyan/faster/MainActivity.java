package com.aariyan.faster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aariyan.faster.Common.Common;
import com.aariyan.faster.Fragment.ChatFragment;
import com.aariyan.faster.Fragment.HomeFragment;
import com.aariyan.faster.Fragment.OrderFragment;
import com.aariyan.faster.Fragment.SettingFragment;
import com.aariyan.faster.NavigationActivity.ChatActivity;
import com.aariyan.faster.NavigationActivity.ListingActivity;
import com.aariyan.faster.NavigationActivity.SettingActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //main layout, containing first Mode menu:
    private RelativeLayout modeLayout;
    //Layout that contain all the menu list:
    private LinearLayout expandedModeMenu;
    //For Collapsing the expanded Mode menu:
    private ImageView collapseExpandedModeMenu;
    //Selected Particular menu on top right:
    //it will show the selected menu on the top:
    private RelativeLayout personalModeLayout, driverModeLayout, selectedModeMenuLayout;
    //show as selected menu icon:
    private ImageView selectedMenuIcon;
    //To Invisible the text
    //to show the selected menu:
    private TextView modeText;
    //to expand the parent menu:
    private ImageView expandParentMenu;
    //to go back in parent menu by closing Current menu:
    private ImageView closeSelectedMenu;



    // to identify the users selection menu name:
    private String menuIdentifier = "";

    //Navigation drawer:
    private NavigationView navigationView;
    // toggle button to open the navigation drawer
    private ImageView toggleBtn;
    //Layout to show the navigation menu
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check to see whether the OnBoard screen has already been showed or not:
        SharedPreferences.Editor sharedPreferencesEditor =
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
        sharedPreferencesEditor.putBoolean(
                Common.onBoardingCompletedStatus, true);
        sharedPreferencesEditor.apply();

        initUI();
    }

    //when go to the back:
    @Override
    public void onBackPressed() {

        //check whether the drawer already open or not:
        //If, already open, then close it first:
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //closing the drawer first then fo back:
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            //opposite condition:
            super.onBackPressed();

        }
    }

    private void initUI() {
        //Main menu instantiation:
        modeLayout = findViewById(R.id.modeLayout);
        //List of menu layout instantiate:
        expandedModeMenu = findViewById(R.id.expandedModeMenu);
        //collapsing button instantiate:
        collapseExpandedModeMenu = findViewById(R.id.collapseExpandedModeMenu);
        //Instantiate the Personal menu:
        //On the top right corner:
        personalModeLayout = findViewById(R.id.personalLayoutModeMenu);
        //Instantiate the Driver menu:
        //on the top right corner:
        driverModeLayout = findViewById(R.id.driverLayoutModeMenu);
        //Instantiate the Driver layout:
        //On the top right corner:
        driverModeLayout = findViewById(R.id.driverLayoutModeMenu);
        //Instantiate Text to hide and show in particular:
        modeText = findViewById(R.id.modeText);
        //This will replace the previous icon when user select any menu to be on:
        selectedMenuIcon = findViewById(R.id.selectedMenuIcon);
        //layout to show the selected Menu & holding the menu items:
        selectedModeMenuLayout = findViewById(R.id.selectedModeMenuLayout);
        //ImageView to expand the parent menu:
        expandParentMenu = findViewById(R.id.expandModeParentMenu);
        //ImageView to undo selection:
        closeSelectedMenu = findViewById(R.id.closeSelectedMenu);



        //drawer left containing the navigation menus:
        drawerLayout = findViewById(R.id.drawerLayout);

        //Navigation drawer:
        navigationView = findViewById(R.id.navigationDrawer);
        // instantiate for onClick event
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        //set the default fragment for the first time:
        openNavigationMenu(new HomeFragment());
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
        //Marked the menu as clicked:
        navigationView.setCheckedItem(R.id.home_menu);
        //toggle button to open the drawer by click:
        toggleBtn = findViewById(R.id.drawerOpenerBtn);
        //action event to open the navigation drawer:
        //although it will open automatically by dragging left to right or start to end:
        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opening the drawer layout from the start or left:
                // no need anything for closing the drawer layout:
                // will be close automatically by touch on the screen
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        //OnAction Event for all the layout:
        //it's triggers time:
        //It will expand the menu layout
        expandParentMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Expand menu:
                expandModeMenu();
            }
        });

        //Triggers when you need to collapse all the menu:
        collapseExpandedModeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Collapse Mode menu:
                collapseModeMenu();

            }
        });

        //Personal mode menu:
        personalModeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will hide all the mode menu to show the particular menu:
                collapseModeMenu();
                //triggers to show the selected menu:
                //populate variable with selected menu name:
                menuIdentifier = "Personal";
                showTheSelectedMenu(menuIdentifier);
            }
        });

        //Driver mode menu:
        driverModeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this will hide all the mode menu to show the particular menu:
                collapseModeMenu();
                //triggers to show the selected menu:
                //populate variable with selected menu name:
                menuIdentifier = "Driver";
                showTheSelectedMenu(menuIdentifier);
            }
        });
        // when user want to restore his position to the previous one:
        closeSelectedMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to go back it's parent menu
                closeCurrentMenu();
            }
        });





    }


    //to expand the mode menu:
    //it will triggers:
    private void expandModeMenu() {
        //This is the only layout that should be visible
        //after it's triggers, make it Invisible to show the expanded menu list:
        modeLayout.setVisibility(View.GONE);
        //this will be visible and will show all the menu to perform
        expandedModeMenu.setVisibility(View.VISIBLE);
        //this is a button for triggering or collapsing the expanded menu:
        collapseExpandedModeMenu.setVisibility(View.VISIBLE);
        //hide the selected menu layout to show the menu list:
        selectedModeMenuLayout.setVisibility(View.GONE);
    }

    //to collapse the menu:
    //it will triggers:
    private void collapseModeMenu() {
        //This is the only layout that should be visible
        //This is the main menu or the first menu or the menu to expand the further menu:
        modeLayout.setVisibility(View.VISIBLE);
        //Contains all the menu in this layout:
        //when collapse, remove all the menu list and make visible the first menu:
        expandedModeMenu.setVisibility(View.GONE);
        //this is a button for triggering the collapsing:
        collapseExpandedModeMenu.setVisibility(View.GONE);
        //hide the selected menu layout to show the parent menu:
        selectedModeMenuLayout.setVisibility(View.GONE);
    }

    //to show the selected particular menu:
    private void showTheSelectedMenu(String mIdentifier) {
        //it will be done in two ways:
        //First will Invisible all the menu without the parent one:
        //second will change the background of parent Menu:
        collapseModeMenu();
        //also hide the parent menu and showing the selected menu:
        modeLayout.setVisibility(View.GONE);
        selectedModeMenuLayout.setVisibility(View.VISIBLE);
        //it's time to change the background as per the user selection:
        //check which menu has selected to show the appropriate image:
        if (mIdentifier.endsWith("Personal")) {
            //if personal menu has selected:
            selectedMenuIcon.setImageResource(R.drawable.profile_icon);
        } else {
            //if driver menu has been selected:
            selectedMenuIcon.setImageResource(R.drawable.car_icon);
        }
    }

    //when needs to restore to it's previous position:
    private void closeCurrentMenu() {
        //just collapse all the menu, it will show the parent menu:
        collapseModeMenu();
    }


    // perform for opening the corresponding menu into the fragment:
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu:
                openNavigationMenu(new HomeFragment());
                break;

            case R.id.listingMenu:
                //openNavigationMenu(new ListingFragment());
                startActivity(new Intent(MainActivity.this, ListingActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.chatMenu:
                //openNavigationMenu(new ChatFragment());

                startActivity(new Intent(MainActivity.this, ChatActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            case R.id.orderMenu:
                openNavigationMenu(new OrderFragment());
                break;

            case R.id.settingMenu:
                //openNavigationMenu(new SettingFragment());
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;


        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openNavigationMenu(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}