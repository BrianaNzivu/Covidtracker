package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Mainslider extends AppCompatActivity {
    @BindView(R.id.goHome) Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainslider);
        ButterKnife.bind(this);

        mainButton.setOnClickListener(view -> {
            Intent intent = new Intent(Mainslider.this, Home.class);
            startActivity(intent);
        });
    }
}