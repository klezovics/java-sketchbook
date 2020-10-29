package com.klezovich.demo.streams.icecream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.klezovich.demo.streams.icecream.IceCreamFlavour.CHOCOLATE;
import static com.klezovich.demo.streams.icecream.IceCreamFlavour.VANILLA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IceCreamSalesAnalyzerTest {

    @Test
    public void testSalesListCannotBeModified() {
        var sales = new ArrayList();
        sales.add(new IceCreamSale(VANILLA, 200));
        var analyzer = new IceCreamSalesAnalyzer(sales);
        var analyzerSalesList = analyzer.getSales();
        assertThrows(
            UnsupportedOperationException.class,
            () -> analyzerSalesList.add(new IceCreamSale(VANILLA, 300))
        );
    }

    @Test
    public void testCalculateRevenueSingleIceCreamSale() {
        var sales = List.of(new IceCreamSale(VANILLA, 200));
        var analyzer = new IceCreamSalesAnalyzer(sales);
        assertThat(analyzer.getTotalRevenue(), is(200));
    }

    @Test
    public void testCalculateRevenueTwoIceCreamSale() {
        var sales = List.of(
            new IceCreamSale(VANILLA, 200),
            new IceCreamSale(CHOCOLATE, 300)
        );
        var analyzer = new IceCreamSalesAnalyzer(sales);
        assertThat(analyzer.getTotalRevenue(), is(500));
    }

    @Test
    public void testFindMinSalesPrice() {
        var sales = List.of(
            new IceCreamSale(VANILLA, 400),
            new IceCreamSale(CHOCOLATE, 200),
            new IceCreamSale(CHOCOLATE, 500)
        );
        var analyzer = new IceCreamSalesAnalyzer(sales);
        assertThat(analyzer.getSmallestSale(), is(200));
    }

    @Test
    public void testMostOftenSoldFlavour() {
        var sales = List.of(
            new IceCreamSale(VANILLA, 400),
            new IceCreamSale(VANILLA, 400),
            new IceCreamSale(VANILLA, 300),
            new IceCreamSale(CHOCOLATE, 200),
            new IceCreamSale(CHOCOLATE, 500)
        );
        var analyzer = new IceCreamSalesAnalyzer(sales);
        assertThat(analyzer.getMostSoldFlavour(), is(VANILLA));
    }

    @Test
    public void testGetFlavourSet() {
        var sales = List.of(
            new IceCreamSale(VANILLA, 400),
            new IceCreamSale(VANILLA, 400),
            new IceCreamSale(VANILLA, 300),
            new IceCreamSale(CHOCOLATE, 200),
            new IceCreamSale(CHOCOLATE, 500)
        );
        var analyzer = new IceCreamSalesAnalyzer(sales);
        assertThat(analyzer.getSoldFlavourSet(), containsInAnyOrder(VANILLA, CHOCOLATE));
    }

    @Test
    public void testGetAverageSalesPriceEmptyList() {
        var analyzer = new IceCreamSalesAnalyzer(List.of());
        assertThat(analyzer.getAverageSalePrice(),is(0.0));
    }

    @Test
    public void testGetAverageSalesPrice() {
        var sales = List.of(
            new IceCreamSale(VANILLA, 200),
            new IceCreamSale(VANILLA, 300),
            new IceCreamSale(VANILLA, 400)
        );
        var analyzer = new IceCreamSalesAnalyzer(sales);
        assertThat(analyzer.getAverageSalePrice(),closeTo(300.0,0.01));
    }
}