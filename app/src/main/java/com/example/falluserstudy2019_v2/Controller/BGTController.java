package com.example.falluserstudy2019_v2.Controller;

import android.util.Log;

import com.example.falluserstudy2019_v2.Behavior.Bar3ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar3DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar4ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar4DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar5BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar5CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar6ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar6CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar7ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar7DBehavior;
import com.example.falluserstudy2019_v2.Behavior.BarAudioBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehavior;
import com.example.falluserstudy2019_v2.ExperimentManager;

import java.util.ArrayList;
import java.util.List;

public class BGTController extends SlideController {

    List<SlideBehavior> session1 = new ArrayList<>();

    int groupID = -1;

    public BGTController(int session, int group) {
        super(session);
        this.groupID = group;
        createBehaviors();
    }

    private void createBehaviors() {
        setUpSession1();
    }

    public void setUpSession1() {

        int participantID = ExperimentManager.getParticipantID();
        String currentOrdering;

        if (participantID > 50) {
             currentOrdering = slideOrder[50];
        }
        else{
            currentOrdering = slideOrder[participantID - 1];
        }
        String[] orderingSplit = currentOrdering.split(",");
        Log.i("ORDERING", "This slide order is: " + currentOrdering);
        Log.i("ORDERING", "groupID: " + groupID + ", split: " + orderingSplit.length);

        for (String s : orderingSplit) {
            if (s.equals("3a")) {
                session1.add(new Bar3ABehavior(this));
            } else if (s.equals("3d")) {
                session1.add(new Bar3DBehavior(this));
            } else if (s.equals("4a")) {
                session1.add(new Bar4ABehavior(this));
            } else if (s.equals("4d")) {
                session1.add(new Bar4DBehavior(this));
            } else if (s.equals("5b")) {
                session1.add(new Bar5BBehavior(this));
            } else if (s.equals("5c")) {
                session1.add(new Bar5CBehavior(this));
            } else if (s.equals("6a")) {
                session1.add(new Bar6ABehavior(this));
            } else if (s.equals("6c")) {
                session1.add(new Bar6CBehavior(this));
            } else if (s.equals("7a")) {
                session1.add(new Bar7ABehavior(this));
            } else if (s.equals("7d")) {
                session1.add(new Bar7DBehavior(this));
            }
            else {
                // Error detection
                System.out.println("AAAAAAAH THIS SHOULDN'T BE HAPPENING");
                session1.add(new BarAudioBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return session1;
    }

    String[] slideOrder ={
            "6c,7d,4a,5b,6a,7a,5c,4d,3d,3a", // 0
            "4a,3a,5c,6c,7a,6a,3d,5b,7d,4d",
            "5b,4d,7d,6a,3a,6c,4a,5c,7a,3d",
            "4d,6a,5c,3a,7a,7d,4a,3d,6c,5b",
            "6a,5b,5c,4d,7d,3d,3a,4a,6c,7a",
            "5b,3d,4a,7d,7a,5c,6a,3a,6c,4d",
            "7d,4a,4d,6a,3a,5b,5c,3d,6c,7a",
            "4d,6c,4a,3a,5c,7a,3d,5b,6a,7d",
            "4a,6c,7a,6a,4d,5c,3d,3a,5b,7d",
            "4d,6a,3a,5c,7d,5b,4a,3d,6c,7a",
            "6c,5b,3a,3d,7a,5c,6a,4a,7d,4d", // 10
            "7a,3a,5c,4a,7d,6a,5b,3d,4d,6c",
            "4d,4a,6a,3a,7d,3d,6c,5c,5b,7a",
            "3d,3a,6a,5b,5c,7a,6c,7d,4a,4d",
            "5c,4a,4d,7d,7a,6a,5b,3d,3a,6c",
            "4a,3a,5c,4d,6c,3d,5b,7a,7d,6a",
            "5b,4d,7d,4a,3a,7a,6c,3d,6a,5c",
            "3d,5c,6a,4d,7a,6c,4a,7d,5b,3a",
            "4d,3d,6c,3a,5c,7a,7d,6a,5b,4a",
            "5b,6c,7d,3d,6a,7a,4a,5c,3a,4d",
            "5b,7a,3d,6c,6a,4a,4d,5c,3a,7d", // 20
            "5c,4d,7a,4a,6c,6a,5b,3d,3a,7d",
            "3a,6a,4d,5c,4a,6c,5b,7d,3d,7a",
            "5b,6a,7d,5c,3d,4a,6c,7a,4d,3a",
            "6c,3d,4a,7a,5c,7d,5b,3a,6a,4d",
            "3d,3a,5b,7a,4d,6a,4a,6c,7d,5c",
            "7a,5b,6a,5c,6c,7d,3d,4d,4a,3a",
            "7a,6a,5b,3d,3a,4d,4a,5c,6c,7d",
            "3d,5c,6a,7a,4a,4d,5b,6c,7d,3a",
            "7a,6a,4a,3a,4d,3d,7d,5b,6c,5c",
            "4a,7a,6c,7d,4d,6a,3a,5c,5b,3d", // 30
            "4a,7d,5b,3a,5c,4d,6a,7a,3d,6c",
            "3a,4d,5b,4a,6a,7a,5c,6c,7d,3d",
            "3a,4d,7d,7a,6c,5b,6a,5c,3d,4a",
            "6a,3d,7a,5c,7d,4d,4a,5b,3a,6c",
            "3a,6c,6a,3d,5b,4a,7d,7a,5c,4d",
            "6c,4d,5b,3a,5c,7a,6a,4a,3d,7d",
            "3a,6a,5c,4d,3d,7d,6c,7a,5b,4a",
            "6a,5c,6c,3a,7d,4d,3d,7a,5b,4a",
            "3a,5c,7a,6c,4a,4d,5b,7d,6a,3d",
            "6c,3d,6a,5c,3a,7d,4d,4a,5b,7a", // 40
            "4d,3a,5b,7a,7d,3d,4a,5c,6a,6c",
            "3a,5b,3d,5c,7a,4a,4d,6c,7d,6a",
            "6a,5b,7a,3a,6c,4a,4d,3d,5c,7d",
            "5c,3a,7d,6a,4d,3d,7a,6c,5b,4a",
            "4a,3a,7a,6a,7d,4d,5c,5b,6c,3d",
            "6c,7a,3d,6a,7d,3a,5c,5b,4d,4a",
            "6c,7a,7d,5c,3d,6a,4a,3a,4d,5b",
            "7a,6a,7d,5b,5c,3d,4d,6c,3a,4a",
            "4a,5c,4d,7d,5b,3d,7a,6c,3a,6a",
            "3a,3d,4a,4d,5b,5c,6a,6c,7a,7d"  //50
    };
}