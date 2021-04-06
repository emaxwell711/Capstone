package com.example.falluserstudy2019_v2.Controller;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.falluserstudy2019_v2.Activities.SlideActivity;
import com.example.falluserstudy2019_v2.Behavior.SlideBehavior;
import com.example.falluserstudy2019_v2.Constants;
import com.example.falluserstudy2019_v2.ExperimentManager;

public abstract class SlideController {

    private int session = 1;
    private int slideNumber = 0;
    private boolean speak = true;
    private String currentArea = "";
    private String lastArea = "";

    private List<Event> eventLog = new ArrayList<>();

    public void addStartEvent() {
        Event e = new Event(-1, -1, Event.START_EVENT, Event.AREA_NONE, Event.ACTION_NONE,
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    public void addPauseEvent() {
        Event e = new Event(-1, -1, Event.PAUSE_EVENT, Event.AREA_NONE, Event.ACTION_NONE,
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    public void addContinueEvent() {
        Event e = new Event(-1, -1, Event.CONTINUE_EVENT, Event.AREA_NONE, Event.ACTION_NONE,
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    public void addEndEvent() {
        Event e = new Event(-1, -1, Event.END_EVENT, Event.AREA_NONE, Event.ACTION_NONE,
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    public void addTouchEvent(float x, float y, String event, String area, String action) {
        Event e = new Event(x, y, event, stripStringOfComma(area), stripStringOfComma(action),
                slideNumber, ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
    }

    private String stripStringOfComma(String s) {
        String r = s.replaceAll("\\,", "\\_");
        System.out.println(r);
        return r;
    }

    public void addTouchEventUp(float x, float y) {
        Event e = new Event(x, y, Event.EVENT_UP, Event.AREA_NONE, Event.ACTION_UP, slideNumber,
                ExperimentManager.getParticipantID(), ExperimentManager.getGroupID(),
                ExperimentManager.getSessionID());
        eventLog.add(e);
        Log.d("Data", e.toCSVRow());
        currentArea="";
    }

    public SlideController() {
        this.session = 1;
        this.slideNumber = 0;
    }

    public SlideController(int session) {
        this.session = session;
        this.slideNumber = 0;
    }

    public boolean nextSlide() {
        if (slideNumber < getSlideArray(session).size() -1) {
            slideNumber = slideNumber + 1;
            return true;
        }
        return false;
    }

    public boolean backSlide() {
        if (slideNumber > 0) {
            slideNumber = slideNumber - 1;
            return true;
        }
        return false;
    }

    private void clearEventLog() {
        eventLog.clear();
    }

    private void saveCSVFile(String data) {
        String fileName = ExperimentManager.getParticipantID() + "_" + Constants.DATA_FILE;

        File folder = ExperimentManager.getPublicDataStorage("data");
        File file = new File(folder.getAbsolutePath() + File.separator + fileName);

        boolean needsHeader = false;

        Log.d("Data", data);

        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
                needsHeader = true;
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (needsHeader) {
                bw.write(Event.makeCSVHeader());
            }
            bw.write(data);
            bw.close();
            clearEventLog();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reactTapReadAgain(int x, int y, SlideActivity sa, String area) {
        sa.getController().addTouchEvent(x, y, Event.TAP, stripStringOfComma(area), Event.ACTION_TAP);
    }

    public void reactAreaThenLineBargraphNoRepeat(int x, int y, Bitmap bitmap, SlideActivity sa,
                                                  String action, String s) {
        Log.i("REACTION", "reactAreaThenLineBargraphNoRepeat called");

        if (sa.getTouchManagement().circleContains(-49091, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // bar
            sa.startVibration(4);
        }
        else if (sa.getTouchManagement().circleContains(-7829368, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // trend line
            sa.startVibration(4);
        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
            sa.stopVibration();
        }

        if (s.equals("Top of Bar 1") || s.equals("Top of Bar 2") || s.equals("Top of Bar 3") ||
                s.equals("Top of Bar 4") || s.equals("Top of Bar 5") || s.equals("Top of Bar 6") ||
                s.equals("Top of Bar 7")) {
            sa.playFreq();
        }
    }

    public void reactAreaThenLineBargraphGrid(int x, int y, SlideActivity sa, String action, String s) {
        // System.out.println("TEST: in speak");
        sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action);
        //sa.playClick();
        //sa.vibrateClick();
    }

    public void reactGridLine (int x, int y, Bitmap bitmap, SlideActivity sa, String action, String s) {
        Log.i("REACTION", "reactGridline called");
        sa.playClick();
        checkAreaSpeak(s, sa, y);

        if (sa.getTouchManagement().circleContains(-49091, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // bar
            sa.startVibration(4);

        }
//        else if (sa.getTouchManagement().circleContains(-7829368, x, y, bitmap)) {
//            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // trendline
//            sa.startVibration(4);
//
//        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
            sa.stopVibration();
        }

        if (s.equals("Top of Bar 1") || s.equals("Top of Bar 2") || s.equals("Top of Bar 3") ||
                s.equals("Top of Bar 4") || s.equals("Top of Bar 5") || s.equals("Top of Bar 6") ||
                s.equals("Top of Bar 7")) {
            sa.playFreq();
        }
    }

    public void reactGridLine2 (int x, int y, Bitmap bitmap, SlideActivity sa, String action, String s) {
        Log.i("REACTION", "reactGridline called");
        sa.playClick();
        checkAreaSpeak(s, sa, y);

        if (sa.getTouchManagement().circleContains(-49091, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // bar
            sa.startVibration(4);

        }
        else if (sa.getTouchManagement().circleContains(-7829368, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, s, action); // trendline
            sa.startVibration(4);

        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, s, action);
            sa.stopVibration();
        }

        if (s.equals("Top of Bar 1") || s.equals("Top of Bar 2") || s.equals("Top of Bar 3") ||
                s.equals("Top of Bar 4") || s.equals("Top of Bar 5") || s.equals("Top of Bar 6") ||
                s.equals("Top of Bar 7")) {
            sa.playFreq();
        }
    }

    void checkAreaSpeak(String area, SlideActivity sa, int y) {
        if (!currentArea.equals(area)) {
            currentArea = area;
            sa.speak(area);
        }
    }

    public void reactAreaThenLineBargraphNoSpeak(int x, int y, Bitmap bitmap, SlideActivity sa, String action) {

        if (!currentArea.equals("")) {
            lastArea = currentArea;
        }
        currentArea = "";
        if (sa.getTouchManagement().circleContains(-49091, x, y, bitmap)) {
            sa.getController().addTouchEvent(x, y, Event.ON_LINE, "Bar", action);
            sa.startVibration(4);
        }
        else {
            sa.getController().addTouchEvent(x, y, Event.OFF_LINE, Event.AREA_NONE, action);
            sa.stopVibration();
        }
    }

    abstract public List<SlideBehavior> getSlideArray(int session);

    public SlideBehavior getSlideBehavior() {
        return getSlideArray(session).get(slideNumber);
    }

    public int getDrawableID() {
        return getSlideArray(session).get(slideNumber).getGraphID();
    }

    public void commitData() {
        StringBuilder sb = new StringBuilder();
        for (Event event: eventLog) {
            sb.append(event.toCSVRow());
        }
        saveCSVFile(sb.toString());
    }
}
