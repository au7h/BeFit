package com.nowinski.kamil.befit;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {
    private Button planTreningBtn, exitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //initialize main menu buttons
        planTreningBtn = findViewById(R.id.plan);
        exitBtn = findViewById(R.id.exitApp);
    }

    public void openTreningPlan(View view)
    {
        Intent intent = new Intent(MainMenuActivity.this, TreningPlanActivity.class);
        startActivity(intent);
    }

    public void exitApp(View view)
    {
        System.exit(0);
        finish();
    }

}
