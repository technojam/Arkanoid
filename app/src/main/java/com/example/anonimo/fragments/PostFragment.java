package com.example.anonimo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anonimo.R;
import com.example.anonimo.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class PostFragment extends Fragment {

  FirebaseFirestore firebaseDb;
  User signedInUser = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_post, container, false);
        // Inflate the layout for this fragment
        firebaseDb= FirebaseFirestore.getInstance();




        return root;

    }
}