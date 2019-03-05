package com.nowinski.kamil.befit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DayTrainingDoneActivity extends AppCompatActivity {

    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_training_done);
        // gets the previously created intent
        Intent intent = getIntent();
        level = getIntent().getIntExtra("level", 0);
        String day = intent.getStringExtra("day");
        TextView successInfo = findViewById(R.id.successInfo);
        successInfo.setText(day);
    }

    public void ReturnToPlan(View v){
        Intent intent = new Intent(DayTrainingDoneActivity.this, BeginnerActivity.class);
        intent.putExtra("level", level);
        startActivity(intent);
        this.finish();
    }
}
