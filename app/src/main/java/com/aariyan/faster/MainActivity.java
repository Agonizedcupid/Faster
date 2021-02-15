package com.aariyan.faster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;

import com.aariyan.faster.Common.Common;
import com.aariyan.faster.Fragment.ChatFragment;
import com.aariyan.faster.Fragment.HomeForBusinessFragment;
import com.aariyan.faster.Fragment.HomeFragment;
import com.aariyan.faster.Fragment.ListingFragment;
import com.aariyan.faster.Fragment.OrderFragment;
import com.aariyan.faster.Fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import static com.aariyan.faster.Common.Common.sharedPreferences;

public class MainActivity extends AppCompatActivity
        //  implements NavigationView.OnNavigationItemSelectedListener
{


    //Navigation drawer:
    private NavigationView navigationView;
    // toggle button to open the navigation drawer
    private ImageView toggleBtn;
    //Layout to show the navigation menu
    private DrawerLayout drawerLayout;

    private BottomNavigationView bottomNavigationView;
    private TabLayout tabLayout;
    private TabItem listingTabItems;

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

        checkAuthenticationType();
        initUI();
    }

    //Checking authentication type
    private void checkAuthenticationType() {

        sharedPreferences = getSharedPreferences("AuthenticationTypes", Context.MODE_PRIVATE);
        Common.AuthenticationType = sharedPreferences.getString("type", Common.DEFAULT_VAL);
    }

    //when go to the back:
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        //check whether the drawer already open or not:
        //If, already open, then close it first:
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            //closing the drawer first then fo back:
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            //opposite condition:
//
//
//        }
    }

    private void initUI() {

        tabLayout = findViewById(R.id.tabs);
        listingTabItems = findViewById(R.id.listingTabs);
        Objects.requireNonNull(tabLayout.getTabAt(0)).getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);

        if (Common.AuthenticationType.equals("0")) {
            tabLayout.getTabAt(1).setIcon(R.drawable.list_navigation_menu);
            tabLayout.getTabAt(1).setText("LISTING");
        } else {
            tabLayout.getTabAt(1).setIcon(R.drawable.create_listing_icon);
            tabLayout.getTabAt(1).setText("CREATE LIST");
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.white);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

                if (tab.getPosition() == 0) {

                    if (Common.AuthenticationType.equals("0")) {
                        openNavigationMenu(new HomeFragment());

                    } else {
                        openNavigationMenu(new HomeForBusinessFragment());
                    }


                } else if (tab.getPosition() == 1) {
                    openNavigationMenu(new ListingFragment());
                } else if (tab.getPosition() == 2) {
                    openNavigationMenu(new ChatFragment());
                } else if (tab.getPosition() == 3) {
                    openNavigationMenu(new OrderFragment());
                } else if (tab.getPosition() == 4) {
                    openNavigationMenu(new SettingFragment());
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#405062"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//       // bottomNavigationView.setSelectedItemId(R.id.home_menu);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.home_menu:
//                        openNavigationMenu(new HomeFragment());
//                        break;
//
//                    case R.id.listingMenu:
//                        //openNavigationMenu(new ListingFragment());
//                        startActivity(new Intent(MainActivity.this, ListingActivity.class));
//                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                        break;
//
//                    case R.id.chatMenu:
//                        //openNavigationMenu(new ChatFragment());
//
//                        startActivity(new Intent(MainActivity.this, ChatActivity.class));
//                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                        break;
//
//                    case R.id.orderMenu:
//                        openNavigationMenu(new OrderFragment());
//                        break;
//
//                    case R.id.settingMenu:
//                        //openNavigationMenu(new SettingFragment());
//                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
//                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                        break;
//
//
//                }
//
//                return true;
//
//            }
//        });

        //drawer left containing the navigation menus:
        // drawerLayout = findViewById(R.id.drawerLayout);

        //Navigation drawer:
        // navigationView = findViewById(R.id.navigationDrawer);
        // instantiate for onClick event
        //navigationView.setNavigationItemSelectedListener(MainActivity.this);
        //set the default fragment for the first time:

        if (Common.AuthenticationType.equals("0")) {
            openNavigationMenu(new HomeFragment());

        } else {
            openNavigationMenu(new HomeForBusinessFragment());
        }
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
        //Marked the menu as clicked:
        //navigationView.setCheckedItem(R.id.home_menu);
        //toggle button to open the drawer by click:
        //toggleBtn = findViewById(R.id.drawerOpenerBtn);
        //action event to open the navigation drawer:
        //although it will open automatically by dragging left to right or start to end:
//        toggleBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //opening the drawer layout from the start or left:
//                // no need anything for closing the drawer layout:
//                // will be close automatically by touch on the screen
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });

    }


    //to expand the mode menu:
    //it will triggers:
//    private void expandModeMenu() {
//        //This is the only layout that should be visible
//        //after it's triggers, make it Invisible to show the expanded menu list:
//        modeLayout.setVisibility(View.GONE);
//        //this will be visible and will show all the menu to perform
//        expandedModeMenu.setVisibility(View.VISIBLE);
//        //this is a button for triggering or collapsing the expanded menu:
//        collapseExpandedModeMenu.setVisibility(View.VISIBLE);
//        //hide the selected menu layout to show the menu list:
//        selectedModeMenuLayout.setVisibility(View.GONE);
//    }

    //to collapse the menu:
    //it will triggers:
//    private void collapseModeMenu() {
//        //This is the only layout that should be visible
//        //This is the main menu or the first menu or the menu to expand the further menu:
//        modeLayout.setVisibility(View.VISIBLE);
//        //Contains all the menu in this layout:
//        //when collapse, remove all the menu list and make visible the first menu:
//        expandedModeMenu.setVisibility(View.GONE);
//        //this is a button for triggering the collapsing:
//        collapseExpandedModeMenu.setVisibility(View.GONE);
//        //hide the selected menu layout to show the parent menu:
//        selectedModeMenuLayout.setVisibility(View.GONE);
//    }

    //to show the selected particular menu:
//    private void showTheSelectedMenu(String mIdentifier) {
//        //it will be done in two ways:
//        //First will Invisible all the menu without the parent one:
//        //second will change the background of parent Menu:
//        collapseModeMenu();
//        //also hide the parent menu and showing the selected menu:
//        modeLayout.setVisibility(View.GONE);
//        selectedModeMenuLayout.setVisibility(View.VISIBLE);
//        //it's time to change the background as per the user selection:
//        //check which menu has selected to show the appropriate image:
//        if (mIdentifier.endsWith("Personal")) {
//            //if personal menu has selected:
//            selectedMenuIcon.setImageResource(R.drawable.profile_icon);
//        } else {
//            //if driver menu has been selected:
//            selectedMenuIcon.setImageResource(R.drawable.car_icon);
//        }
//    }

    //when needs to restore to it's previous position:
//    private void closeCurrentMenu() {
//        //just collapse all the menu, it will show the parent menu:
//        collapseModeMenu();
//    }


    // perform for opening the corresponding menu into the fragment:
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.home_menu:
//                openNavigationMenu(new HomeFragment());
//                break;
//
//            case R.id.listingMenu:
//                //openNavigationMenu(new ListingFragment());
//                startActivity(new Intent(MainActivity.this, ListingActivity.class));
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                break;
//
//            case R.id.chatMenu:
//                //openNavigationMenu(new ChatFragment());
//
//                startActivity(new Intent(MainActivity.this, ChatActivity.class));
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                break;
//
//            case R.id.orderMenu:
//                openNavigationMenu(new OrderFragment());
//                break;
//
//            case R.id.settingMenu:
//                //openNavigationMenu(new SettingFragment());
//                startActivity(new Intent(MainActivity.this, SettingActivity.class));
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//                break;
//
//
//        }
//
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }

    private void openNavigationMenu(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }
}