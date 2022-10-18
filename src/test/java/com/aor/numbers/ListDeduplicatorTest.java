package com.aor.numbers;

import jdk.internal.org.jline.terminal.impl.LineDisciplineTerminal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    private List<Integer> list;
    private List<Integer> expected;

    @BeforeEach void helper() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }
    @Test
    public void deduplicate() {
        class StubListSorter implements GenericListSorter {
            @Override public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1,2,4,5);
            }
        }
        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void bug_8726() {
        list = Arrays.asList(1,2,4,2);

        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1,2,2,4);
            }
        }
        StubListSorter sorter = new StubListSorter();
        ListDeduplicator dedup = new ListDeduplicator(sorter);
        List<Integer> ret = dedup.deduplicate(list);

        Assertions.assertEquals(Arrays.asList(1,2,4),ret);
    }
}
