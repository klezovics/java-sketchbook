package com.klezovich.demo.streams.icecream;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.klezovich.demo.streams.icecream.IceCreamFlavour.NONE;
import static java.util.stream.Collectors.toSet;

public class IceCreamSalesAnalyzer {

    private final List<IceCreamSale> sales;

    public IceCreamSalesAnalyzer(List<IceCreamSale> sales) {
        this.sales = List.copyOf(sales);
    }

    public List<IceCreamSale> getSales() {
        return sales;
    }

    public int getTotalRevenue() {
        return sales.stream()
            .map(IceCreamSale::getSalePriceCents)
            .reduce(0, Integer::sum);
    }

    public int getSmallestSale() {
        return sales.stream()
            .map(IceCreamSale::getSalePriceCents)
            .min(Integer::compare)
            .orElse(0);
    }

    public double getAverageSalePrice() {
        return sales.stream()
            .map(IceCreamSale::getSalePriceCents)
            .mapToDouble(Double::valueOf)
            .average()
            .orElse(0.0);
    }

    public IceCreamFlavour getMostSoldFlavour() {
        return sales.stream()
            .map(IceCreamSale::getIceCreamFlavour)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .orElseGet( () -> new AbstractMap.SimpleEntry<IceCreamFlavour, Long>(NONE, (long) 0))
            .getKey();
    }

    public Set<IceCreamFlavour> getSoldFlavourSet() {
        return sales.stream()
            .map(IceCreamSale::getIceCreamFlavour)
            .collect(toSet());
    }
}
