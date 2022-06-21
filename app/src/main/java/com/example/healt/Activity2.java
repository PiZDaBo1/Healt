package com.example.healt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    String buttenvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextView;
    private boolean MTimeRunnig;
    private long MTimeLeftinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        buttenvalue = intent.getStringExtra("value");


        int intvalue = Integer.valueOf(buttenvalue);


        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_boat1);
                break;
            case 2:
                setContentView(R.layout.activity_boat2);
                break;
            case 3:
                setContentView(R.layout.activity_boat3);
                break;
            case 4:
                setContentView(R.layout.activity_boat4);
                break;
            case 5:
                setContentView(R.layout.activity_boat5);
                break;
            case 6:
                setContentView(R.layout.activity_boat6);
                break;
            case 7:
                setContentView(R.layout.activity_boat7);
                break;
            case 8:
                setContentView(R.layout.activity_boat8);
                break;
            case 9:
                setContentView(R.layout.activity_boat9);
                break;
            case 10:
                setContentView(R.layout.activity_boat10);
                break;
            case 11:
                setContentView(R.layout.activity_boat11);
                break;
            case 12:
                setContentView(R.layout.activity_boat12);
                break;

        }

        startBtn = findViewById(R.id.startbutton);
        mtextView = findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MTimeRunnig){

                    stopTimer();

                }else{

                    startTimer();

                }

            }
        });

        getSupportActionBar().hide();

    }

    private void stopTimer(){

        countDownTimer.cancel();
        MTimeRunnig=false;
        startBtn.setText("START");

    }

    private void startTimer(){

        final CharSequence value1 = mtextView.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num2.substring(3,5);

        final int numder = Integer.valueOf(num2) * 60+ Integer.valueOf(num3);
        MTimeLeftinmills = numder * 1000;

        countDownTimer = new CountDownTimer(MTimeLeftinmills,1000) {
            @Override
            public void onTick(long l) {

                MTimeLeftinmills = l;
                updateTimer();

            }

            @Override
            public void onFinish() {

                int newvalue = Integer.valueOf(buttenvalue)+1;
                if (newvalue <=7) {

                    Intent i = new Intent(Activity2.this, Activity2.class);
                    i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK);
                    i.putExtra("value", String.valueOf(newvalue));
                    startActivity(i);

                }else {

                    newvalue =1;
                    Intent i = new Intent(Activity2.this, Activity2.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.putExtra("value",String.valueOf(newvalue));
                    startActivity(i);

                }

            }
        }.start();
        startBtn.setText("Pause");
        MTimeRunnig = true;

    }

    private void updateTimer(){

        int minutes = (int) MTimeLeftinmills / 60000;
        int seconds = (int) MTimeLeftinmills % 60000 / 1000;

        String timeLeftText = "";
        if (minutes < 10)
            timeLeftText = "0";
        timeLeftText = timeLeftText + minutes + ":";
        if (seconds < 10)
            timeLeftText += "0";
        timeLeftText+=seconds;
        mtextView.setText(timeLeftText);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}