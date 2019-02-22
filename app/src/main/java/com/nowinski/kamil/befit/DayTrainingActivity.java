package com.nowinski.kamil.befit;

import android.app.Dialog;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nowinski.kamil.befit.com.nowinski.kamil.befit.model.Exercise;
import com.nowinski.kamil.befit.com.nowinski.kamil.befit.model.Training;
import com.nowinski.kamil.befit.tasks.InitializeExerciseListTask;
import com.nowinski.kamil.befit.utils.FileOperations;

import java.util.List;
import java.util.concurrent.ExecutionException;

import pl.droidsonroids.gif.GifImageView;

public class DayTrainingActivity extends AppCompatActivity {

    private List<Training> trainingList;

    private TextView exerciseName, description, serie1, serie2, serie3, serie4;
    private Button explainBtn, backBtn, nextExerciseBtn, returnBtn;
    private Dialog dialogBox;
    private GifImageView imgAnimation;
    private ImageView exercisePreview;
    private CheckBox done1, done2, done3, done4;
    private int dayOneIt = 0, actualDay = 0;

    private final String path = Environment.getExternalStorageDirectory().toString()+"/BeFitFiles";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_training);

        Integer level = getIntent().getIntExtra("level", 0);
        try {
            trainingList = new InitializeExerciseListTask().execute(level).get();
        } catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }

        exerciseName = findViewById(R.id.exerciseName);
        description = findViewById(R.id.description);
        exercisePreview = findViewById(R.id.exercisePreview);
        serie1 = findViewById(R.id.serie1);
        serie2 = findViewById(R.id.serie2);
        serie3 = findViewById(R.id.serie3);
        serie4 = findViewById(R.id.serie4);

        done1 = findViewById(R.id.done1);
        done1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
                done2.setEnabled(true);
            else
                done2.setEnabled(false);
        }
    });
        done2 = findViewById(R.id.done2);
        done2.setEnabled(false);
        done2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    done3.setEnabled(true);
                else
                    done3.setEnabled(false);
            }
        });
        done3 = findViewById(R.id.done3);
        done3.setEnabled(false);
        done3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    done4.setEnabled(true);
                else
                    done4.setEnabled(false);
            }
        });
        done4 = findViewById(R.id.done4);
        done4.setEnabled(false);
        done4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    nextExerciseBtn.setEnabled(true);
                else
                    nextExerciseBtn.setEnabled(false);
            }
        });

        explainBtn = findViewById(R.id.explainBtn);
        backBtn = findViewById(R.id.backBtn);
        nextExerciseBtn = findViewById(R.id.nextExerciseBtn);
        nextExerciseBtn.setEnabled(false);

        int buttonId = getIntent().getIntExtra("buttonId", 0);
        if(buttonId == 0 )
            Log.d("buttonId", "Error");
        switch (buttonId) {
            case R.id.day1:
                showActualExercise(0);
                break;
            case R.id.day2:
                showActualExercise(1);
                break;
            case R.id.day3:
                showActualExercise(2);
                break;
            case R.id.day4:
                showActualExercise(3);
                break;
            case R.id.day5:
                showActualExercise(4);
                break;
            case R.id.day6:
                showActualExercise(5);
                break;
            case R.id.day7:
                showActualExercise(6);
                break;
            case R.id.day8:
                showActualExercise(7);
                break;
            case R.id.day9:
                showActualExercise(8);
                break;
            case R.id.day10:
                showActualExercise(9);
                break;
            case R.id.day11:
                showActualExercise(10);
                break;
            case R.id.day12:
                showActualExercise(11);
                break;
            case R.id.day13:
                showActualExercise(12);
                break;
            case R.id.day14:
                showActualExercise(13);
                break;
            case R.id.day15:
                showActualExercise(14);
                break;
            case R.id.day16:
                showActualExercise(15);
                break;
            case R.id.day17:
                showActualExercise(16);
                break;
            case R.id.day18:
                showActualExercise(17);
                break;
            case R.id.day19:
                showActualExercise(18);
                break;
            case R.id.day20:
                showActualExercise(19);
                break;
            case R.id.day21:
                showActualExercise(20);
                break;
            case R.id.day22:
                showActualExercise(21);
                break;
            case R.id.day23:
                showActualExercise(22);
                break;
            case R.id.day24:
                showActualExercise(23);
                break;
            case R.id.day25:
                showActualExercise(24);
                break;
            case R.id.day26:
                showActualExercise(25);
                break;
            case R.id.day27:
                showActualExercise(26);
                break;
            case R.id.day28:
                showActualExercise(27);
                break;
            case R.id.day29:
                showActualExercise(28);
                break;
            case R.id.day30:
                showActualExercise(29);
                break;
            default:
        }
    }

    private void showActualExercise(int day){
        actualDay = day;
        dayOneIt = 0;

        for(Exercise e : trainingList.get(day).getExercises()){
            if(!e.isDone())
                break;
            dayOneIt++;
        }

        if(dayOneIt==trainingList.get(day).getExercises().size())
        {
            //show day training done activity
            Intent intent = new Intent(DayTrainingActivity.this, DayTrainingDoneActivity.class);
            intent.putExtra("day","Dzień " + (day + 1) + " ukończony!");
            startActivity(intent);
            this.finish();
            return;
        }
        exerciseName.setText(trainingList.get(day).getExercises().get(dayOneIt).getExerciseName());
        exercisePreview.setImageResource(trainingList.get(day).getExercises().get(dayOneIt).getExerciseImageId());
        serie1.setText("Seria pierwsza, " + trainingList.get(day).getExercises().get(dayOneIt).getSeriesReps().get(0).toString() + " potwórzeń");
        serie2.setText("Seria druga, " + trainingList.get(day).getExercises().get(dayOneIt).getSeriesReps().get(1).toString() + " potwórzeń");
        serie3.setText("Seria trzecia, " + trainingList.get(day).getExercises().get(dayOneIt).getSeriesReps().get(2).toString() + " potwórzeń");
        serie4.setText("Seria czwarta, " + trainingList.get(day).getExercises().get(dayOneIt).getSeriesReps().get(3).toString() + " potwórzeń");
        explainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialogBox(trainingList.get(actualDay).getExercises().get(dayOneIt).getExerciseAnimationId(), trainingList.get(actualDay).getExercises().get(dayOneIt).getExerciseDescription());
            }
        });

    }

    private void createDialogBox(int resourceId, String descriptionTxt){
        dialogBox = new Dialog(DayTrainingActivity.this);
        dialogBox.setContentView(R.layout.dialog_box_layout);
        dialogBox.setTitle("Animacja ćwiczenia");
        returnBtn = dialogBox.findViewById(R.id.return_btn);
        imgAnimation = dialogBox.findViewById(R.id.img_animation);
        imgAnimation.setImageResource(resourceId);
        description = dialogBox.findViewById(R.id.description);
        description.setText(descriptionTxt);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.cancel();
            }
        });
        dialogBox.show();
    }

    public void backToDays(View v){
        Intent intent = new Intent(DayTrainingActivity.this, BeginnerActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void loadNextExercise(View v){
        trainingList.get(actualDay).getExercises().get(dayOneIt).setDone(true);
        double x = 100 * (dayOneIt+1) / trainingList.get(actualDay).getExercises().size();
        trainingList.get(actualDay).setProgress(x);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(trainingList);
        FileOperations.createFile(path,"progressBeg", json);
        done1.setChecked(false);
        done2.setChecked(false);
        done3.setChecked(false);
        done4.setChecked(false);
        showActualExercise(actualDay);
    }
}
