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
    Button pay;

    float tPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        rview =findViewById(R.id.rview);
        totalPrice = findViewById(R.id.totalPrice);
        pay= findViewById(R.id.btnPay);

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
                // prepare data
                //Quantity - tPrice, dateNow, DefaultData.cashier
                if (tPrice!=0) {

                    Date d = Calendar.getInstance().getTime();
                    java.text.SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
                    String dateNow = dateFormat.format(d);
                    //QuantityDetails - productName, quantity, unitPrice, totalPrice ---- DefaultData.cart

                    // connect to db
                    DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                    //insert data to db
                    db.addQuantity(new QuantityModel(tPrice, dateNow, DefaultData.cashier));
                    db.addQuantityDetails(DefaultData.cartList);
                    //reset cart
                    DefaultData.cartList.clear();
                    //call Paid activity
                    startActivity(new Intent(getApplicationContext(), Successfully.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Empty Cart", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}