package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer implements GenericListFilterer{

    private GenericListFilterer filter;

    public ListFilterer (GenericListFilterer filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> filtered = new ArrayList<>();

        for (Integer number : list)
            if (filter.accept(number))
                filtered.add(number);

        return filtered;
    }

    @Override
    public boolean accept(Integer number) {
        return false;
    }
}
