package com.example.springbootdemo.consumers;

import com.example.springbootdemo.event.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SMSService {

    @EventListener
    public void sendSMS(Order order){

        System.out.println("Sending SMS for Order ... "+ order.getId());
    }
}
