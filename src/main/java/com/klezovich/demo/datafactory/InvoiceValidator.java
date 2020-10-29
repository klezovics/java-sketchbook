package com.klezovich.demo.datafactory;

import java.util.HashSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InvoiceValidator {

    public boolean isValid(Invoice invoice) {
        if( invoice == null ) {
            return false;
        }

        if( invoice.getId() == null ) {
            return false;
        }

        if( !validateAddress(invoice.getAddress()) ) {
            return false;
        }

        if( !validateInvoiceItems(invoice.getInvoiceItems()) ) {
            return false;
        }

        return true;
    }

    private boolean validateAddress(Address address) {

        if(address == null) {
            return false;
        }

        if( address.getAddress().length() < 5 ) {
            return false;
        }

        return true;
    }

    private boolean validateInvoiceItems(List<InvoiceItem> invoiceItems) {
        var idList = invoiceItems.stream()
            .map(InvoiceItem::getId)
            .collect(toList());

        var idSet = new HashSet<Long>(idList);
        return idList.size() == idSet.size();
    }
}
