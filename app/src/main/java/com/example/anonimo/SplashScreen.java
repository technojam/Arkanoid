package com.example.anonimo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.anonimo.activities.Login;
import com.example.anonimo.activities.introActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {

    FirebaseAuth mAuth;
   // private String user ;
    private Object FirebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser = mAuth.getCurrentUser();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                startActivity(new Intent(SplashScreen.this, introActivity.class));
//

                if (FirebaseUser != null){
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                }
                else{
                    startActivity(new Intent(SplashScreen.this,introActivity.class));
                }




            }
        },3000);
    }
}