package com.example.mid_exam_lina_hammad;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int currentIndex = 0;

    private ImageView imgArtwork;
    private TextView txtCounter, txtTitle, txtArtist;
    private Button btnPrevious, btnNext;

    private final int[] images = {
            R.drawable.art1,
            R.drawable.art2,
            R.drawable.art3,
            R.drawable.art4,
            R.drawable.art5,
            R.drawable.art6
    };

    private final String[] titles = {
            "Starry Night",
            "Mona Lisa",
            "The Great Wave",
            "The Scream",
            "Girl with a Pearl Earring",
            "Sunflowers"
    };

    private final String[] artists = {
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Hokusai",
            "Edvard Munch",
            "Johannes Vermeer",
            "Vincent van Gogh"
    };

    private final String[] years = {
            "1889", "1503", "1831",
            "1893", "1665", "1888"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgArtwork = findViewById(R.id.imgArtwork);
        txtCounter = findViewById(R.id.txtCounter);
        txtTitle = findViewById(R.id.txtTitle);
        txtArtist = findViewById(R.id.txtArtist);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("artworkIndex", 0);
        }

        updateArtwork();

        btnNext.setOnClickListener(v -> {
            if (currentIndex < images.length - 1) {
                currentIndex++;
                updateArtwork();
            }
        });

        btnPrevious.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateArtwork();
            }
        });

        imgArtwork.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    ArtworkDetailsActivity.class);

            intent.putExtra("title", titles[currentIndex]);
            intent.putExtra("artist", artists[currentIndex]);
            intent.putExtra("year", years[currentIndex]);

            startActivity(intent);
        });
    }

    private void updateArtwork() {
        imgArtwork.setImageResource(images[currentIndex]);

        txtCounter.setText((currentIndex + 1) + " / " + images.length);

        txtTitle.setText(titles[currentIndex]);

        txtArtist.setText(artists[currentIndex] + ", " + years[currentIndex]);

        btnPrevious.setEnabled(currentIndex != 0);

        btnNext.setEnabled(currentIndex != images.length - 1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("artworkIndex", currentIndex);
        super.onSaveInstanceState(outState);
    }
}
