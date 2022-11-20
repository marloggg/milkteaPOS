package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminLogin extends AppCompatActivity {

    private Button submit;
    private EditText ownerUsername, ownerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        submit = (Button) findViewById(R.id.adminSubmitOwner);
        ownerUsername = (EditText) findViewById(R.id.ownerUsername);
        ownerPassword = (EditText) findViewById(R.id.ownerPassword);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String un =ownerUsername.getText().toString();
                String pwd = ownerPassword.getText().toString();

                Intent intent = null;

                if (un.equals("owner")&&pwd.equals("owner")){
                    intent = new Intent(adminLogin.this, adminPage.class);
                    DefaultData.cashier="owner";
                    Toast.makeText(adminLogin.this,"Login Successfully",Toast.LENGTH_LONG).show();
                }

                if (intent != null) startActivity(intent);
                else if (intent == null) Toast.makeText(adminLogin.this,"Please Enter Valid Credentials",Toast.LENGTH_SHORT).show();
            }
        });
    }

}