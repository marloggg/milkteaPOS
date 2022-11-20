package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TigerMilkTea extends AppCompatActivity {

    TextView value41, value42, value43;
    int count41, count42, count43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiger_milk_tea);

        value41 = (TextView) findViewById(R.id.value41);
        value42 = (TextView) findViewById(R.id.value42);
        value43 = (TextView) findViewById(R.id.value43);
    }

    public void increment41(View v){
        count41++;
        value41.setText(""+count41);
    }
    public void decrement41(View v){
        if (count41<=0) count41=0;
        else count41--;
        value41.setText(""+count41);
    }
    public void increment42(View v){
        count42++;
        value42.setText(""+count42);
    }
    public void decrement42(View v){
        if (count42<=0) count42=0;
        else count42--;
        value42.setText(""+count42);
    }
    public void increment43(View v){
        count43++;
        value43.setText(""+count43);
    }
    public void decrement43(View v){
        if (count43<=0) count43=0;
        else count43--;
        value43.setText(""+count43);
    }
}