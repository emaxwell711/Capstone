package com.example.falluserstudy2019_v2.Controller;

import com.example.falluserstudy2019_v2.Behavior.Bar3ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar3BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar3DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar3CBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehaviorPolygon;

import java.util.ArrayList;
import java.util.List;

public class Group1Controller extends SlideController{

    List<SlideBehavior> session1 = new ArrayList<>();
    List<SlideBehavior> session2 = new ArrayList<>();

    public Group1Controller(int session) {
        super(session);

        createBehaviors();
    }

    private void createBehaviors() {
        setUpSession1();
        setUpSession2();
    }

    public void setUpSession1() {
        SlideBehaviorPolygon slide1 = new Bar3ABehavior(this);
        SlideBehaviorPolygon slide2 = new Bar3BBehavior(this);
        SlideBehaviorPolygon slide3 = new Bar3DBehavior(this);
        SlideBehaviorPolygon slide4 = new Bar3CBehavior(this);

        session1.add(slide1);
        session1.add(slide2);
        session1.add(slide3);
        session1.add(slide4);
    }

    public void setUpSession2() {
        SlideBehaviorPolygon slide1 = new Bar3ABehavior(this);
        SlideBehaviorPolygon slide2 = new Bar3BBehavior(this);
        SlideBehaviorPolygon slide3 = new Bar3DBehavior(this);
        SlideBehaviorPolygon slide4 = new Bar3CBehavior(this);

        session1.add(slide1);
        session1.add(slide2);
        session1.add(slide3);
        session1.add(slide4);
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        if (session == 1) {
            return session1;
        }
        return session2;
    }
}
