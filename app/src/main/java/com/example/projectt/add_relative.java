package com.example.projectt;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_relative extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    Button btnAdd, btnView;
    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_relative);

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();

        if (currentUser == null) {
            // Redirect to login or handle the case where no user is logged in
            // You might want to redirect to a login activity or show an error message
            // For simplicity, I'm finishing the activity in this case
            finish();
            return;
        }

        // Use the user's UID as a reference in the database
        String userUid = currentUser.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userUid).child("relatives");

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                String newEntry1 = editText2.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    AddData(newEntry1);
                    editText.setText("");
                } else {
                    Toast.makeText(add_relative.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle viewing data from Firebase if needed
            }
        });
    }

    public void AddData(String newEntry) {
        String key = databaseReference.push().getKey();

        databaseReference.child(key).setValue(newEntry)
                .addOnSuccessListener(aVoid -> Toast.makeText(add_relative.this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show())
                .addOnFailureListener(e -> Toast.makeText(add_relative.this, "Something went wrong :(.", Toast.LENGTH_LONG).show());
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action, keycode;

        action = event.getAction();
        keycode = event.getKeyCode();

        switch (keycode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (KeyEvent.ACTION_UP == action) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"));
                    if (ActivityCompat.checkSelfPermission(add_relative.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(add_relative.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                    } else {
                        callIntent.setData(Uri.parse("tel:"));
                        startActivity(callIntent);
                    }
                    startActivity(callIntent);
                }
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (KeyEvent.ACTION_DOWN == action) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"));
                    if (ActivityCompat.checkSelfPermission(add_relative.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(add_relative.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                    } else {
                        callIntent.setData(Uri.parse("tel:"));
                        startActivity(callIntent);
                    }
                    startActivity(callIntent);
                }
                break;
        }
        return super.dispatchKeyEvent(event);
    }
}
