package com.aariyan.faster.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.aariyan.faster.Common.Common;
import com.aariyan.faster.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;


public class ListingFragment extends Fragment {


    private TabLayout tabLayout;
    private View root;
    private ScrollView listingItems;
    private FrameLayout viewPager;

    public ListingFragment() {
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
        root =  inflater.inflate(R.layout.fragment_listing, container, false);
        initUI();
        return root;
    }

    private void initUI() {


        listingItems = root.findViewById(R.id.listingItems);
        viewPager = root.findViewById(R.id.viewPager);
        tabLayout = root.findViewById(R.id.tabLayout);
        //starting the default fragment:
        if (Common.AuthenticationType.equals("0")) {
            tabLayout.setVisibility(View.VISIBLE);
            viewPager.setVisibility(View.VISIBLE);
            listingItems.setVisibility(View.GONE);
            startFragment(new BusinessFragment());
        } else {
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            listingItems.setVisibility(View.VISIBLE);
        }



        //tab action event:
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {



                //confirming the tab position:
                //First tab if 0:
                if(tab.getPosition() == 0) {
                    startFragment(new BusinessFragment());

                }

                //second tab if 1
                if(tab.getPosition() == 1) {
                    startFragment(new DriversFragment());
                    //make search Icon visible:
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
        Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                .beginTransaction().replace(R.id.viewPager, fragment).commit();
    }
}