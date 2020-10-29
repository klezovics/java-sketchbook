package com.klezovich.demo.datafactory;

public class InvoiceItemMother {

    public static InvoiceItem valid() {
        return new InvoiceItem.Builder()
            .id(1L)
            .description("This is for XXX transaction")
            .build();
    }
}
