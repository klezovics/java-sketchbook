package com.klezovich.demo.sourcegen;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GeneratedSourcesTest {

    @Test
    public void testCanUseGeneratedSources() {
        var factory = new ObjectFactory();
        assertNotNull(factory.createProduct());
        assertNotNull(factory.createCreateProductRequest());
    }
}
