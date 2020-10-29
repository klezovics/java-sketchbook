package com.klezovich.demo.matchers;

import org.junit.jupiter.api.Test;

import static com.klezovich.demo.matchers.IsBiggerThanThousand.biggerThanThousand;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IsBiggerThanThousandTest {

    @Test
    public void testThrowsExceptionForNan() {
        assertThrows(ClassCastException.class, () -> {
            assertThat("x", is(biggerThanThousand()));
        });
    }

    @Test
    public void testPassForBiggerThanThousand() {
        assertThat(9999, is(biggerThanThousand()));
    }

    @Test
    public void testFailForLessThanThousand() {
        assertThat(1, not(is(biggerThanThousand())));
    }
}