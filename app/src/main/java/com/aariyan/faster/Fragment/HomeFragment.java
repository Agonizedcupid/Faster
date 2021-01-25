package com.aariyan.faster.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aariyan.faster.R;


public class HomeFragment extends Fragment {
    //list of main menu container:
    private LinearLayout onlineMainMenu, shopMainMenu, driverMainMenu;

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

    //to inflate the view:
    private View root;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_home, container, false);

        //instantiate the UI:
        initUI();

        return root;
    }

    private void initUI() {
        //main menus:
        // Shop main menu:
        shopMainMenu = root.findViewById(R.id.shopMainMenu);
        //driver main menu:
        driverMainMenu = root.findViewById(R.id.driverMainMenu);
        //online main menu:
        onlineMainMenu = root.findViewById(R.id.onlineMainMenu);

        //instantiate where the selected will be:
        mainMenuSelectedLayout = root.findViewById(R.id.selectedMainMenuLayout);
        //when need to expand the main menu:
        expandMainMenu = root.findViewById(R.id.expandMainMenu);
        //selected menu icon will be shown there:
        selectedMainMenuIcon = root.findViewById(R.id.selectedMainMenuIcon);
        //clickable to going revert:
        closeCurrentMainMenu = root.findViewById(R.id.closeSelectedMainMenu);
        //Main menu list:
        mainMenuList = root.findViewById(R.id.mainMenuList);

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
    private void mainMenuSelection(String mainMenuIdentifier) {
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
}