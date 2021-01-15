package com.example.myfoodapp.Models;

public class OrderModels {

    int orderimage;
    String orderprice, soldItemName, orderNumber;


    public OrderModels() {

        this.orderimage = orderimage;
        this.orderprice = orderprice;
        this.soldItemName = soldItemName;
        this.orderNumber = orderNumber;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }



    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
