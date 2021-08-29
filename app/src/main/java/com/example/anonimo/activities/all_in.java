package com.example.anonimo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anonimo.R;
import com.google.firebase.auth.FirebaseAuth;

public class all_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_in);

        Button logout_btn =  findViewById(R.id.logout_btn);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signout();
            }
        });


    }

    private void signout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(all_in.this,Login.class));


    }

}