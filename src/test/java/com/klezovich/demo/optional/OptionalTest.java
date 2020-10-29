package com.klezovich.demo.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class OptionalTest {

    @Test
    public void testEmptyCreatesEmptyOptional() {
        Optional<String> opt = Optional.empty();
        assertFalse(opt.isPresent());
        assertTrue(opt.isEmpty());
    }

    @Test
    public void testOfCreatesPresentOptional() {
        var opt = Optional.of("mystr");
        assertTrue(opt.isPresent());
        assertEquals("mystr", opt.get());
    }

    @Test
    public void testOfNullableAcceptsNullObjects() {
        var opt = Optional.ofNullable(null);
        assertTrue(opt.isEmpty());

        opt = Optional.of("abc");
        assertTrue(opt.isPresent());
    }

    @Test
    public void testIfPresent() {
        var nameToken = "Arthur";
        var opt = Optional.of(nameToken);
        var name = new Name();
        opt.ifPresent(val -> name.setName(val));
        assertEquals(nameToken, name.getName());

        opt = Optional.empty();
        opt.ifPresent(val -> name.setName(val));
        assertEquals(nameToken, name.getName());
    }

    @Test
    public void testOrElse() {
        var optName = Optional.ofNullable(null);
        assertEquals("Arthur", optName.orElse("Arthur"));

        var optName1 = Optional.of("John");
        assertEquals("John", optName1.orElse("Arthur"));
    }

    @Test
    public void testOrElseGet() {
        var optName = Optional.ofNullable(null);
        assertEquals("SuppliedName", optName.orElseGet(NameSupplier::get));

        var optName1 = Optional.ofNullable("AK");
        assertEquals("AK", optName1.orElseGet(NameSupplier::get));
    }

    @Test
    public void testOrElseThrow() {
        var optName = Optional.ofNullable(null);
        assertThrows(IllegalArgumentException.class, () -> optName.orElseThrow(IllegalArgumentException::new) );

        var optName1 = Optional.ofNullable("AK");
        assertEquals( "AK", optName1.orElseThrow(IllegalArgumentException::new) );
    }

    @Test
    public void testOptionalWithFilter() {
        var opt = Optional.of(100);
        assertTrue(opt.filter( num -> num > 10).isPresent());
        assertFalse(opt.filter( num -> num > 200).isPresent());
    }

    static class NameSupplier {

        public static String get() {
            return "SuppliedName";
        }
    }

    static class Name {

        String name;

        void setName(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }
}
