package com.example.falluserstudy2019_v2.Behavior;

import android.graphics.Bitmap;

import com.example.falluserstudy2019_v2.Activities.SlideActivity;
import com.example.falluserstudy2019_v2.Controller.SlideController;
import com.example.falluserstudy2019_v2.R;

public class BarAudioBehavior extends SlideBehavior {

    public BarAudioBehavior(SlideController sc) {
        super(R.drawable.barembossederror, sc);
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        sa.speak("Error: This is not functioning correctly.");
    }
}
