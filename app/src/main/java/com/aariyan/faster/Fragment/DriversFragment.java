package com.aariyan.faster.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.style.AlignmentSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aariyan.faster.Adapter.DriverChatAdapter;
import com.aariyan.faster.R;

import java.util.ArrayList;
import java.util.List;

public class DriversFragment extends Fragment {


    private View root;
    private RecyclerView recyclerView;

    private List<String> list = new ArrayList<>();

    public DriversFragment() {
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
        root =  inflater.inflate(R.layout.fragment_drivers, container, false);

        initUI();
        return root;
    }

    private void initUI() {
        recyclerView = root.findViewById(R.id.driverRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list.clear();
        for (int i=0; i<10; i++) {
            list.add("Driver XYZ - "+i);
        }
        DriverChatAdapter adapter = new DriverChatAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}