package com.example.springbootdemo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void createOrder(String orderId){

        System.out.println("Order created: "+orderId);
        applicationEventPublisher.publishEvent(new Order(orderId));
    }
}
