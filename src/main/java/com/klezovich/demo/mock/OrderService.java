package com.klezovich.demo.mock;

public class OrderService {

    private final DeliveryService deliveryService;
    private final PaymentService paymentService;

    public OrderService(DeliveryService deliveryService, PaymentService paymentService) {
        this.deliveryService = deliveryService;
        this.paymentService = paymentService;
    }

    public boolean placeOrder( String order ) {
        boolean deliveryAccepted = deliveryService.acceptOrder(order);
        boolean paymentAccepted = paymentService.processPayment(order);

        if( !paymentAccepted || !deliveryAccepted ) {
            return false;
        }

        return true;
    }
}
