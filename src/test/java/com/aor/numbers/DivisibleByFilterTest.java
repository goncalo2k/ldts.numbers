package com.aor.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DivisibleByFilterTest {
    @Test
    public void test() {
        DivisibleByFilter filter = new DivisibleByFilter(2);

        assertTrue(filter.accept(2));
        assertTrue(filter.accept(-6));
        assertTrue(filter.accept(0));

        assertFalse(filter.accept(1));
        assertFalse(filter.accept(-3));
        assertFalse(filter.accept(5));
    }

    @Test
    public void test_with_zero() {
        DivisibleByFilter filter = new DivisibleByFilter(0);

        assertFalse(filter.accept(2));
        assertFalse(filter.accept(-6));
        assertFalse(filter.accept(0));
        assertFalse(filter.accept(1));
        assertFalse(filter.accept(-3));
        assertFalse(filter.accept(5));
    }
}
