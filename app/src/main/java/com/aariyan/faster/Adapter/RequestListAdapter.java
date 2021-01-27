package com.aariyan.faster.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aariyan.faster.Model.RequestListModel;
import com.aariyan.faster.R;

import java.util.List;

public class RequestListAdapter extends RecyclerView.Adapter<RequestListAdapter.ViewHolder> {

    List<RequestListModel> list;
    private Context context;

    public RequestListAdapter (Context context,List<RequestListModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.request_single_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RequestListModel model = list.get(position);

        holder.productImage.setImageResource(model.getProductImage());
        holder.orderId.setText(model.getOrderNumber());
        holder.productName.setText(model.getProductName());
        holder.date.setText(model.getDate());
        holder.name.setText(model.getName());
        holder.price.setText(model.getProductPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView productName,name,price,orderId,date;
        private ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.productName);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.productPrice);
            orderId = itemView.findViewById(R.id.productName);
            date = itemView.findViewById(R.id.orderDate);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
