package com.aariyan.faster.OnBoarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aariyan.faster.Adapter.ImageSliderAdapter;
import com.aariyan.faster.Authentication.AccountType;
import com.aariyan.faster.Authentication.Personal.LogInActivity;
import com.aariyan.faster.Model.OnBoardingModel;
import com.aariyan.faster.R;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;


//For showing the OnBoarding Screen after ending the SplashScreen:
public class OnBoardingScreen extends AppCompatActivity {


    private String[] titles = {"Step 1","Step 2", "Step 3","Step 4"};
    private String[] descriptions = {"The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog."};

    private int[] sliderImages = {R.drawable.one_boarding_one,R.drawable.one_board_two,R.drawable.one_board_three,R.drawable.one_boarding_four};
    private List<Integer> imageList = new ArrayList<>();

    ViewPager vpSplashPager;
    ImageSliderAdapter imageSliderAdapter;
    PageIndicatorView pageIndicatorView;
    public static TextView sliderTitle,sliderDesc;
    private LinearLayout buttonLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_on_boarding_screen);

        loadItemsForSlider();
    }

    private void loadItemsForSlider() {


        vpSplashPager = findViewById(R.id.vp_splash);
        pageIndicatorView = findViewById(R.id.pageIndicatorView);
        sliderTitle = findViewById(R.id.sliderTitle);
        sliderDesc = findViewById(R.id.sliderDescriptions);
//        tvSplashTitle = findViewById(R.id.tv_splash_title);


        populateData();

    }

    private void populateData() {

        findViewById(R.id.skipBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingScreen.this, AccountType.class));
                //lastState(3);
                finish();
            }
        });

        buttonLayout = findViewById(R.id.buttonLayout);

        findViewById(R.id.singUpTextOnSlider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingScreen.this, AccountType.class));
               // overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
            }
        });

        findViewById(R.id.logInTextOnSlider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingScreen.this, LogInActivity.class));
                //overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
            }
        });


        imageList.add(R.drawable.one_boarding_one);
        imageList.add(R.drawable.one_board_two);
        imageList.add(R.drawable.one_board_three);
        imageList.add(R.drawable.one_boarding_four);

        /*build the image adapter for splash view pager*/
        imageSliderAdapter = new ImageSliderAdapter(imageList, this);

        /*attach the adapter to the view pager*/
        vpSplashPager.setAdapter(imageSliderAdapter);

        pageIndicatorView.setViewPager(vpSplashPager);

        /*set count viewpager indicator*/
        pageIndicatorView.setCount(4);

        /*set indicator the current position from the viewpager*/
        pageIndicatorView.setSelection(vpSplashPager.getCurrentItem());

        sliderTitle.setText(titles[0]);
        sliderDesc.setText(descriptions[0]);

        /*view pager page change listener*/
        vpSplashPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                pageIndicatorView.setSelection(position);


                switch (position) {
                    case 0:
                        /*animate the text*/
                        setTvSplashTextDesapiarAnimator();
                        setTextView(position);
                        findViewById(R.id.skipBtn).setVisibility(View.VISIBLE);
                        buttonLayout.setVisibility(View.GONE);
                        break;

                    case 1:
                        /*animate the text*/
                        setTvSplashTextDesapiarAnimator();
                        setTextView(position);
                        findViewById(R.id.skipBtn).setVisibility(View.VISIBLE);
                        buttonLayout.setVisibility(View.GONE);
                        break;

                    case 2:
                        /*animate the text*/
                        setTextView(position);
                        setTvSplashTextDesapiarAnimator();
                        findViewById(R.id.skipBtn).setVisibility(View.VISIBLE);
                        buttonLayout.setVisibility(View.GONE);
                        break;

                    case 3:
                        /*animate the text*/
                        lastState(position);

                        break;
                }

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void lastState(int position) {
        setTextView(position);
        setTvSplashTextDesapiarAnimator();
        findViewById(R.id.skipBtn).setVisibility(View.GONE);
        buttonLayout.setVisibility(View.VISIBLE);
    }

    private void setTextView(int position) {
        sliderTitle.setText(titles[position]);
        sliderDesc.setText(descriptions[position]);
    }

    /*do the animation of text of splash screens*/
    private void setTvSplashTextDesapiarAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(2500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float alpha = (float) animation.getAnimatedValue();
                sliderTitle.setAlpha(alpha);
                sliderDesc.setAlpha(alpha);
            }
        });
        valueAnimator.start();
    }
}