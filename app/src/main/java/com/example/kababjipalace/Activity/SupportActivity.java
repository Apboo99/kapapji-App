package com.example.kababjipalace.Activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kababjipalace.R;

public class SupportActivity extends AppCompatActivity {
    ImageView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        exit.findViewById(R.id.exit3);
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SupportActivity.this, FoodActivity.class);
//                startActivity(intent);
//            }
//        });

    }
}