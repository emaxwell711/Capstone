package com.example.falluserstudy2019_v2.Controller;

import android.util.Log;

import com.example.falluserstudy2019_v2.Behavior.BarAudioBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehaviorPolygon;
import com.example.falluserstudy2019_v2.Behavior.TrainingBBehavior;
import com.example.falluserstudy2019_v2.Behavior.TrainingCBehavior;

import java.util.ArrayList;
import java.util.List;

public class TrainingEController extends SlideController {

    List<SlideBehavior> session2 = new ArrayList<>();

    int groupID = -1;

    public TrainingEController(int session, int group) {
        super(session);
        this.groupID = group;
        createBehaviors();
    }

    private void createBehaviors() {
        setUpSession2();
    }

    public void setUpSession2() {

        String currentOrdering = slideOrder[0];
        String[] orderingSplit = currentOrdering.split(",");
        Log.i("ORDERING", "This slide order is: " + currentOrdering);
        Log.i("ORDERING", "groupID: " + groupID + ", split: " + orderingSplit.length);

        for (String s : orderingSplit) {
            if (s.equals("TrainingB")) {
                session2.add(new TrainingBBehavior(this));
            }
            else if (s.equals("TrainingC")) {
                session2.add(new TrainingCBehavior(this));
            }
            else {
                System.out.println("AAAAAAAH THIS SHOULDN'T BE HAPPENING");
                session2.add(new BarAudioBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return session2;
    }

    String[] slideOrder = {
            "TrainingB,TrainingC"
    };
}
