package com.klezovich.demo.mock;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    DeliveryService deliveryService;

    @Mock
    PaymentService paymentService;

    @InjectMocks
    OrderService orderService;

    @Test
    public void testMocksCreated() {
        assertNotNull(deliveryService);
        assertNotNull(paymentService);
        assertNotNull(orderService);
    }

    @Test
    public void testOrderPlacedWhenPaymentAndDeliveryAccepted() {
        System.out.println(deliveryService.toString());

        String order = "012345";
        when(deliveryService.acceptOrder(order))
            .thenReturn(true);
        when(paymentService.processPayment(order))
            .thenReturn(true);

        assertTrue(orderService.placeOrder(order));
    }
}