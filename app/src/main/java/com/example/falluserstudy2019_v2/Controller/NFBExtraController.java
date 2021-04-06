package com.example.falluserstudy2019_v2.Controller;

import com.example.falluserstudy2019_v2.Behavior.Bar3ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar3BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar3DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar3CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar4ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar4BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar4CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar4DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar5ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar5BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar5CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar5DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar6ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar6BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar6CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar6DBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar7ABehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar7BBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar7CBehavior;
import com.example.falluserstudy2019_v2.Behavior.Bar7DBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehavior;
import com.example.falluserstudy2019_v2.Behavior.SlideBehaviorPolygon;

import java.util.ArrayList;
import java.util.List;

public class NFBExtraController extends SlideController {

    List<SlideBehavior> session1 = new ArrayList<>();

    public NFBExtraController(int session) {
        super(session);

        createBehaviors();
    }

    private void createBehaviors() {

        setUpSession1();
    }

    public void setUpSession1() {

        SlideBehaviorPolygon slide3a = new Bar3ABehavior(this);
        SlideBehaviorPolygon slide3b = new Bar3BBehavior(this);
        SlideBehaviorPolygon slide3c = new Bar3CBehavior(this);
        SlideBehaviorPolygon slide3d = new Bar3DBehavior(this);

        SlideBehaviorPolygon slide4a = new Bar4ABehavior(this);
        SlideBehaviorPolygon slide4b = new Bar4BBehavior(this);
        SlideBehaviorPolygon slide4c = new Bar4CBehavior(this);
        SlideBehaviorPolygon slide4d = new Bar4DBehavior(this);

        SlideBehaviorPolygon slide5a = new Bar5ABehavior(this);
        SlideBehaviorPolygon slide5b = new Bar5BBehavior(this);
        SlideBehaviorPolygon slide5c = new Bar5CBehavior(this);
        SlideBehaviorPolygon slide5d = new Bar5DBehavior(this);

        SlideBehaviorPolygon slide6a = new Bar6ABehavior(this);
        SlideBehaviorPolygon slide6b = new Bar6BBehavior(this);
        SlideBehaviorPolygon slide6c = new Bar6CBehavior(this);
        SlideBehaviorPolygon slide6d = new Bar6DBehavior(this);

        SlideBehaviorPolygon slide7a = new Bar7ABehavior(this);
        SlideBehaviorPolygon slide7b = new Bar7BBehavior(this);
        SlideBehaviorPolygon slide7c = new Bar7CBehavior(this);
        SlideBehaviorPolygon slide7d = new Bar7DBehavior(this);

        session1.add(slide3a);
        session1.add(slide3b);
        session1.add(slide3c);
        session1.add(slide3d);

        session1.add(slide4a);
        session1.add(slide4b);
        session1.add(slide4c);
        session1.add(slide4d);

        session1.add(slide5a);
        session1.add(slide5b);
        session1.add(slide5c);
        session1.add(slide5d);

        session1.add(slide6a);
        session1.add(slide6b);
        session1.add(slide6c);
        session1.add(slide6d);

        session1.add(slide7a);
        session1.add(slide7b);
        session1.add(slide7c);
        session1.add(slide7d);
    }

    @Override
    public List<SlideBehavior> getSlideArray(int session) {
        return session1;
    }
}