package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button roll;
    private TextView result1;
    private TextView resul2;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void init() {
        roll = (Button) findViewById(R.id.rollButton);
        result1 = (TextView) findViewById(R.id.result1);
        resul2 = (TextView) findViewById(R.id.result2);
        roll.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.sound);
    }

    @Override
    public void onClick(View v) {
        mediaPlayer.start();
        int rand = new Random().nextInt(6);
        int randd = new Random().nextInt(6);
        result1.setText(String.valueOf(rand + 1));
        resul2.setText(String.valueOf(randd + 1));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}