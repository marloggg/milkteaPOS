package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class LoginPage extends AppCompatActivity {


    Button cashier, owner, logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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