package com.aariyan.faster.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aariyan.faster.Common.Common;
import com.aariyan.faster.R;
public class SettingFragment extends Fragment {


    private LinearLayout personalLayout;
    private View root;

    public SettingFragment() {
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
        root = inflater.inflate(R.layout.fragment_setting, container, false);
        initUI();
        return root;
    }

    private void initUI() {
        personalLayout = root.findViewById(R.id.personalLayout);
        if (Common.AuthenticationType.equals("0")) {
            personalLayout.setVisibility(View.VISIBLE);
        } else {
            personalLayout.setVisibility(View.GONE);
        }
    }
}