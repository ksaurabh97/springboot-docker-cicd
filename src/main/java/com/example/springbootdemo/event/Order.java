package com.example.springbootdemo.event;


public class Order {

    public final String id;


    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
