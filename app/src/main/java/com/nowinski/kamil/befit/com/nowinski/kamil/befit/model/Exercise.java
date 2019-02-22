package com.nowinski.kamil.befit.com.nowinski.kamil.befit.model;

import android.widget.ImageView;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Exercise implements Serializable {
    private int exerciseNumber;
    private String exerciseName;
    private String exerciseDescription;
    private List<Integer> seriesReps;
    private int exerciseImageId;
    private int exerciseAnimationId;
    private boolean isDone;

    public Exercise(int exerciseNumber, String exerciseName, String exerciseDescription, List<Integer> seriesReps, int exerciseImageId, int exerciseAnimationId, boolean isDone)
    {
        this.exerciseNumber = exerciseNumber;
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.seriesReps = seriesReps;
        this.exerciseImageId = exerciseImageId;
        this.exerciseAnimationId = exerciseAnimationId;
        this.isDone = isDone;
    }

    public int getExerciseNumber() {
        return exerciseNumber;
    }

    public void setExerciseNumber(int exerciseNumber) {
        this.exerciseNumber = exerciseNumber;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public List<Integer> getSeriesReps() {
        return seriesReps;
    }

    public void setSeriesReps(List<Integer> seriesReps) {
        this.seriesReps = seriesReps;
    }

    public int getExerciseImageId() {
        return exerciseImageId;
    }

    public void setExerciseImageId(int exerciseImageId) {
        this.exerciseImageId = exerciseImageId;
    }

    public int getExerciseAnimationId() {
        return exerciseAnimationId;
    }

    public void setExerciseAnimationId(int exerciseAnimationId) {
        this.exerciseAnimationId = exerciseAnimationId;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }
}
