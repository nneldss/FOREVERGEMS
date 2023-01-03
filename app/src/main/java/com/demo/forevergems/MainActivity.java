package com.demo.forevergems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
CardView ring, bracelet, necklace, earrings;

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        music = MediaPlayer.create(MainActivity.this, R.raw.introding);
        music.start();
        setContentView(R.layout.activity_main);

        ring = findViewById(R.id.ring);
        bracelet = findViewById(R.id.bracelet);
        necklace = findViewById(R.id.necklace);
        earrings = findViewById(R.id.earrings);

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this.Ring.class);
                startActivity(intent);

            }

        });

        bracelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this.Bracelet.class);
                startActivity(intent);
            }

        });

        necklace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this.Necklace.class);
                startActivity(intent);
            }

        });

        earrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this.Earrings.class);
                startActivity(intent);
            }

        });
    }
}

