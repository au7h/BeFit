package com.nowinski.kamil.befit;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nowinski.kamil.befit.com.nowinski.kamil.befit.model.Training;
import com.nowinski.kamil.befit.utils.FileOperations;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BeginnerActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int numberOfDays = 30;
    private final String path = Environment.getExternalStorageDirectory().toString()+"/BeFitFiles";
    private List<Training> trainingList;
    private Button buttons[] = new Button[numberOfDays];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
        initializeButtons();
        checkJsonExist();
    }

    private void initializeButtons() {
            for(int i=0; i<numberOfDays; i++) {
                String buttonId = "day" + (i+1);
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                buttons[i] = findViewById(resId);
                buttons[i].setOnClickListener(this);
            }
    }

    private void checkJsonExist(){
        File lastFile = new File(path + "/progressBeg.txt");
        if(lastFile.exists()) {
            String jSonData = FileOperations.readFromFile(path + "/progressBeg.txt", this);
            Type listType = new TypeToken<ArrayList<Training>>() {
            }.getType();
            trainingList = new Gson().fromJson(jSonData, listType);
            int size = trainingList.size();
            for(int i = 0; i < size; i++) {
                buttons[i].setText("Dzień " + Integer.toString(i + 1) + " (" + Double.toString(trainingList.get(i).getProgress()) + "%)");
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(BeginnerActivity.this, DayTrainingActivity.class);
        intent.putExtra("buttonId", v.getId());
        Integer level = getIntent().getIntExtra("level", 0);
        intent.putExtra("level", level);
        startActivity(intent);
        this.finish();
    }
}
