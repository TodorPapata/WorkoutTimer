package com.example.todor.workouttimer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast toast;
    Context context;
    CharSequence text;
    int duration;

    TextView workingTime;
    int workingSeconds;

    TextView restTime;
    int restSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = getApplicationContext();
        this.text = "Well done!";
        this.duration = Toast.LENGTH_LONG;
        this.toast = Toast.makeText(context, text, duration);

        this.workingTime =(TextView) findViewById(R.id.workingSeconds);
        this.restTime = (TextView) findViewById(R.id.rest_seconds);

    }



    public void onClick(View view){


        this.workingSeconds = Integer.parseInt(workingTime.getText().toString());
        this.restSeconds = Integer.parseInt(restTime.getText().toString());

        final CountDownTimer restTimer = new CountDownTimer(this.restSeconds*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                toast.show();
                makeBeepNoice();
            }
        };

        CountDownTimer workTimer = new CountDownTimer(this.workingSeconds*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                makeBeepNoice();
                restTimer.start();
            }
        };


        workTimer.start();
    }

    private void makeBeepNoice() {
        final MediaPlayer beepSoundMP = MediaPlayer.create(this,R.raw.beep_sound);
        beepSoundMP.start();
    }


}
