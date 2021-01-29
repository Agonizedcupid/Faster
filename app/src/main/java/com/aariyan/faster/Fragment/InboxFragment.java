package com.aariyan.faster.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aariyan.faster.Adapter.InboxAdapter;
import com.aariyan.faster.Adapter.RequestListAdapter;
import com.aariyan.faster.Model.RequestListModel;
import com.aariyan.faster.R;

import java.util.ArrayList;
import java.util.List;

import static com.aariyan.faster.Fragment.RequestFragment.orderDate;
import static com.aariyan.faster.Fragment.RequestFragment.orderId;
import static com.aariyan.faster.Fragment.RequestFragment.productImages;
import static com.aariyan.faster.Fragment.RequestFragment.productName;
import static com.aariyan.faster.Fragment.RequestFragment.productPrice;


public class InboxFragment extends Fragment {

    private RecyclerView recyclerView;
    private InboxAdapter adapter;

    //Dummy list to contain Recycler data:
    private List<RequestListModel> list = new ArrayList<>();

    private View root;

    public InboxFragment() {
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
        root = inflater.inflate(R.layout.fragment_inbox, container, false);

        initUI();
        return root;
    }

    private void initUI() {
        recyclerView = root.findViewById(R.id.inboxRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        populateDummyData();
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
        adapter = new InboxAdapter(getContext(),list);
        //setting the adapter on recycler:
        recyclerView.setAdapter(adapter);
        //notify the data changes on the list:
        adapter.notifyDataSetChanged();
    }
}