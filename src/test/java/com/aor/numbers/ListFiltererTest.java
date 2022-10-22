package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void filterPositive() {
        List<Integer> list = Arrays.asList(-2, -1, 1, 3, 5);
        List<Integer> expected = java.util.Arrays.asList(1, 3, 5);

        GenericListFilterer condition = new PositiveFilter();
        ListFilterer filter = new ListFilterer(condition);
        List<Integer> result = filter.filter(list);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void filterDivisible() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = java.util.Arrays.asList(2, 4, 6, 8, 10);

        GenericListFilterer condition = new DivisibleByFilter(2);
        ListFilterer filter = new ListFilterer(condition);
        List<Integer> result = filter.filter(list);

        Assertions.assertEquals(expected, result);
    }
}