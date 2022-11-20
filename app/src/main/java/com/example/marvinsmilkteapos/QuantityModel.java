package com.example.marvinsmilkteapos;

public class QuantityModel {

    int id;
    float totalAmount;
    String orderDate;
    String cashier;

    public QuantityModel(float totalAmount, String orderDate, String cashier) {
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.cashier = cashier;
    }

    public QuantityModel(){
    }

    public QuantityModel(int id, float totalAmount, String orderDate, String cashier){
        this.id = id;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.cashier = cashier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){

        return id;
    }

    public float getTotalAmount(){
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount){
        this.totalAmount = totalAmount;
    }

    public String getOrderDate(){
        return orderDate;
    }

    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    public String getCashier(){
        return cashier;
    }

    public void setCashier(String cashier){
        this.cashier = cashier;
    }
}