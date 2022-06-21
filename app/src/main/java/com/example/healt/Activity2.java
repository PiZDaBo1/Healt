package com.example.healt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    String buttonvalue;
    Button startBtn, next;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunnig;
    private long MTimeLeftinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");


        int intvalue = Integer.valueOf(buttonvalue);


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
        mtextview = findViewById(R.id.time);
        next = findViewById(R.id.close);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity2.this, Activity1.class);
                startActivity(i);
                finish();
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(59000, 1000) {
                    @Override
                    public void onTick(long l) {
                        mtextview.setText("00:" + l/1000);
                    }

                    @Override
                    public void onFinish() {
                        mtextview.setText("-");
                    }
                }.start();
            }
        });

        getSupportActionBar().hide();

    }

}