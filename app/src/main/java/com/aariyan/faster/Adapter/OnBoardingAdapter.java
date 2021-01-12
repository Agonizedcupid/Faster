package com.aariyan.faster.Adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.aariyan.faster.OnBoarding.OnBoardingScreen;
import com.aariyan.faster.R;

public class OnBoardingAdapter extends PagerAdapter {


    private Context context;

    public OnBoardingAdapter(Context context) {
        this.context = context;
    }

    //getting all the image resource related to the OnBoarding in the array to easily pass as index:
    public int[] images = {
            R.drawable.one_boarding_one,R.drawable.one_board_two,R.drawable.one_board_three,R.drawable.one_boarding_four};

    //Array for the Heading Initialization:
    private String[] headings = {"Step 1","Step 2", "Step 3","Step 4"};
    private String[] descriptions = {"The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs ",
            "The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs "};


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
