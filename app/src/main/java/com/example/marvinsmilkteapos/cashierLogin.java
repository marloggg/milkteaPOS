package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cashierLogin extends AppCompatActivity {

    private Button logIn;
    private EditText cashierUsername, cashierPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        cashierUsername = findViewById(R.id.cashierUsername);
        cashierPassword = findViewById(R.id.cashierPassword);
        logIn = findViewById(R.id.loginSubmitCashier);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String un =cashierUsername.getText().toString();
            String pwd = cashierPassword.getText().toString();

            Intent intent = null;

            if (un.equals("cashier1")&&pwd.equals("cashier1")){
                intent = new Intent(cashierLogin.this, productScreen.class);
                DefaultData.cashier="cashier1";
                Toast.makeText(cashierLogin.this,"Login Successfully",Toast.LENGTH_LONG).show();
                finish();
            }
            else if (un.equals("cashier2")&&pwd.equals("cashier2")){
                intent = new Intent(cashierLogin.this, productScreen.class);
                DefaultData.cashier="cashier2";
                Toast.makeText(cashierLogin.this,"Login Successfully",Toast.LENGTH_LONG).show();
                finish();
            }
            else if (un.equals("cashier3")&&pwd.equals("cashier3")){
                intent = new Intent(cashierLogin.this, productScreen.class);
                DefaultData.cashier="cashier3";
                Toast.makeText(cashierLogin.this,"Login Successfully",Toast.LENGTH_LONG).show();
                finish();
            }

            if (intent != null) startActivity(intent);
            else if (intent == null) Toast.makeText(cashierLogin.this,"Please enter valid credentials",Toast.LENGTH_SHORT).show();


            }
        });
    }
}