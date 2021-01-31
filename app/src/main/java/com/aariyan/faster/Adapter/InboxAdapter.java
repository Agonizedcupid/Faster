package com.aariyan.faster.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aariyan.faster.Model.RequestListModel;
import com.aariyan.faster.R;

import java.util.List;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    private Context context;
    private List<RequestListModel> list;

    public InboxAdapter (Context context,List<RequestListModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.inbox_single_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Mapping the list with model
        RequestListModel model = list.get(position);
        //set the last message:
        holder.recentMessage.setText("Hi there this is the message, you have gotten the delivery");
        //set the Order number & product name:
        holder.profileName.setText("Order # "+model.getOrderNumber()+" : "+model.getProductName());

        //to open the chat:
        holder.expandChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //to se the Profile name in the chat
        private TextView profileName;
        //showing the last message
        private TextView recentMessage;
        //to open the chat layout
        private LinearLayout expandChat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileName = itemView.findViewById(R.id.allName);
            recentMessage = itemView.findViewById(R.id.currentMessage);
            expandChat = itemView.findViewById(R.id.expandChat);
        }
    }
}
