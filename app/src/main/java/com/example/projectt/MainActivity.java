package com.example.projectt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void LogOut(){
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }
    public void helplineNumbers(View v){
        Intent i = new Intent(getApplicationContext(), helpline_numbers.class);
        startActivity(i);
    }
    public void post(View v){
        Intent i = new Intent(getApplicationContext(), posts.class);
        startActivity(i);
    }
    public void selfd(View v){
        Intent i = new Intent(getApplicationContext(), self_def.class);
        startActivity(i);
    }
    public void addc(View v){
        Intent i = new Intent(getApplicationContext(),add_relative.class);
        startActivity(i);
    }
}