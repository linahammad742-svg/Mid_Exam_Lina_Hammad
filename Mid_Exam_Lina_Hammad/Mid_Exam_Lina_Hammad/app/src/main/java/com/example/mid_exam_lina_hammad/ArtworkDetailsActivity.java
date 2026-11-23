package com.example.mid_exam_lina_hammad;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);

        TextView txtDetails = findViewById(R.id.txtDetails);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnWebsite = findViewById(R.id.btnWebsite);

        String title = getIntent().getStringExtra("title");
        String artist = getIntent().getStringExtra("artist");
        String year = getIntent().getStringExtra("year");

        txtDetails.setText(
                "Artwork: " + title +
                        "\nArtist: " + artist +
                        "\nYear: " + year
        );

        btnBack.setOnClickListener(v -> finish());

        btnWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com")
            );
            startActivity(intent);
        });
    }
}
