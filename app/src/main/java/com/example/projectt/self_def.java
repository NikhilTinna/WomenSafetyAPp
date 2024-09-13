package com.example.projectt;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class self_def extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_def);

        // Get the container layout
        LinearLayout containerLayout = findViewById(R.id.containerLayout);

        // Add content for Technique 1: Palm Heel Strike
        addTechniqueContent(
                containerLayout,
                "Palm Heel Strike",
                "The palm heel strike is a powerful technique that involves using the bottom of your palm to strike an attacker's nose or chin. This technique is effective for creating distance and disorienting the assailant.",
                "https://www.youtube.com/watch?v=example_video_link"
        );

        // Add content for Technique 2: Knee Strike
        addTechniqueContent(
                containerLayout,
                "Knee Strike",
                "The knee strike is a close-quarters self-defense move. Lift your knee towards the attacker's groin or midsection, aiming to incapacitate them. This technique is useful when confronted at close range.",
                "https://www.youtube.com/watch?v=example_video_link"
        );

        // Add content for Technique 3: Wrist Grab Escape
        addTechniqueContent(
                containerLayout,
                "Wrist Grab Escape",
                "If someone grabs your wrist, knowing how to escape safely is crucial. Twist your arm in the direction of the thumb, making it difficult for the assailant to maintain their grip.",
                "https://www.youtube.com/watch?v=example_video_link"
        );

        // Add content for Technique 4: Ground Defense Techniques
        addTechniqueContent(
                containerLayout,
                "Ground Defense Techniques",
                "In case of being taken to the ground, it's essential to know how to defend yourself. Learn techniques like the guard position and basic ground escapes to protect yourself.",
                "https://www.youtube.com/watch?v=example_video_link"
        );

        // Add content for Technique 5: Verbal Self-Defense Strategies
        addTechniqueContent(
                containerLayout,
                "Verbal Self-Defense Strategies",
                "Effective communication can be a powerful tool in self-defense. Learn verbal strategies to de-escalate a situation, set boundaries, and seek help when needed.",
                "https://www.youtube.com/watch?v=example_video_link"
        );
    }

    private void addTechniqueContent(LinearLayout containerLayout, String title, String description, final String videoLink) {
        // Create a new button for each technique
        Button techniqueButton = new Button(this);
        techniqueButton.setText(title);
        techniqueButton.setTextSize(20);
        techniqueButton.setAllCaps(false);

        // Set the click listener to open the video link
        techniqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVideo(videoLink);
            }
        });

        // Add the button to the container layout
        containerLayout.addView(techniqueButton);

        // Add description text
        Button descriptionButton = new Button(this);
        descriptionButton.setText(description);
        descriptionButton.setAllCaps(false);
        containerLayout.addView(descriptionButton);

        // Add a separator line (optional)
        View separator = new View(this);
        separator.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2 // height in pixels
        ));
        separator.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        containerLayout.addView(separator);
    }

    private void openVideo(String videoLink) {
        // Open the YouTube video link in a browser or YouTube app
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoLink));
        startActivity(intent);
    }
}
