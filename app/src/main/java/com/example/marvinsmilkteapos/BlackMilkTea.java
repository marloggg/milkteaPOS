package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BlackMilkTea extends AppCompatActivity {

    TextView value1, value2, value3;
    int count,count2,count3 = 0;
    float totalPrice, price, price2, price3;
    String productName="Black Milk Tea";
    Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_milk_tea);

        value1 = (TextView) findViewById(R.id.value1);
        value2 = (TextView) findViewById(R.id.value2);
        value3 = (TextView) findViewById(R.id.value3);
        cart = (Button) findViewById(R.id.checkOutBlack);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add to cart
            }
        });

        setPrice();



    }

    public void setPrice(){
        price = count * 79;
        price2 = count2 * 89;
        price3 = count3 * 99;
        totalPrice = price+price2+price3;
    }
    public void increment(View v){
        count++;
        setPrice();
        value1.setText(""+count);
    }
    public void decrement (View v){
        if (count <= 0) count=0;
        else count--;
        setPrice();
        value1.setText(""+count);
    }
    public void incrementTwo(View v){
        count2++;
        setPrice();
        value2.setText(""+count2);
    }
    public void decrementTwo (View v){
        if (count2 <= 0) count2=0;
        else count2--;
        setPrice();
        value2.setText(""+count2);
    }
    public void incrementThree(View v){
        count3++;
        setPrice();
        value3.setText(""+count3);
    }
    public void decrementThree (View v){
        if (count3 <= 0) count3=0;
        else count3--;
        setPrice();
        value3.setText(""+count3);
    }
}