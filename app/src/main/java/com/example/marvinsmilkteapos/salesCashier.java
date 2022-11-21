package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class salesCashier extends AppCompatActivity {


    TextView tv_from, tv_to, tSales;
    Button btnProceed;
    RecyclerView rview1;

    Calendar calendar;
    DatePickerDialog.OnDateSetListener dateFrom, dateTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_cashier);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tv_from=findViewById(R.id.tv_from);
        tv_to=findViewById(R.id.tv_to);
        btnProceed=findViewById(R.id.btnProceed);
        tSales = findViewById(R.id.tSales);
        rview1 = findViewById(R.id.rview1);


        tv_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(salesCashier.this,dateFrom,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        calendar = Calendar.getInstance();

        dateFrom = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);
                String myFormat = "yyyy/MM/dd";
                SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.getDefault());
                tv_from.setText(dateFormat.format(calendar.getTime()));
                if (!tv_to.getText().equals("DATE TO:")){
                    showData();
                }
            }
        };
        dateTo = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);
                String myFormat = "yyyy/MM/dd";
                SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.getDefault());
                tv_to.setText(dateFormat.format(calendar.getTime()));
                if (!tv_from.getText().equals("DATE FROM:")){
                    showData();
                }
            }
        };
        tv_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(salesCashier.this,dateTo,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),productScreen.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void showData(){
        //Display data to recyclerview and total sales
        rview1.setHasFixedSize(true);
        rview1.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        List <QuantityModel> list = db.getAllQuantity(DefaultData.cashier,tv_from.getText().toString(),tv_to.getText().toString());
        QuantityAdapter adapter = new QuantityAdapter(list.toArray(new QuantityModel[list.size()]));
        rview1.setAdapter(adapter);
        float tp=0;
        for (QuantityModel data:list){
            tp = tp + data.getTotalAmount();
        }
        tSales.setText(""+"₱ "+tp);
    }
}