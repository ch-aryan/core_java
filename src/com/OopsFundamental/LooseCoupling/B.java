package com.OopsFundamental.LooseCoupling;

public class B implements DeliveryS{
    @Override
    public void delivery(int amount) {
        System.out.println("delivery done by b"+ amount);
    }
}
