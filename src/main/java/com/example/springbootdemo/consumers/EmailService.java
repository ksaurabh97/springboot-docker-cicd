package com.example.springbootdemo.consumers;

import com.example.springbootdemo.event.Order;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @EventListener
    public void sendEmail(Order order){

        System.out.println("Sending EMail for Order ... "+ order.getId());
    }

}
