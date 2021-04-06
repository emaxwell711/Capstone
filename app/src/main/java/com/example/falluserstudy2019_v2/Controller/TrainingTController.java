package com.example.falluserstudy2019_v2.Controller;

import android.util.Log;

import com.example.falluserstudy2019_v2.Behavior.BarAudioBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehavior;
import com.example.falluserstudy2019_v2.Behavior.TrainingABehavior;
import com.example.falluserstudy2019_v2.Behavior.TrainingDBehavior;

import java.util.ArrayList;
import java.util.List;

public class TrainingTController extends SlideController {

    List<SlideBehavior> session0 = new ArrayList<>();

    int groupID = -1;

    public TrainingTController(int session, int group) {
        super(session);
        this.groupID = group;
        createBehaviors();
    }

    private void createBehaviors() {
        setUpSession0();
    }

    public void setUpSession0() {

        String currentOrdering = slideOrder[0];
        String[] orderingSplit = currentOrdering.split(",");
        Log.i("ORDERING", "This slide order is: " + currentOrdering);
        Log.i("ORDERING", "groupID: " + groupID + ", split: " + orderingSplit.length);

        for (String s : orderingSplit) {
            if (s.equals("TrainingA")) {
                session0.add(new TrainingABehavior(this));
            }
            else if (s.equals("TrainingD")) {
                session0.add(new TrainingDBehavior(this));
            }
            else {
                System.out.println("AAAAAAAH THIS SHOULDN'T BE HAPPENING");
                session0.add(new BarAudioBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return session0;
    }

    String[] slideOrder = {
            "TrainingA,TrainingD"
    };
}
