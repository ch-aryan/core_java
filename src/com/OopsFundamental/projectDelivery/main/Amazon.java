package com.OopsFundamental.projectDelivery.main;

import com.OopsFundamental.projectDelivery.services.FedEx;
import com.OopsFundamental.projectDelivery.services.FirstFlight;

public class Amazon {
    public static void main(String[] args) {

    AmazonDelivery ad = new AmazonDelivery();
ad.setService(new FedEx());// either we can do this means set like this or

        FirstFlight ff = new FirstFlight();
        ad.setService(ff);// or we can do like this any thing is okay.

    Boolean status = ad.DeliverProuduct(111);
        System.out.println(status);

    }
}
