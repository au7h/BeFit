package com.nowinski.kamil.befit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TreningPlanActivity extends AppCompatActivity implements View.OnClickListener {

    Button beginnerBtn, medAdvBtn, advBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trening_plan);
        beginnerBtn = findViewById(R.id.beginnerBtn);
        medAdvBtn = findViewById(R.id.medAdvBtn);
        advBtn = findViewById(R.id.advBtn);

        beginnerBtn.setOnClickListener(this);
        medAdvBtn.setOnClickListener(this);
        advBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(TreningPlanActivity.this, BeginnerActivity.class);
        Integer id = v.getId();
        if(id == beginnerBtn.getId())
            intent.putExtra("level", 1);
        else if (id == medAdvBtn.getId())
            intent.putExtra("level", 2);
        else
            intent.putExtra("level", 3);
        startActivity(intent);
        this.finish();
    }
}
