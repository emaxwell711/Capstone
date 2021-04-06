package com.example.falluserstudy2019_v2.Behavior;

import android.graphics.Bitmap;

import com.example.falluserstudy2019_v2.Activities.SlideActivity;
import com.example.falluserstudy2019_v2.Controller.Event;
import com.example.falluserstudy2019_v2.Controller.SlideController;
import com.example.falluserstudy2019_v2.Polygons.TrainingAPolygons;
import com.example.falluserstudy2019_v2.R;

public class TrainingABehavior extends SlideBehaviorPolygon {

    public TrainingABehavior(SlideController sc) {
        super(R.drawable.traininga, sc);
    }

    @Override
    public void drawPolygons(SlideActivity sa) {
//        TrainingAPolygons poly = new TrainingAPolygons();
//        sa.drawPolygon(poly.BAR_1);
//        sa.drawPolygon(poly.TOP_BAR_1);
//        sa.drawPolygon(poly.BAR_2);
//        sa.drawPolygon(poly.TOP_BAR_2);
//        sa.drawPolygon(poly.BAR_3);
//        sa.drawPolygon(poly.TOP_BAR_3);
//        sa.drawPolygon(poly.ONEHUNDRED_LINE);
//        sa.drawPolygon(poly.SEVENTYFIVE_LINE);
//        sa.drawPolygon(poly.FIFTY_LINE);
//        sa.drawPolygon(poly.TWENTYFIVE_LINE);
//        sa.drawPolygon(poly.ZERO_LINE);
    }

    @Override
    public void tapReaction(int x, int y, Bitmap bitmap, SlideActivity sa) {
        int width = bitmap.getWidth();
        String action = Event.ACTION_TAP;

        TrainingAPolygons poly = new TrainingAPolygons();

        if (poly.inPolygon(poly.BAR_1, x, y, width)) {
            String s = "Bar 1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.TOP_BAR_1, x, y, width)) {
            String s = "Top of Bar 1";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.BAR_2, x, y, width)) {
            String s = "Bar 2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.TOP_BAR_2, x, y, width)) {
            String s = "Top of Bar 2";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.BAR_3, x, y, width)) {
            String s = "Bar 3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.TOP_BAR_3, x, y, width)) {
            String s = "Top of Bar 3";
            sc.reactTapReadAgain(x, y, sa, s);
        }
        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s  = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTYFIVE_LINE, x, y, width)) {
            String s  = "25 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTY_LINE, x, y, width)) {
            String s  = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SEVENTYFIVE_LINE, x, y, width)) {
            String s  = "75 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.ONEHUNDRED_LINE, x, y, width)) {
            String s  = "100 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
    }

    @Override
    public void touchReaction(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {
        int width = bitmap.getWidth();

        TrainingAPolygons poly = new TrainingAPolygons();

        if (poly.inPolygon(poly.BAR_1, x, y, width)) {
            String sAdd = "In Bar 1";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 1";
                sc.reactAreaThenLineBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.TOP_BAR_1, x, y, width)) {
            String sAdd = "Top of Bar 1: 13%";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Top of Bar 1";
                sc.reactAreaThenLineBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.BAR_2, x, y, width)) {
            String sAdd = "In Bar 2";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 2";
                sc.reactAreaThenLineBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.TOP_BAR_2, x, y, width)) {
            String sAdd = "Top of Bar 2: 89%";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Top of Bar 2";
                sc.reactAreaThenLineBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.BAR_3, x, y, width)) {
            String sAdd = "In Bar 3";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Bar 3";
                sc.reactAreaThenLineBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.TOP_BAR_3, x, y, width)) {
            String sAdd = "Top of Bar 3: 79%";
            if (!handleGrids(sAdd, x, y, bitmap, width, poly, sa, action)) {
                String s = "Top of Bar 3";
                sc.reactAreaThenLineBargraphNoRepeat(x, y, bitmap, sa, action, s);
            }
        }
        else if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.TWENTYFIVE_LINE, x, y, width)) {
            String s = "25 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.FIFTY_LINE, x, y, width)) {
            String s = "50 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.SEVENTYFIVE_LINE, x, y, width)) {
            String s = "75 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else if (poly.inPolygon(poly.ONEHUNDRED_LINE, x, y, width)) {
            String s = "100 Percent";
            sc.reactGridLine(x, y, bitmap, sa, action, s);
        }
        else {
            sc.reactAreaThenLineBargraphNoSpeak(x, y, bitmap, sa, action);
        }
    }

    private boolean handleGrids(String sAdd, int x, int y, Bitmap bitmap, int width, TrainingAPolygons poly, SlideActivity sa, String action) {
        if (poly.inPolygon(poly.ZERO_LINE, x, y, width)) {
            String s = "0 Percent";
            sc.reactGridLine2(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.TWENTYFIVE_LINE, x, y, width)) {
            String s = "25 Percent";
            sc.reactGridLine2(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.FIFTY_LINE, x, y, width)) {
            String s = "50 Percent";
            sc.reactGridLine2(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.SEVENTYFIVE_LINE, x, y, width)) {
            String s = "75 Percent";
            sc.reactGridLine2(x, y, bitmap, sa, action, s);
            return true;
        }
        else if (poly.inPolygon(poly.ONEHUNDRED_LINE, x, y, width)) {
            String s = "100 Percent";
            sc.reactGridLine2(x, y, bitmap, sa, action, s);
            return true;
        }
        return false;
    }
}
