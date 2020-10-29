package com.klezovich.demo.validation;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.validation.Validation;
import javax.validation.Validator;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputTest {

    private final Validator validator = getValidator();
    private Input in;

    @BeforeEach
    public void setupInput() {
        this.in = new Input();
    }

    @Test
    public void testGoodInputValidated() {
        in = new Input(5, "1.1.1.1");
        assertTrue(validator.validate(in).isEmpty());
    }

    @Test
    public void testBadInputNotValidated() {
        in = new Input(50, "1.1.1.1");
        assertFalse(validator.validate(in).isEmpty());
    }

    @Test
    public void testBooleanValueValidation() {
        in = new Input();
        in.setValid(false);
        fail(in);
        in.setValid(true);
        pass(in);
    }

    @Test
    public void testEmailValidation() {
        in = new Input();
        in.setEmail("abc");
        fail(in);
        in.setEmail("klezovich@gmail.com");
        pass(in);
    }

    @Test
    public void testCustomValidator() {
        in = new Input();
        in.setMyInts(List.of(10,10));
        pass(in);
        in.setMyInts(List.of(20));
        fail(in);
    }

    private void pass(Input in) {
        assertTrue(validator.validate(in).isEmpty());
    }

    private void fail(Input in) {
        assertFalse(validator.validate(in).isEmpty());
    }

    private Validator getValidator() {
        return Validation.buildDefaultValidatorFactory()
            .getValidator();
    }
}