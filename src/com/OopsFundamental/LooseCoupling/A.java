package com.OopsFundamental.LooseCoupling;

public class A implements DeliveryS{
    @Override
    public void delivery(int amount) {
        System.out.println("delivery done by a ");
    }
}
