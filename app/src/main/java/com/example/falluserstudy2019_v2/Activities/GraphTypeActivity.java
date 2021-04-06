package com.example.falluserstudy2019_v2.Activities;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.falluserstudy2019_v2.Constants;
import com.example.falluserstudy2019_v2.Controller.BGEController;
import com.example.falluserstudy2019_v2.Controller.BGTController;
import com.example.falluserstudy2019_v2.Controller.TrainingEController;
import com.example.falluserstudy2019_v2.Controller.TrainingTController;
import com.example.falluserstudy2019_v2.ExperimentManager;
import com.example.falluserstudy2019_v2.R;

public class GraphTypeActivity extends Activity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphtype);
    }

    private void goToGroupScreen(int sessionNumber, View v) {
        Intent intent = new Intent(v.getContext(), GroupChoiceActivity.class);

        intent.putExtra(Constants.EXTRA_SESSION, sessionNumber);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Button touchTrainingButton = findViewById(R.id.touchTrainingButton);
        touchTrainingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExperimentManager.setSessionID(0);
                goToSlide(ExperimentManager.getParticipantID(), 0, v);
            }
        });

        final Button touchButton = findViewById(R.id.touchButton);
        touchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExperimentManager.setSessionID(1);
                goToSlide(ExperimentManager.getParticipantID(), 1, v);
            }
        });

        final Button embossTrainingButton = findViewById(R.id.embossTrainingButton);
        embossTrainingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExperimentManager.setSessionID(2);
                goToSlide(ExperimentManager.getParticipantID(), 2, v);
            }
        });

        final Button embossButton = findViewById(R.id.embossButton);
        embossButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExperimentManager.setSessionID(3);
                goToSlide(ExperimentManager.getParticipantID(), 3, v);
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    private void goToSlide(int participantID, int sessionNumber, View v) {
        Intent intent = new Intent(v.getContext(), SlideActivity.class);
        int groupNumber = participantID % 32;
        ExperimentManager.setGroup(groupNumber);

        if (sessionNumber == 0) {
            System.out.println("GROUP NUMBER: " + groupNumber);
            ExperimentManager.setController(new TrainingTController(sessionNumber, groupNumber));
        }
        else if (sessionNumber == 1) {
            System.out.println("GROUP NUMBER: " + groupNumber);
            ExperimentManager.setController(new BGTController(sessionNumber, groupNumber));
        }
        else if (sessionNumber == 2) {
            System.out.println("GROUP NUMBER: " + groupNumber);
            ExperimentManager.setController(new TrainingEController(sessionNumber, groupNumber));
        }
        else {
            System.out.println("GROUP NUMBER: " + groupNumber);
            ExperimentManager.setController(new BGEController(sessionNumber, groupNumber));
        }

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
