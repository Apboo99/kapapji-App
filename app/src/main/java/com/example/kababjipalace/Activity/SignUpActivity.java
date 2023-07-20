package com.example.kababjipalace.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kababjipalace.Models.Users;
import com.example.kababjipalace.R;
import com.example.kababjipalace.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("we are creating your account");



        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword
                        (binding.email1.getText().toString(),binding.signUpPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            Users users = new Users(binding.name.getText().toString(),
                                    binding.email1.getText().toString(),
                                    binding.signUpPass.getText().toString());
                            String id = task.getResult().getUser().getUid();
                            firebaseDatabase.getReference().child("Users").child(id).setValue(users);
                            setContentView(R.layout.activity_sign_in);
                            Toast.makeText(SignUpActivity.this, "Sign Up Is Successful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            setContentView(R.layout.activity_sign_up);
                            Toast.makeText(SignUpActivity.this, "Sign Up Is Failed", Toast.LENGTH_SHORT).show();


                        }
                    }
                });


            }
        });

        binding.alreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent1);
            }
        });




    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Name.findViewById(R.id.nameofuser);
//        Intent intent = new Intent(this,ProfileActivity.class);
//        intent.putExtra("key",Name.getText().toString());
//    }
}