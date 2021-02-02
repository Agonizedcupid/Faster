package com.aariyan.faster.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.style.AlignmentSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aariyan.faster.Adapter.PastOrderAdapter;
import com.aariyan.faster.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class PastOrderFragment extends Fragment {


    private RecyclerView recyclerView;
    private View root;
    private List<String>list = new ArrayList<>();


    public PastOrderFragment() {
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
        root =  inflater.inflate(R.layout.fragment_past_order, container, false);
        initUI();
        return root;
    }

    private void initUI() {
        recyclerView = root.findViewById(R.id.pastOrderRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        for (int i=0; i<10; i++) {
            list.add(UUID.randomUUID().toString()+"-"+i);
        }

        PastOrderAdapter adapter = new PastOrderAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}