package com.aor.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveFilterTest {
    @Test
    public void positive() {
        PositiveFilter filter = new PositiveFilter();
        assertTrue(filter.accept(1));
    }

    @Test
    public void negative() {
        PositiveFilter filter = new PositiveFilter();
        assertFalse(filter.accept(-1));
    }

    @Test
    public void zero() {
        PositiveFilter filter = new PositiveFilter();
        assertFalse(filter.accept(0));
    }
}