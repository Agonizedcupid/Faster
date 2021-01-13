package com.aariyan.faster.OnBoarding;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.aariyan.faster.Adapter.SliderAdapter;
import com.aariyan.faster.Model.OnBoardingModel;
import com.aariyan.faster.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


//For showing the OnBoarding Screen after ending the SplashScreen:
public class OnBoardingScreen extends AppCompatActivity {

    private SliderAdapter adapter;
    private List<OnBoardingModel> list = new ArrayList<>();

    private String[] titles = {"Step 1","Step 2", "Step 3","Step 4"};
    private String[] descriptions = {"The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs "};

    private int[] sliderImages = {R.drawable.one_boarding_one,R.drawable.one_board_two,R.drawable.one_board_three,R.drawable.one_boarding_four};




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

        populateData();

        SliderView sliderView = findViewById(R.id.fullSlider);
        adapter = new SliderAdapter(OnBoardingScreen.this, list);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }

    private void populateData() {

        for (int i=0; i<sliderImages.length; i++) {
            list.add(new OnBoardingModel(
                   sliderImages[i],
                   titles[i],
                   descriptions[i]
            ));
        }
    }
}