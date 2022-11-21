package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CartList extends AppCompatActivity {

    RecyclerView rview;
    TextView totalPrice;
    Button pay, back;
    float tPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        rview =findViewById(R.id.rview);
        totalPrice = findViewById(R.id.totalPrice);
        pay= findViewById(R.id.btnPay);
        back = findViewById(R.id.back);

        QuantityDetailsAdapter adapter = new QuantityDetailsAdapter(DefaultData.cartList.toArray(new QuantityDetailsModel[DefaultData.cartList.size()]));
        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(this));
        rview.setAdapter(adapter);

        for (QuantityDetailsModel item:DefaultData.cartList){
            tPrice += item.getTotal();
        }
        totalPrice.setText(""+"₱ "+tPrice);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tPrice!=0) {

                    Date d = Calendar.getInstance().getTime();
                    java.text.SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
                    String dateNow = dateFormat.format(d);


                    DatabaseHelper db = new DatabaseHelper(getApplicationContext());

                    db.addQuantity(new QuantityModel(tPrice, dateNow, DefaultData.cashier));
                    db.addQuantityDetails(DefaultData.cartList);

                    DefaultData.cartList.clear();

                    startActivity(new Intent(getApplicationContext(), Successfully.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Empty Cart", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartList.this, productScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}