package com.example.falluserstudy2019_v2.Controller;

import android.util.Log;

import com.example.falluserstudy2019_v2.Behavior.Bar3BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar3CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar4BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar4CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar5ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar5DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar6BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar6DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar7BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar7CBehavior;
import com.example.falluserstudy2019_v2.Behavior.BarAudioBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehavior;
import com.example.falluserstudy2019_v2.ExperimentManager;

import java.util.ArrayList;
import java.util.List;

public class BGEController extends SlideController {

    List<SlideBehavior> session3 = new ArrayList<>();

    int groupID = -1;

    public BGEController(int session, int group) {
        super(session);
        this.groupID = group;
        createBehaviors();
    }

    private void createBehaviors() {
        setUpSession3();
    }

    public void setUpSession3() {

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
            if (s.equals("3b")) {
                session3.add(new Bar3BBehavior(this));
            }
            else if (s.equals("3c")) {
                session3.add(new Bar3CBehavior(this));
            }
            else if (s.equals("4b")) {
                session3.add(new Bar4BBehavior(this));
            }
            else if (s.equals("4c")) {
                session3.add(new Bar4CBehavior(this));
            }
            else if (s.equals("5a")) {
                session3.add(new Bar5ABehavior(this));
            }
            else if (s.equals("5d")) {
                session3.add(new Bar5DBehavior(this));
            }
            else if (s.equals("6b")) {
                session3.add(new Bar6BBehavior(this));
            }
            else if (s.equals("6d")) {
                session3.add(new Bar6DBehavior(this));
            }
            else if (s.equals("7b")) {
                session3.add(new Bar7BBehavior(this));
            }
            else if (s.equals("7c")) {
                session3.add(new Bar7CBehavior(this));
            }
            else {
                // Error detection
                System.out.println("AAAAAAAH THIS SHOULDN'T BE HAPPENING");
                session3.add(new BarAudioBehavior(this));
            }
        }
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return session3;
    }

    String[] slideOrder ={
            "3c,7c,4b,4c,5d,6d,3b,5a,7b,6b", // 0
            "7c,6d,4b,3b,4c,7b,5d,5a,3c,6b",
            "4b,6b,7b,3c,3b,4c,6d,5a,7c,5d",
            "3b,4c,3c,6d,7c,4b,7b,5d,6b,5a",
            "6d,7c,5d,4b,6b,3c,5a,3b,7b,4c",
            "4b,6b,5d,7c,3b,4c,6d,7b,5a,3c",
            "4c,5d,7c,6d,5a,3c,4b,7b,6b,3b",
            "5d,4c,6b,4b,5a,7b,7c,3c,3b,6d",
            "7c,5d,3b,5a,6b,7b,6d,3c,4b,4c",
            "7c,4c,7b,3c,4b,3b,6d,5a,5d,6b",
            "5a,5d,4c,7b,6d,3b,6b,4b,7c,3c", // 10
            "7c,6b,6d,3c,3b,7b,4b,5d,4c,5a",
            "4c,7c,4b,7b,5a,3b,6d,6b,5d,3c",
            "7c,4b,5a,4c,3c,6d,3b,5d,7b,6b",
            "5a,3c,6b,3b,6d,7c,4b,7b,4c,5d",
            "5a,3b,7c,7b,6d,5d,4b,4c,6b,3c",
            "4b,5a,6b,3b,7c,6d,3c,5d,7b,4c",
            "3b,7c,5d,3c,7b,5a,6b,6d,4c,4b",
            "3b,6b,3c,6d,7b,5a,5d,4c,7c,4b",
            "7b,6d,3c,4c,5d,4b,6b,5a,7c,3b",
            "4b,5d,3c,4c,6b,3b,7c,5a,7b,6d", // 20
            "5a,4c,4b,3b,7b,6d,5d,7c,6b,3c",
            "7c,3b,4b,7b,6b,5a,6d,3c,4c,5d",
            "4b,3c,5a,3b,6b,7b,7c,6d,5d,4c",
            "3b,5d,4b,7b,6d,3c,6b,5a,4c,7c",
            "6b,6d,4b,3b,5a,5d,7c,7b,4c,3c",
            "6b,7b,5d,3b,3c,5a,7c,4b,4c,6d",
            "3b,6b,5a,4c,6d,4b,7b,7c,3c,5d",
            "5d,3b,6d,5a,4c,6b,4b,7b,7c,3c",
            "3c,6d,5d,7c,4c,5a,6b,4b,3b,7b",
            "6b,5a,7b,4c,5d,6d,4b,3c,7c,3b", //30
            "4c,3c,6d,6b,7c,5a,3b,7b,4b,5d",
            "6d,4c,7b,5a,6b,3b,7c,4b,5d,3c",
            "7b,5a,3b,4c,3c,6b,5d,4b,6d,7c",
            "7c,4b,5a,6b,6d,7b,4c,3c,5d,3b",
            "6d,5d,3c,6b,5a,4b,3b,7b,7c,4c",
            "6b,6d,4c,5a,7c,7b,5d,3c,4b,3b",
            "3c,3b,4b,7c,5d,5a,6d,7b,4c,6b",
            "4b,3c,5d,5a,7c,4c,6d,6b,3b,7b",
            "5a,3b,6b,7b,3c,4b,6d,5d,4c,7c",
            "7c,5a,5d,3c,3b,6b,4c,4b,6d,7b", //40
            "6b,7b,5d,4c,7c,3c,3b,4b,6d,5a",
            "4b,4c,5a,7b,3b,6b,3c,5d,7c,6d",
            "5a,7c,5d,6d,7b,4c,3c,4b,6b,3b",
            "5d,6b,3b,5a,6d,7c,7b,4c,3c,4b",
            "3b,5d,5a,7b,4c,3c,7c,6d,4b,6b",
            "4b,6b,6d,3b,5d,7b,7c,5a,4c,3c",
            "5a,3c,4b,7c,5d,3b,6b,7b,4c,6d",
            "4c,4b,5a,4d,6b,3b,7b,6d,3c,7c",
            "5d,7b,3c,6d,4b,6b,3b,4c,7c,5a",
            "3b,3c,4b,4c,5a,5d,6b,6d,7b,7c" //50
    };
}