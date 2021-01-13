package com.aariyan.faster.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aariyan.faster.Authentication.LogInActivity;
import com.aariyan.faster.Authentication.SingUpActivity;
import com.aariyan.faster.Common.Common;
import com.aariyan.faster.MainActivity;
import com.aariyan.faster.Model.OnBoardingModel;
import com.aariyan.faster.R;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

import static java.security.AccessController.getContext;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {

    private Context context;
    private List<OnBoardingModel> list;

    public SliderAdapter(Context context, List<OnBoardingModel> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.onboarding_screen_container, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        OnBoardingModel model = list.get(position);
        viewHolder.sliderDescriptions.setText(model.getDescription());
        viewHolder.sliderTitle.setText(model.getTitle());

        Glide.with(context).load(model.getImage()).into(viewHolder.sliderImage);

        viewHolder.skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               context.startActivity(new Intent(context, MainActivity.class));
            }
        });

        viewHolder.singUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, SingUpActivity.class));
            }
        });

        viewHolder.logInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, LogInActivity.class));
            }
        });

        if (position == list.size() - 1) {
            viewHolder.bottomActionLayout.setVisibility(View.VISIBLE);
        }
        if (position != list.size() - 1) {
            viewHolder.bottomActionLayout.setVisibility(View.GONE);
        }

    }


    @Override
    public int getCount() {
        return list.size();
    }


    public class ViewHolder extends SliderViewAdapter.ViewHolder {

        private TextView sliderTitle, sliderDescriptions,skipBtn;
        private ImageView sliderImage;

        private LinearLayout bottomActionLayout;

        private TextView singUpText,logInText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sliderTitle = itemView.findViewById(R.id.sliderTitle);
            sliderDescriptions = itemView.findViewById(R.id.sliderDescriptions);
            sliderImage = itemView.findViewById(R.id.imageViewOnSlider);
            bottomActionLayout = itemView.findViewById(R.id.bottomActionLayout);
            skipBtn = itemView.findViewById(R.id.skipBtn);
            singUpText = itemView.findViewById(R.id.singUpTextOnSlider);
            logInText = itemView.findViewById(R.id.logInTextOnSlider);
        }
    }
}
