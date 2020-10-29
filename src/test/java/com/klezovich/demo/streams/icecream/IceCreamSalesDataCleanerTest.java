package com.klezovich.demo.streams.icecream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.klezovich.demo.streams.icecream.IceCreamFlavour.CHOCOLATE;
import static com.klezovich.demo.streams.icecream.IceCreamFlavour.VANILLA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class IceCreamSalesDataCleanerTest {

    @Test
    public void testRemoveCheapIceCreams() {
        var sales = List.of(
            new IceCreamSale(VANILLA, 400),
            new IceCreamSale(VANILLA, 400),
            new IceCreamSale(VANILLA, 300),
            new IceCreamSale(CHOCOLATE, 200),
            new IceCreamSale(CHOCOLATE, 500)
        );
        var dataCleaner = new IceCreamSalesDataCleaner(sales);
        assertThat(
            dataCleaner.removeCheapIceCreams(500),
            contains(new IceCreamSale(CHOCOLATE, 500))
        );
    }
}