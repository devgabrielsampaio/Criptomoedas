package com.example.criptomoedas;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;

public class Tela_Principal extends AppCompatActivity {
    private final Timer timer= new Timer();
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        timerTask=new TimerTask(){
            @Override
            public void run(){
                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        gotoMainActivity();
                    }
                });
            }

        };
        timer.schedule(timerTask,5000);
    }

    private void gotoMainActivity() {
        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}