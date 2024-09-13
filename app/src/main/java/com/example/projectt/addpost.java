package com.example.projectt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addpost extends AppCompatActivity {

    private EditText editTitle, editDescription;
    private Button submitButton;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpost);

        // Initialize Firebase database reference


        // Initialize UI components
        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);

        submitButton = findViewById(R.id.submitButton);
        database = FirebaseDatabase.getInstance().getReference("/Posts");
    }


    public void handleSubmit(View view) {
        post model = new post(
                editTitle.getText().toString(),
                editDescription.getText().toString()

        );

        database.child(model.Title).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "Data Added Successfully ✅", Toast.LENGTH_SHORT).show();
                editDescription.setText("");
                editTitle.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error: Could not enter data ❌", Toast.LENGTH_SHORT).show();
            }
        });}}

