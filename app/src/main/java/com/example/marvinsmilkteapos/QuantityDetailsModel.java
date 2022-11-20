package com.example.marvinsmilkteapos;

public class QuantityDetailsModel {
    int orderId;
    String productSize;
    float unitPrice;
    int quantity;
    float total;

    public QuantityDetailsModel(){
    }

    public QuantityDetailsModel(int orderId, String productSize, float unitPrice, int quantity, float total){
        this.orderId = orderId;
        this.productSize = productSize;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.total = total;
    }

    public QuantityDetailsModel(String productSize, float unitPrice, int quantity, float total){
        this.productSize = productSize;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrderId(){
        return orderId;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public String getProductSize(){
        return productSize;
    }

    public void setProductSize(String productSize){
        this.productSize= productSize;
    }

    public float getUnitPrice(){
        return  unitPrice;
    }

    public void setUnitPrice(float unitPrice){
        this.unitPrice = unitPrice;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public float getTotal(){
        return total;
    }
    public void setTotal(float total){
        this.total = total;
    }

}
