package com.example.hp.showroom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                SharedPreferences mySharedPreferences;
                SharedPreferences.Editor myEditor;
                mySharedPreferences = getSharedPreferences("MyPreferences_001", 0);
                myEditor = mySharedPreferences.edit();
                boolean booleanvalue = mySharedPreferences.getBoolean("islogin", false);
                if (booleanvalue) {
                    startActivity(new Intent(getApplicationContext(), CarListActivity.class));
                }
                else{
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
                finish();
            }
        };
        countDownTimer.start();


    }
}
