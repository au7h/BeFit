package com.nowinski.kamil.befit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DayTrainingDoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_training_done);
        Intent intent = getIntent(); // gets the previously created intent
        String day = intent.getStringExtra("day");
        TextView successInfo = findViewById(R.id.successInfo);
        successInfo.setText(day);
    }

    public void ReturnToPlan(View v){
        Intent intent = new Intent(DayTrainingDoneActivity.this, BeginnerActivity.class);
        startActivity(intent);
        this.finish();
    }
}
