package com.klezovich.demo.streams.icecream;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class IceCreamSalesDataCleaner {

    private final List<IceCreamSale> sales;

    public IceCreamSalesDataCleaner(List<IceCreamSale> sales) {
        this.sales = List.copyOf(sales);
    }

    public List<IceCreamSale> removeCheapIceCreams(int costMin) {
        return sales.stream()
            .filter( sale -> sale.getSalePriceCents() >= costMin)
            .collect(toList());
    }
}
