package com.OopsFundamental.LooseCoupling;

public class ProductsBuy {
    private DeliveryS deliveryS ;
    ProductsBuy(DeliveryS deliveryS){
        this.deliveryS = deliveryS;
    }

    public void setDeliveryS(DeliveryS deliveryS){
        this.deliveryS = deliveryS;
    }

    public void orderPlaced(int amount){
        deliveryS.delivery(amount);
    }
}
