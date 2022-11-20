package com.example.marvinsmilkteapos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "MarvinPOSDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE tblQuantity(id INTEGER PRIMARY KEY AUTOINCREMENT, totalAmount REAL, orderDate TEXT, cashier TEXT)";
        sqLiteDatabase.execSQL(query);
        String query2 = "CREATE TABLE tblQuantityDetails(orderId INTEGER, productSize TEXT, unitPrice REAL, quantity INTEGER, total REAL)";
        sqLiteDatabase.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tblQuantity");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tblQuantityDetails");
        onCreate(sqLiteDatabase);
    }
    //add quantity
    public void addQuantity(QuantityModel quantityModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("totalAmount", quantityModel.getTotalAmount());
        values.put("orderDate", quantityModel.getOrderDate());
        values.put("cashier", quantityModel.getCashier());
        db.insert("tblQuantity", null, values);
        db.close();
    }

    //add quantity details
    public void addQuantityDetails(List<QuantityDetailsModel> list) {
        SQLiteDatabase db = this.getWritableDatabase();
        int orderId = getLastId();
        ContentValues values = new ContentValues();
        for (QuantityDetailsModel data:list){
            values = new ContentValues();
            values.put("orderId",orderId);
            values.put("productSize",data.getProductSize());
            values.put("unitPrice",data.getUnitPrice());
            values.put("quantity", data.getQuantity());
            values.put("total", data.getTotal());
            db.insert("tblQuantityDetails", null, values);
        }
        db.close();
    }

    //get all quantity
    public List<QuantityModel> getAllQuantity() {
        List<QuantityModel> quantityList = new ArrayList<QuantityModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tblQuantity ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuantityModel order = new QuantityModel();
                order.setId(cursor.getInt(0));
                order.setTotalAmount(cursor.getFloat(1));
                order.setOrderDate(cursor.getString(2));
                order.setCashier(cursor.getString(3));
                quantityList.add(order);
            } while (cursor.moveToNext());
        }

        // return contact list
        return quantityList;
    }

    // get all quantity details
    public List<QuantityDetailsModel> getAllQuantityDetails() {
        List<QuantityDetailsModel> quantityDetailsList = new ArrayList<QuantityDetailsModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tblQuantityDetails ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuantityDetailsModel order = new QuantityDetailsModel();
                order.setOrderId(cursor.getInt(0));
                order.setProductSize(cursor.getString(1));
                order.setUnitPrice(cursor.getFloat(2));
                order.setQuantity(cursor.getInt(3));
                order.setTotal(cursor.getFloat(3));
                quantityDetailsList.add(order);
            } while (cursor.moveToNext());
        }

        // return contact list
        return quantityDetailsList;
    }

    //get all quantity by condition (cashier, dateFrom, dateTo)
    public List<QuantityModel> getAllQuantity(String cashier, String dateFrom, String dateTo) {
        List<QuantityModel> quantityList = new ArrayList<QuantityModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tblQuantity WHERE cashier='"+cashier+"' AND orderDate>='"+dateFrom+"' AND orderDate <='"+dateTo+"' ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuantityModel order = new QuantityModel();
                order.setId(cursor.getInt(0));
                order.setTotalAmount(cursor.getFloat(1));
                order.setOrderDate(cursor.getString(2));
                order.setCashier(cursor.getString(3));
                quantityList.add(order);
            } while (cursor.moveToNext());
        }

        // return contact list
        return quantityList;
    }

    // get all quantity details by condition - orderId
    public List<QuantityDetailsModel> getAllQuantityDetails(int orderId) {
        List<QuantityDetailsModel> quantityDetailsList = new ArrayList<QuantityDetailsModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM tblQuantityDetails WHERE id='"+orderId+"' ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuantityDetailsModel order = new QuantityDetailsModel();
                order.setOrderId(cursor.getInt(0));
                order.setProductSize(cursor.getString(1));
                order.setUnitPrice(cursor.getFloat(2));
                order.setQuantity(cursor.getInt(3));
                order.setTotal(cursor.getFloat(3));
                quantityDetailsList.add(order);
            } while (cursor.moveToNext());
        }

        // return contact list
        return quantityDetailsList;
    }

    //get lastId
    public int getLastId(){
        String selectQuery = "SELECT  * FROM tblQuantity ORDER BY id DESC";
        int lastId=0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            lastId = cursor.getInt(0);
        }
        return lastId;
    }
}
