package com.OopsFundamental.LooseCoupling;

public class Main {
    public static void main(String[] args) {
        ProductsBuy obj = new ProductsBuy(new A());

        obj.orderPlaced(100);

        obj.setDeliveryS(new B());
        obj.orderPlaced(1000);
    }
}
