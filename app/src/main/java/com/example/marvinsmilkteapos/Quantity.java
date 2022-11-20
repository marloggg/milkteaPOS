package com.example.marvinsmilkteapos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quantity extends AppCompatActivity {


    ImageView dis, dis1;
    TextView value, total, name;
    Button cart;
    int count = 0;
    float price, totalPrice;
    String productSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dis = findViewById(R.id.imageView);
        dis1 = findViewById(R.id.imageView2);
        value = findViewById(R.id.value);
        total = findViewById(R.id.total);
        name = findViewById(R.id.name);
        cart = findViewById(R.id.cart);

        Intent intent = getIntent();
        productSize = intent.getStringExtra("productSize");
        if(productSize.equals("smallblack")){
            dis.setImageResource(R.drawable.smallsize);
            dis1.setImageResource(R.drawable.black_milk_tea);
            price=79;
            total.setText(""+"₱ "+price*count);
            name.setText("BlackMilkTea @ 79");
        }
        if(productSize.equals("mediumblack")){
            dis.setImageResource(R.drawable.mediumsize);
            dis1.setImageResource(R.drawable.black_milk_tea);
            price=89;
            total.setText(""+"₱ "+price*count);
            name.setText("BlackMilkTea @ 89");
        }
        if(productSize.equals("largeblack")){
            dis.setImageResource(R.drawable.largesize);
            dis1.setImageResource(R.drawable.black_milk_tea);
            price=99;
            total.setText(""+"₱ "+price*count);
            name.setText("BlackMilkTea @ 99");
        }
        if(productSize.equals("smalltaro")){
            dis.setImageResource(R.drawable.smalltaro);
            dis1.setImageResource(R.drawable.taro_milk_tea);
            price=79;
            total.setText(""+"₱ "+price*count);
            name.setText("TaroMilkTea @ 79");
        }
        if(productSize.equals("mediumtaro")){
            dis.setImageResource(R.drawable.mediumtaro);
            dis1.setImageResource(R.drawable.taro_milk_tea);
            price=89;
            total.setText(""+"₱ "+price*count);
            name.setText("TaroMilkTea @ 89");
        }
        if(productSize.equals("largetaro")){
            dis.setImageResource(R.drawable.largetaro);
            dis1.setImageResource(R.drawable.taro_milk_tea);
            price=99;
            total.setText(""+"₱ "+price*count);
            name.setText("TaroMilkTea @ 99");
        }
        if(productSize.equals("smalltiger")){
            dis.setImageResource(R.drawable.smalltiger);
            dis1.setImageResource(R.drawable.tiger_milktea);
            price=79;
            total.setText(""+"₱ "+price*count);
            name.setText("TigerMilkTea @ 79");
        }
        if(productSize.equals("mediumtiger")){
            dis.setImageResource(R.drawable.mediumtiger);
            dis1.setImageResource(R.drawable.tiger_milktea);
            price=89;
            total.setText(""+"₱ "+price*count);
            name.setText("TigerMilkTea @ 89");
        }
        if(productSize.equals("largetiger")){
            dis.setImageResource(R.drawable.largetiger);
            dis1.setImageResource(R.drawable.tiger_milktea);
            price=99;
            total.setText(""+"₱ "+price*count);
            name.setText("TigerMilkTea @99");
        }
        if(productSize.equals("smallstraw")){
            dis.setImageResource(R.drawable.smallstraw);
            dis1.setImageResource(R.drawable.strawberry);
            price=79;
            total.setText(""+"₱ "+price*count);
            name.setText("StrawberryMilkTea @ 79");
        }
        if(productSize.equals("mediumstraw")){
            dis.setImageResource(R.drawable.mediumstraw);
            dis1.setImageResource(R.drawable.strawberry);
            price=89;
            total.setText(""+"₱ "+price*count);
            name.setText("StrawberryMilkTea @ 89");
        }
        if(productSize.equals("largestraw")){
            dis.setImageResource(R.drawable.largestraw);
            dis1.setImageResource(R.drawable.strawberry);
            price=99;
            total.setText(""+"₱ "+price*count);
            name.setText("StrawberryMilkTea @ 99");
        }
        cart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int val = Integer.parseInt(value.getText().toString());

                if (val != 0) {
                    DefaultData.cartList.add(new QuantityDetailsModel(productSize, price, count, totalPrice));
                    Intent i = new Intent(Quantity.this, productScreen.class);
                    startActivity(i);
                    Toast.makeText(Quantity.this, "Added to Cart ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Quantity.this, "Please Select", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }




    public void decrement (View v){
        if(count <=0) count=0;
        else count--;
        value.setText(""+count);
        totalPrice = price*count;
        total.setText(""+"₱ "+totalPrice);

    }
    public void increment (View v){
        count++;
        value.setText(""+count);
        totalPrice = price*count;
        total.setText(""+"₱ "+price*count);
    }
}
