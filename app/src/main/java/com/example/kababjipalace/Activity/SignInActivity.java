package com.example.kababjipalace.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kababjipalace.R;
import com.example.kababjipalace.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {
    ActivitySignInBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;
    ProgressDialog progressDialog;
    TextInputEditText email;

    TextInputEditText password;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(SignInActivity.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Login to your account");
        email = findViewById(R.id.email1);
        password = findViewById(R.id.sign_in_pass);
        btnLogin = findViewById(R.id.btn_signin);
        binding.btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                auth.signInWithEmailAndPassword
                                (binding.email1.getText().toString(), binding.signInPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(SignInActivity.this, IntroActivity.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    setContentView(R.layout.activity_sign_in);
                                }
                            }
                        });


            }
        });

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (binding.email1.getText().toString().equals(null) &&
//                        binding.signInPass.getText().toString().equals(null)
//                ){
//                    Toast.makeText(SignInActivity.this, "Enter email to login", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        binding.createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        binding.forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetmail = new EditText(v.getContext());
                AlertDialog.Builder password = new AlertDialog.Builder(v.getContext());

                password.setTitle("Reset Password ?");
                password.setMessage("Enter your email to receive link...");
                password.setView(resetmail);

                password.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail = resetmail.getText().toString();
                        auth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(SignInActivity.this, "Reset link sent to your email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SignInActivity.this, "Reset link is not sent..!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                password.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                password.create().show();
            }
        });
        if (auth.getCurrentUser() != null) {
            Intent intent1 = new Intent(SignInActivity.this, IntroActivity.class);
            startActivity(intent1);
        }
        else{
            Toast.makeText(this, "enter your data", Toast.LENGTH_SHORT).show();
        }
        email.findViewById(R.id.nameofuser);
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("key", email.getText().toString());


    }

//    @Override
//    protected void onResume() {
//        super.onResume();

//    }
}
