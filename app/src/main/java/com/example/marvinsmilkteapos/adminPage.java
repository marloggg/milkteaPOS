package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class adminPage extends AppCompatActivity {

    TextView tv_from, tv_to, tSales;
    ImageView logout;
    AlertDialog.Builder builder;
    Spinner spinner;
    Button back;
    Calendar calendar;
    DatePickerDialog.OnDateSetListener dateFrom, dateTo;
    RecyclerView rview1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        tSales = findViewById(R.id.tSales);
        rview1 = findViewById(R.id.rview1);
        back = findViewById(R.id.back);
        tv_from=findViewById(R.id.tv_from);
        tv_to=findViewById(R.id.tv_to);
        builder = new AlertDialog.Builder(this);

        String[] users = { "All", "cashier1", "cashier2", "cashier3"};


        spinner = findViewById(R.id.spinner);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,users);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        tv_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(adminPage.this,dateFrom,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
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
                getDataFromDB();
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
                getDataFromDB();
            }
        };
        tv_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(adminPage.this,dateTo,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(adminPage.this, LoginPage.class);
                startActivity(intent);
                finish();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getDataFromDB();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void getDataFromDB(){
        String cashier2="", dateFrom2="",dateTo2="";
        float totalSales=0;
        cashier2 = spinner.getSelectedItem().toString();
        if (!tv_from.getText().toString().equalsIgnoreCase("Date from:"))dateFrom2=tv_from.getText().toString();
        if (!tv_to.getText().toString().equalsIgnoreCase("Date to:"))dateTo2=tv_to.getText().toString();

        //Toast.makeText(getApplicationContext(), cashier2 +"--"+dateFrom2+"--"+dateTo2,Toast.LENGTH_LONG).show();

        if (!cashier2.equalsIgnoreCase("")&& !dateFrom2.equalsIgnoreCase("")&& !dateTo2.equalsIgnoreCase("")){
            DatabaseHelper db = new DatabaseHelper(getApplicationContext());
            List<QuantityModel> cartList = db.getAllQuantity(cashier2,dateFrom2, dateTo2);
            QuantityModel [] model = cartList.toArray(new QuantityModel[cartList.size()]);
            QuantityAdapter adapter = new QuantityAdapter(model);
            rview1.setHasFixedSize(true);
            rview1.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rview1.setAdapter(adapter);
            for (QuantityModel data: cartList){
                totalSales += data.getTotalAmount();
            }
            tSales.setText("₱ "+totalSales);
        }
    }
}