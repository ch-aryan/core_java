package com.OopsFundamental.projectDelivery.services;

public class FirstFlight implements DeliveryService {

    public Boolean deliveryType(Integer am){
        System.out.println("delivery by first flight");
        return true;
    }
}
