package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class productScreen extends AppCompatActivity {

    ImageView smallblack, mediumblack, largeblack,smalltaro, mediumtaro, largetaro,smalltiger, mediumtiger, largetiger,smallstraw, mediumstraw, largestraw, buttonAddToCart;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_screen);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        buttonAddToCart = findViewById(R.id.buttonAddToCart);
        smallblack = findViewById(R.id.smallblack);
        mediumblack = findViewById(R.id.mediumblack);
        largeblack = findViewById(R.id.largeblack);
        smalltaro = findViewById(R.id.smalltaro);
        mediumtaro = findViewById(R.id.mediumtaro);
        largetaro = findViewById(R.id.largetaro);
        smalltiger = findViewById(R.id.smalltiger);
        mediumtiger = findViewById(R.id.mediumtiger);
        largetiger = findViewById(R.id.largetiger);
        smallstraw = findViewById(R.id.smallstraw);
        mediumstraw = findViewById(R.id.mediumstraw);
        largestraw = findViewById(R.id.largestraw);
        button = findViewById(R.id.button);



        smallblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(productScreen.this, Quantity.class);
            intent.putExtra("productSize", "smallblack");
            startActivity(intent);
            }
        });
        mediumblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "mediumblack");
                startActivity(intent);
            }
        });
        largeblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "largeblack");
                startActivity(intent);
            }
        });
        smalltaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "smalltaro");
                startActivity(intent);
            }
        });
        mediumtaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "mediumtaro");
                startActivity(intent);
            }
        });
        largetaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "largetaro");
                startActivity(intent);
            }
        });
        smalltiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "smalltiger");
                startActivity(intent);
            }
        });
        mediumtiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "mediumtiger");
                startActivity(intent);
            }
        });
        largetiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "largetiger");
                startActivity(intent);
            }
        });
        smallstraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "smallstraw");
                startActivity(intent);
            }
        });
        mediumstraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "mediumstraw");
                startActivity(intent);
            }
        });
        largestraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(productScreen.this, Quantity.class);
                intent.putExtra("productSize", "largestraw");
                startActivity(intent);
            }
        });
        buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(productScreen.this, CartList.class);
                i.putExtra("Cart", "cart");
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(productScreen.this, salesCashier.class);
                //   i.putExtra("Info", "info");
                startActivity(i);
            }
        });






    }
}