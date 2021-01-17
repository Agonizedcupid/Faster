package com.aariyan.faster.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aariyan.faster.Authentication.Business.SignUpSecondPart;
import com.aariyan.faster.Model.BusinessIndustriesModel;
import com.aariyan.faster.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.List;

public class BusinessIndustryAdapter extends RecyclerView.Adapter<BusinessIndustryAdapter.ViewHolder> {

    private Context context;
    private List<BusinessIndustriesModel> list;

    public BusinessIndustryAdapter (Context context,List<BusinessIndustriesModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_business_industry_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BusinessIndustriesModel model = list.get(position);
        holder.businessIndustriesName.setText(model.getName());

        holder.selectedType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpSecondPart.bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView businessIndustriesName;
        private CardView selectedType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            businessIndustriesName = itemView.findViewById(R.id.name);
            selectedType = itemView.findViewById(R.id.selectedBusiness);
        }
    }
}
