package com.example.edukalp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailVerificationActivity extends AppCompatActivity {

    private Button btn_verifyemail;
    private TextView tv_gobck;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        tv_gobck = findViewById(R.id.tvGoBack);
        tv_gobck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(EmailVerificationActivity.this,LoginActivity.class));
            }
        });

        btn_verifyemail = findViewById(R.id.btnVerify);
        btn_verifyemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user!=null)
                {
                    if(!user.isEmailVerified())
                    {
                        user.sendEmailVerification();
                        Toast.makeText(EmailVerificationActivity.this, "Verification Email Sent", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(EmailVerificationActivity.this, MainActivity.class));
                    }
                    else if(user.isEmailVerified())
                    {
//                        startActivity(new Intent(EmailVerificationActivity.this, MainActivity.class));
                        Toast.makeText(EmailVerificationActivity.this, "Enter Main Activity now", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
