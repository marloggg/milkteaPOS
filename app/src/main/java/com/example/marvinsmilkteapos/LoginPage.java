package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginPage extends AppCompatActivity {


    Button cashier, owner, logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        cashier = findViewById(R.id.cashierLogin);
        owner = findViewById(R.id.ownerLogin);

    }
     public void buttonCashierLogin(View V){
        Intent i = new Intent(getApplicationContext(),cashierLogin.class);
        startActivity(i);
     }
    public void buttonOwnerLogin(View V){
        Intent i = new Intent(getApplicationContext(),adminLogin.class);
        startActivity(i);
    }

}