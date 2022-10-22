package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilterer {
    private int number;

    public DivisibleByFilter(int number) {
        this.number = number;
    }

    public boolean accept(Integer number) {
        if (this.number == 0) return false;
        return number % this.number == 0;
    }
}

