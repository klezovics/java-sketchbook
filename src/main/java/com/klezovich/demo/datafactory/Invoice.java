package com.klezovich.demo.datafactory;

import java.util.List;

public class Invoice {

    private Long id;
    private Address address;
    private List<InvoiceItem> invoiceItems;

    public Invoice(Long id, Address address, List<InvoiceItem> invoiceItems) {
        this.id = id;
        this.address = address;
        this.invoiceItems = invoiceItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    private Invoice(Builder builder) {
        id = builder.id;
        address = builder.address;
        invoiceItems = builder.invoiceItems;
    }

    public static final class Builder {

        private Long id;
        private Address address;
        private List<InvoiceItem> invoiceItems;

        public Builder() {}

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder address(Address val) {
            address = val;
            return this;
        }

        public Builder invoiceItems(List<InvoiceItem> val) {
            invoiceItems = val;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }
}
