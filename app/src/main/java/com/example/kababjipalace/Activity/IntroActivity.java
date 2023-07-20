package com.example.kababjipalace.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kababjipalace.R;

public class IntroActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        btn=findViewById(R.id.getStarted);
        btn.setOnClickListener(v -> {
            Intent intent=new Intent(IntroActivity.this,FoodActivity.class);
            startActivity(intent);
        });

    }
}