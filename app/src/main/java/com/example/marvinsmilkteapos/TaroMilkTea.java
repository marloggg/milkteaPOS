package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TaroMilkTea extends AppCompatActivity {

    TextView value31, value32, value33;
    int count31, count32, count33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taro_milk_tea);

        value31 = (TextView) findViewById(R.id.value31);
        value32 = (TextView) findViewById(R.id.value32);
        value33 = (TextView) findViewById(R.id.value33);
    }
    public void increment31(View v){
        count31++;
        value31.setText(""+count31);
    }
    public void decrement31 (View v){
        if (count31 <= 0) count31=0;
        else count31--;

        value31.setText(""+count31);
    }
    public void increment32(View v){
        count32++;
        value32.setText(""+count32);
    }
    public void decrement32 (View v){
        if (count32 <= 0) count32=0;
        else count32--;

        value32.setText(""+count32);
    }
    public void increment33(View v){
        count33++;
        value33.setText(""+count33);
    }
    public void decrement33 (View v){
        if (count33 <= 0) count33=0;
        else count33--;

        value33.setText(""+count33);
    }
}