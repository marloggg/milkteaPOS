package com.example.marvinsmilkteapos;

public class Order {
    int _id;
    String product;
    double price, quantity;
    float total;

    public Order(int _id, String product, double price, double quantity, float total) {
        this._id = _id;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}