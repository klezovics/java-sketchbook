package com.klezovich.demo.datafactory;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceValidatorTest {

    private InvoiceValidator validator = new InvoiceValidator();

    @Test
    public void testValidInvoiceValidated() {
        assertTrue(validator.isValid(InvoiceMother.valid()));
    }

    @Test
    public void testInvoiceWithNoIdNotValidated() {
        assertFalse(validator.isValid(InvoiceMother.invalid()));
    }

    @Test
    public void testInvoiceWithBadAddressNotValidated() {
        var invoice = InvoiceMother.valid();
        invoice.setAddress(new Address("Ba<"));
        assertFalse(validator.isValid(invoice));
    }

    @Test
    public void testInvoiceWithNoAddressNotValidated() {
        var invoice = InvoiceMother.invalid();
        invoice.setId(1L);
        assertFalse(validator.isValid(invoice));
    }
}