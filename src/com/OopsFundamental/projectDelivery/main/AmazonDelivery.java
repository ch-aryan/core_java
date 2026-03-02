package com.OopsFundamental.projectDelivery.main;

import com.OopsFundamental.projectDelivery.services.DeliveryService;
import com.OopsFundamental.projectDelivery.services.FedEx;

public class AmazonDelivery {
private DeliveryService service;

    public void setService(DeliveryService service) {
        this.service = service;
    }

    public Boolean DeliverProuduct(Integer amount){
        System.out.println("product delivered successfully");
//        FedEx obj = new FedEx();//compositon.
//        return obj.deliveryType(amount);//tight coupling

        return service.deliveryType(amount);


    }
}
