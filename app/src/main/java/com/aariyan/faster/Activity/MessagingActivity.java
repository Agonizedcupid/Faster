package com.aariyan.faster.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.aariyan.faster.Adapter.ChatAdapter;
import com.aariyan.faster.Fragment.InboxFragment;
import com.aariyan.faster.Fragment.RequestFragment;
import com.aariyan.faster.Model.MessageModel;
import com.aariyan.faster.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MessagingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    List<MessageModel> list = new ArrayList<>();
    MessageModel model;

    private int[] types = {0,1,0,1,0,1,0,1};
    private int[] receiverM = {R.string.dummyString,R.string.dummyString,R.string.dummyString,R.string.dummyString,R.string.dummyString,R.string.dummyString,R.string.dummyString,R.string.dummyString};
    private String[] times = {"01.0 PM","02.0 PM","03.0 PM","04.0 PM","05.0 PM","06.0 PM","07.0 PM","08.0 PM",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initUI();
        //populate dummy data:
        populateData();
    }

    private void populateData() {
        list.clear();

        for (int i=0; i<types.length; i++) {
            model = new MessageModel(
                    i,
                    types[i],
                    ""+receiverM[i],
                    ""+receiverM[i],
                    ""+times[i],
                    ""+times[i]
            );

            list.add(model);
        }

        ChatAdapter adapter = new ChatAdapter(MessagingActivity.this,list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    //instantiate the UI:
    private void initUI() {

        recyclerView = findViewById(R.id.chatRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //go to the parent:
        findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}