package com.klezovich.demo.streams.icecream;

import java.util.Objects;

public class IceCreamSale {

    private final IceCreamFlavour iceCreamFlavour;
    private final int salePriceCents;

    public IceCreamSale(IceCreamFlavour iceCreamFlavour, int salePriceCents) {
        this.iceCreamFlavour = iceCreamFlavour;
        this.salePriceCents = salePriceCents;
    }

    public IceCreamFlavour getIceCreamFlavour() {
        return iceCreamFlavour;
    }

    public int getSalePriceCents() {
        return salePriceCents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IceCreamSale)) {
            return false;
        }
        IceCreamSale that = (IceCreamSale) o;
        return getSalePriceCents() == that.getSalePriceCents() &&
            getIceCreamFlavour() == that.getIceCreamFlavour();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIceCreamFlavour(), getSalePriceCents());
    }
}
