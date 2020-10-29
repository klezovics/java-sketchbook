package com.klezovich.demo.datafactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceMother {

    public static Invoice valid() {
        return new Invoice.Builder()
            .id(1L)
            .address(AddressMother.valid())
            .invoiceItems(getValidInvoiceItemList())
            .build();
    }

    public static Invoice invalid() {
        return new Invoice.Builder()
            .build();
    }

    private static List<InvoiceItem> getValidInvoiceItemList() {
        var invoiceItem1 = InvoiceItemMother.valid();
        var invoiceItem2 = InvoiceItemMother.valid();
        invoiceItem2.setId(2L);
        return Arrays.asList(invoiceItem1,invoiceItem2);
    }
}
