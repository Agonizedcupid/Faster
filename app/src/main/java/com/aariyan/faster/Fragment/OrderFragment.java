package com.aariyan.faster.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aariyan.faster.Common.Common;
import com.aariyan.faster.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;


public class OrderFragment extends Fragment {
    //Tab layout for Request and Inbox:
    private TabLayout tabLayout;
    //search Icon:
    public static ImageView searchIcon;

    private View root;

    public OrderFragment() {
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
        root = inflater.inflate(R.layout.fragment_order, container, false);

        initUI();
        return root;
    }

    private void initUI() {

        //instantiate the tab layout:
        tabLayout = root.findViewById(R.id.tabLayout);

        //instantiate the search icon:
        searchIcon = root.findViewById(R.id.searchIcon);

        //starting the default fragment:
        if (Common.AuthenticationType.equals("1")) {
            startFragment(new PastOrderFragment());
        } else {
            startFragment(new PastOrderFragmentPersonal());
            Objects.requireNonNull(tabLayout.getTabAt(1)).setText("Upcoming");
        }



        //tab action event:
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {



                //confirming the tab position:
                //First tab if 0:
                if(tab.getPosition() == 0) {
                    if (Common.AuthenticationType.equals("1")) {
                        startFragment(new PastOrderFragment());
                    } else {
                        startFragment(new PastOrderFragmentPersonal());
                    }
                }

                //second tab if 1
                if(tab.getPosition() == 1) {
                    startFragment(new CurrentFragment());
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }

    //entrenched the default and selected fragment:
    private void startFragment(Fragment fragment) {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, fragment).commit();
    }
}