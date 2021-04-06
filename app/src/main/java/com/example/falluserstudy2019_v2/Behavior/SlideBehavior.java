package com.example.falluserstudy2019_v2.Behavior;

import android.graphics.Bitmap;

import com.example.falluserstudy2019_v2.Activities.SlideActivity;
import com.example.falluserstudy2019_v2.Controller.SlideController;

public abstract class SlideBehavior {

    int graphID = -1;

    public SlideController sc;

    public SlideBehavior(int graphID, SlideController sc) {
        this.graphID = graphID;
        this.sc = sc;
    }

    abstract public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action);

    public int getGraphID() {
        return graphID;
    }

    public void setGraphID(int graphID) {
        this.graphID = graphID;
    }
}
