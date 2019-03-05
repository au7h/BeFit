package com.nowinski.kamil.befit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TreningPlanActivity extends AppCompatActivity implements View.OnClickListener {

    Button beginnerBtn, medAdvBtn, advBtn;
    private final String passLevelParameterName = "level";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trening_plan);
        initGuiElements();
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(TreningPlanActivity.this, BeginnerActivity.class);
        Integer id = v.getId();
        if(id == beginnerBtn.getId())
            intent.putExtra(passLevelParameterName, 1);
        else if (id == medAdvBtn.getId())
            intent.putExtra(passLevelParameterName, 2);
        else
            intent.putExtra(passLevelParameterName, 3);
        startActivity(intent);
        this.finish();
    }

    private void initGuiElements(){
        beginnerBtn = findViewById(R.id.beginnerBtn);
        medAdvBtn = findViewById(R.id.medAdvBtn);
        advBtn = findViewById(R.id.advBtn);

        beginnerBtn.setOnClickListener(this);
        medAdvBtn.setOnClickListener(this);
        advBtn.setOnClickListener(this);
    }
}
