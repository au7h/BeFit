package com.nowinski.kamil.befit.com.nowinski.kamil.befit.model;

import java.io.Serializable;
import java.util.List;

public class Training implements Serializable {
    private int day;
    private int numberOfExercises;
    private List<Exercise> exercises;
    private double progress;
    private boolean isDone;

    public Training(int day, int numberOfExercises, List<Exercise> exercises, int progress, boolean isDone)
    {
        this.day = day;
        this.numberOfExercises = numberOfExercises;
        this.exercises = exercises;
        this.progress = progress;
        this.isDone = isDone;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getNumberOfExercises() {
        return numberOfExercises;
    }

    public void setNumberOfExercises(int numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
