package com.aariyan.faster.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.aariyan.faster.Adapter.BusinessAdapter;
import com.aariyan.faster.Adapter.SupermarketAdapter;
import com.aariyan.faster.Model.RestaurantModel;
import com.aariyan.faster.Model.SupermarketModel;
import com.aariyan.faster.R;

import java.util.ArrayList;
import java.util.List;

public class BusinessFragment extends Fragment {


    private RecyclerView recyclerView,supermarketRecyclerView,pharmacyRecyclerView;
    private View root;
    private BusinessAdapter adapter;
    private SupermarketAdapter supermarketAdapter;
    List<RestaurantModel> list = new ArrayList<>();
    List<SupermarketModel> lists = new ArrayList<>();

    public BusinessFragment() {
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
        root = inflater.inflate(R.layout.fragment_business, container, false);

        initUI();
        return root;
    }

    private void initUI() {
        recyclerView = root.findViewById(R.id.restaurantReycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //
        populateData();

        populateSupermarketData();
        populatePharmacyData();
    }

    private void populatePharmacyData() {
        pharmacyRecyclerView = root.findViewById(R.id.pharmacyReycler);
        pharmacyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        for (int i=0; i<10; i++) {
            SupermarketModel model = new SupermarketModel(
                    R.drawable.restaurant_dummy_image
            );

            lists.add(model);
        }

        supermarketAdapter = new SupermarketAdapter(getContext(),lists);
        pharmacyRecyclerView.setAdapter(supermarketAdapter);
        supermarketAdapter.notifyDataSetChanged();

    }

    private void populateSupermarketData() {
        supermarketRecyclerView = root.findViewById(R.id.supermarketReycler);
        supermarketRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        for (int i=0; i<10; i++) {
            SupermarketModel model = new SupermarketModel(
                    R.drawable.restaurant_dummy_image
            );

            lists.add(model);
        }

        supermarketAdapter = new SupermarketAdapter(getContext(),lists);
        supermarketRecyclerView.setAdapter(supermarketAdapter);
        supermarketAdapter.notifyDataSetChanged();

    }

    private void populateData() {
        for (int i=0; i<10; i++) {
            RestaurantModel model = new RestaurantModel(
                    "Hello 12"+i+2
            );

            list.add(model);
        }

        adapter = new BusinessAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}