package com.example.healt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Activity1 extends AppCompatActivity {

    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        getSupportActionBar().hide();

        newArray = new int[]{

                R.id.boat_pose,R.id.boat_pose2,R.id.boat_pose3,R.id.boat_pose4,R.id.boat1_pose,R.id.boat2_pose,R.id.boat3_pose,R.id.boat4_pose,R.id.boat5_pose,R.id.boat6_pose,R.id.boat7_pose,R.id.boat8_pose,

        };

    }

    public void ImageBattonCliked(View view) {

        for (int i=0;i< newArray.length;i++){

            if (view.getId() == newArray[i]){

                int value = i+1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(Activity1.this, Activity2.class);
                intent.putExtra("value", String.valueOf(value));
                startActivity(intent); finish();

            }

        }

    }
}