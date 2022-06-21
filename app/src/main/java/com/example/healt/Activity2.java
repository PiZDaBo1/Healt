package com.example.healt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {

    String buttenvalue;

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

    }
}