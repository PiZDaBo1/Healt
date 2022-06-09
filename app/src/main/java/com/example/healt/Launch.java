package com.example.healt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Launch extends AppCompatActivity {

    Animation up, down;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        TextView text = findViewById(R.id.textView);
        down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down);
        text.setAnimation(up);

        ImageView image = findViewById(R.id.imageView);
        up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up);
        image.setAnimation(up);

        FirebaseUser currentUser = FirebaseAuth.getInstance ().getCurrentUser ();
        new Handler().postDelayed(new Runnable () {
            @Override
            public void run() {
                if (currentUser != null) {
                    startActivity (new Intent(Launch.this, MainActivity.class));
                    Launch.this.finish ();
                } else {
                    startActivity (new Intent (Launch.this, Login.class));
                    Launch.this.finish();
                }
            }
        },1*2500);

        

        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}