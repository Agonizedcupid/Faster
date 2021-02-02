package com.aariyan.faster.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aariyan.faster.R;

import java.util.List;

public class PastOrderAdapter extends RecyclerView.Adapter<PastOrderAdapter.ViewHolder> {

    private Context context;
    private List<String> list;
    public PastOrderAdapter(Context context,List<String>list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_past_order_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.orderNumber.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView orderNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderNumber = itemView.findViewById(R.id.orderNumber);
        }
    }
}
