package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Strawberry extends AppCompatActivity {

    TextView value21, value22, value23;
    int count21, count22, count23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strawberry);

        value21 = (TextView) findViewById(R.id.value21);
        value22 = (TextView) findViewById(R.id.value22);
        value23 = (TextView) findViewById(R.id.value23);
    }
    public void increment21(View v){
        count21++;
        value21.setText(""+count21);
    }
    public void decrement21 (View v){
        if (count21 <= 0) count21=0;
        else count21--;

        value21.setText(""+count21);
    }
    public void increment22(View v){
        count22++;
        value22.setText(""+count22);
    }
    public void decrement22 (View v){
        if (count22 <= 0) count22=0;
        else count22--;

        value22.setText(""+count22);
    }
    public void increment23(View v){
        count23++;
        value23.setText(""+count23);
    }
    public void decrement23 (View v){
        if (count23 <= 0) count23=0;
        else count23--;

        value23.setText(""+count23);
    }
}