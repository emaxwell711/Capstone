package com.example.falluserstudy2019_v2.Behavior;

import android.graphics.Bitmap;

import com.example.falluserstudy2019_v2.Activities.SlideActivity;
import com.example.falluserstudy2019_v2.Controller.SlideController;
import com.example.falluserstudy2019_v2.R;

public class BarEmbossedP1Behavior extends SlideBehavior {

    public BarEmbossedP1Behavior(SlideController sc) {
        super(R.drawable.barembossed1m, sc);
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        sa.speak("Embossed Diagrams Part 1");
    }
}
