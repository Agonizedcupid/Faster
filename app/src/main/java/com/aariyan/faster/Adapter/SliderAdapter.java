package com.aariyan.faster.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aariyan.faster.Model.OnBoardingModel;
import com.aariyan.faster.R;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {

    private Context context;
    private List<OnBoardingModel> list;

    public SliderAdapter(Context context,List<OnBoardingModel> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.onboarding_screen_container,parent,false));

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        OnBoardingModel model = list.get(position);
        viewHolder.sliderDescriptions.setText(model.getDescription());
        viewHolder.sliderTitle.setText(model.getTitle());

        Glide.with(context).load(model.getImage()).into(viewHolder.sliderImage);

    }


    @Override
    public int getCount() {
        return list.size();
    }


    public class ViewHolder extends SliderViewAdapter.ViewHolder {

        private TextView sliderTitle,sliderDescriptions;
        private ImageView sliderImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sliderTitle = itemView.findViewById(R.id.sliderTitle);
            sliderDescriptions = itemView.findViewById(R.id.sliderDescriptions);
            sliderImage = itemView.findViewById(R.id.imageViewOnSlider);
        }
    }
}
