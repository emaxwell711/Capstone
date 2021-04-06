package com.example.falluserstudy2019_v2.Activities;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.falluserstudy2019_v2.Constants;
import com.example.falluserstudy2019_v2.Controller.Group1Controller;
import com.example.falluserstudy2019_v2.Controller.Group2Controller;
import com.example.falluserstudy2019_v2.Controller.Group3Controller;
import com.example.falluserstudy2019_v2.Controller.TrainingTController;
import com.example.falluserstudy2019_v2.ExperimentManager;
import com.example.falluserstudy2019_v2.R;

public class GroupChoiceActivity extends Activity {

    private int sessionNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Intent mIntent = getIntent();
        sessionNumber = mIntent.getIntExtra(Constants.EXTRA_SESSION, 1);
    }

    private void goToSlide(int groupNumber, View v) {
        Intent intent = new Intent(v.getContext(), SlideActivity.class);

        switch (groupNumber) {
            case 0:
                ExperimentManager.setController(new TrainingTController(sessionNumber, groupNumber));
                break;

            case 1:
                ExperimentManager.setController(new Group1Controller(sessionNumber));
                break;

            case 2:
                ExperimentManager.setController(new Group2Controller(sessionNumber));
                break;

            case 3:
                ExperimentManager.setController(new Group3Controller(sessionNumber));
                break;
        }

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        final Button training = findViewById(R.id.training);
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExperimentManager.setGroup(0);
                goToSlide(0, view);
            }
        });

        final Button group1 = findViewById(R.id.group1);
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExperimentManager.setGroup(1);
                goToSlide(1, view);
            }
        });

        final Button group2 = findViewById(R.id.group2);
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExperimentManager.setGroup(2);
                goToSlide(2, view);
            }
        });

        final Button group3 = findViewById(R.id.group3);
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExperimentManager.setGroup(3);
                goToSlide(3, view);
            }
        });
    }
}
