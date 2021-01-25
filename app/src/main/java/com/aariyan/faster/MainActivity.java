package com.aariyan.faster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aariyan.faster.Common.Common;

public class MainActivity extends AppCompatActivity {

    //main layout, containing first Mode menu:
    private RelativeLayout modeLayout;
    //Layout that contain all the menu list:
    private LinearLayout expandedModeMenu;
    //For Collapsing the expanded Mode menu:
    private ImageView collapseExpandedModeMenu;
    //Selected Particular menu on top right:
    //it will show the selected menu on the top:
    private RelativeLayout personalModeLayout,driverModeLayout,selectedModeMenuLayout;
    //show as selected menu icon:
    private ImageView selectedMenuIcon;
    //To Invisible the text
    //to show the selected menu:
    private TextView modeText;
    //to expand the parent menu:
    private ImageView expandParentMenu;
    //to go back in parent menu by closing Current menu:
    private ImageView closeSelectedMenu;
    //Main menu selected:
    private LinearLayout mainMenuSelectedLayout;
    //to expand the main menu parent:
    private ImageView expandMainMenu;
    // to close the selected main menu:
    private ImageView selectedMainMenuIcon;
    // to close and revert to it's parent menu:
    private ImageView closeCurrentMainMenu;
    //Main menu list container:
    private LinearLayout mainMenuList;
    //list of main menu container:
    private LinearLayout onlineMainMenu,shopMainMenu,driverMainMenu;

    // to identify the users selection menu name:
    private String menuIdentifier = "";

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
        //instantiate where the selected will be:
        mainMenuSelectedLayout = findViewById(R.id.selectedMainMenuLayout);
        //when need to expand the main menu:
        expandMainMenu = findViewById(R.id.expandMainMenu);
        //selected menu icon will be shown there:
        selectedMainMenuIcon = findViewById(R.id.selectedMainMenuIcon);
        //clickable to going revert:
        closeCurrentMainMenu = findViewById(R.id.closeSelectedMainMenu);
        //Main menu list:
        mainMenuList = findViewById(R.id.mainMenuList);
        //main menus:
        // Shop main menu:
        shopMainMenu = findViewById(R.id.shopMainMenu);
        //driver main menu:
        driverMainMenu = findViewById(R.id.driverMainMenu);
        //online main menu:
        onlineMainMenu = findViewById(R.id.onlineMainMenu);



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

        //Main menu section:
        //when need to expand the main menu:
        expandMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expand the parent layout:
                //Hide the current layout:
                mainMenuExpand();

            }
        });

        //restore the current position and going back & show the parent Menu:
        closeCurrentMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuExpand();
            }
        });

        // To select the shop menu
        shopMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuSelection("Shop");
            }
        });

        //To select the Drive menu:
        driverMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuSelection("Driver");
            }
        });
        //to select the wifi menu:
        onlineMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuSelection("Online");
            }
        });

    }


    //Main Menu section:
    //to expand the main menu:
    private void mainMenuExpand() {
        mainMenuSelectedLayout.setVisibility(View.GONE);
        mainMenuList.setVisibility(View.VISIBLE);
    }

    //Main menu selection:
    private void mainMenuSelection(String mainMenuIdentifier){
       mainMenuList.setVisibility(View.GONE);
       mainMenuSelectedLayout.setVisibility(View.VISIBLE);
       if (mainMenuIdentifier.equals("Shop")) {
           selectedMainMenuIcon.setImageResource(R.drawable.shop_icon);
       }
       if (mainMenuIdentifier.equals("Driver")) {
           selectedMainMenuIcon.setImageResource(R.drawable.car_icon);
       }
       if (mainMenuIdentifier.equals("Online")) {
           selectedMainMenuIcon.setImageResource(R.drawable.wifi_icon);
       }
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
    private void closeCurrentMenu () {
        //just collapse all the menu, it will show the parent menu:
        collapseModeMenu();
    }

}