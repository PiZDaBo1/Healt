package com.example.healt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

        Button signup = findViewById(R.id.signup1);
        Button login = findViewById(R.id.login1);
        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.emaill);
        TextView password1 = findViewById(R.id.password1);
        TextView password = findViewById(R.id.password2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sign_up.this, Login.class);
                startActivity(i);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText())) {
                    Toast.makeText(Sign_up.this, "Введите вашу почту", Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(name.getText())) {
                    Toast.makeText(Sign_up.this, "Введите ваше имя", Toast.LENGTH_LONG).show();
                }
                if (password1.getText().length() < 6) {
                    Toast.makeText(Sign_up.this, "Введите пароль, состоящий из 6 или более символов", Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(password.getText())) {
                    Toast.makeText(Sign_up.this, "Подтвердите пароль", Toast.LENGTH_LONG).show();
                    if (password == password1) {
                        Toast.makeText(Sign_up.this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
                    }
                }
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task .isSuccessful()){
                            Toast.makeText(Sign_up.this, "Вы зарегистрировались)", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Sign_up.this, MainActivity.class));
                            Sign_up.this.finish();

                            HashMap<String, Object> profile = new HashMap<>();
                            profile.put("name",name.getText().toString());
                            databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(profile);
                        } else {
                            Toast.makeText(Sign_up.this, "Вы не зарегестрировались", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        getSupportActionBar().hide();

        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}