package com.example.kababjipalace.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kababjipalace.R;

public class ProfileActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Name();
        exit();

    }
    public void Name(){
        TextView name = findViewById(R.id.nameofuser);
//        name.setText(getIntent().getStringExtra("key"));
        name.setText("Mohamed");
    }
    public void exit(){
        ImageView exit = findViewById(R.id.exit2);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,FoodActivity.class);
                startActivity(intent);
            }
        });
    }
}
