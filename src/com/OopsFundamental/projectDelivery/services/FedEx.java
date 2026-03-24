package com.OopsFundamental.projectDelivery.services;

public class FedEx implements DeliveryService{

    public Boolean deliveryType(Integer am) {
        System.out.println("hello from fedex");
        return true;
    }
}
