package com.nowinski.kamil.befit;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;

import java.util.Arrays;

public class MainMenuActivity extends AppCompatActivity {
    private Button planTreningBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Initialize main menu buttons
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
