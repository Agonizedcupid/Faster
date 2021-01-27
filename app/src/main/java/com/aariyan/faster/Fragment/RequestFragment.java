package com.aariyan.faster.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aariyan.faster.Adapter.RequestListAdapter;
import com.aariyan.faster.Model.RequestListModel;
import com.aariyan.faster.R;

import java.util.ArrayList;
import java.util.List;


public class RequestFragment extends Fragment {

    //Recyclerview to show the request list:
    private RecyclerView recyclerView;
    //Dummy list to contain Recycler data:
    private List<RequestListModel> list = new ArrayList<>();
    //Model Class for populating data:
    private RequestListModel model;
    //Adapter to show the data:
    private RequestListAdapter adapter;

    //Dummy data for Product showing:
    private String[] productName = {"Vegetarian Italian Chopped Salad - kit","Vegetarian Italian Chopped Salad - kit","Vegetarian Italian Chopped Salad - kit","Vegetarian Italian Chopped Salad - kit"};
    private String[] productPrice = {"$25.25","$15.75","$75.25","$50.25"};
    private String[] orderDate = {"Dec 25, 2020","Dec 25, 2020","Dec 25, 2020","Dec 25, 2020"};
    private String[] orderId = {"0976-345","0976-345","0976-345","0976-345"};
    private int[] productImages = {R.drawable.dummy_image,R.drawable.dummy_image,R.drawable.dummy_image,R.drawable.dummy_image};


    //to inflate the View:
    private View root;


    public RequestFragment() {
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
        root =  inflater.inflate(R.layout.fragment_request, container, false);

        //Instantiate UI:
        initUI();

        //Populate dummy data:
        populateDummyData();

        return root;
    }


    //populating dummy data:
    private void populateDummyData() {

        //clearing the list if have any
        list.clear();
        for (int i=0; i<4; i++) {
            list.add(new RequestListModel(
                    i,
                    orderDate[i],
                    "Aariyan Khan",
                    orderId[i],
                    productImages[i],
                    productName[i],
                    productPrice[i]
            ));
        }

        //calling the adapter to show:
        adapter = new RequestListAdapter(getContext(),list);
        //setting the adapter on recycler:
        recyclerView.setAdapter(adapter);
        //notify the data changes on the list:
        adapter.notifyDataSetChanged();



    }

    private void initUI() {
        recyclerView = root.findViewById(R.id.requestRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}