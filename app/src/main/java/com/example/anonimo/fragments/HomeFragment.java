package com.example.anonimo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anonimo.R;
import com.example.anonimo.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class HomeFragment extends Fragment {
    FirebaseAuth mAuth;
    // private String user ;
    private Object FirebaseUser;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root =  inflater.inflate(R.layout.fragment_home, container, false);
      TextView show_current_user = root.findViewById(R.id.show_current_user);








        // Inflate the layout for this fragment
        return (View) root;



    }
}