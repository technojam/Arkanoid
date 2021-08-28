package com.example.anonimo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anonimo.R;
import com.example.anonimo.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Signup extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText signup_name,signup_password,confirm_password;
    Button signup_Button;
    FirebaseFirestore Database;
    TextView already_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        Database = FirebaseFirestore.getInstance();
        signup_name = findViewById(R.id.signupname);
        signup_password = findViewById(R.id.signup_password);
        confirm_password = findViewById(R.id.confirm_password);
        already_account = findViewById(R.id.existing_account);

        signup_Button = findViewById(R.id.signup_button);

        signup_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signup_name.getText().toString() + "@gmail.com";
                String password = signup_password.getText().toString();
                String name = signup_name.getText().toString();

                if(signup_password.getText().toString().equals(confirm_password.getText().toString())){
                    User user = new User();
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setName(name);

                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Database.collection("Users").document().set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Intent i = new Intent(Signup.this,Login.class);
                                        Toast.makeText(Signup.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(i);
                                        finish();

                                    }
                                });

                            }else{
                                Toast.makeText(Signup.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }else{
                    Toast.makeText(Signup.this, "Your Password Dosen't match ,Please Check Your Password's Field", Toast.LENGTH_SHORT).show();
                }
            }
        });

        already_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this,Login.class);
                startActivity(i);
                finish();
            }
        });



    }
}