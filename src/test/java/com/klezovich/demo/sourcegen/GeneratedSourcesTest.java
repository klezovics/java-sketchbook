package com.klezovich.demo.sourcegen;

import com.example.types.ShippingAddress;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GeneratedSourcesTest {

    @Test
    public void testCanUseGeneratedSourcesJaxb() {
        var factory = new ObjectFactory();
        assertNotNull(factory.createProduct());
        assertNotNull(factory.createCreateProductRequest());
    }

    @Test
    public void testCanUseGeneratedSourcesJson() {
        var addr = new ShippingAddress();
        assertNotNull(addr);
        addr.setCountryName("USA");
        assertEquals("USA", addr.getCountryName());
    }
}
