package com.example.springbootdemo.controller;

import com.example.springbootdemo.event.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FIrstController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public String createOrder(@RequestParam String orderId) {

        orderService.createOrder(orderId);

        return "Order CReated succesfully";
    }

    @GetMapping("/display")
    public String display() {

        return "Hello Saurabh";
    }
}
