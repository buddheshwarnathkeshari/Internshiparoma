package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnLogin=findViewById(R.id.btn_login);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_pass);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = email.getText().toString().toLowerCase().trim();
                String userPassword = password.getText().toString();

                String validate = SignOperations.validateLoginUser(userEmail, userPassword);

                if(validate.equals("Valid")) {
                    Intent i=new Intent(LoginActivity.this, Mainscreen.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginActivity.this, validate + "", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void goToRegister(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }

    public void goToMain(View view) {

        Intent i=new Intent(LoginActivity.this,Mainscreen.class);
        startActivity(i);
    }
}
