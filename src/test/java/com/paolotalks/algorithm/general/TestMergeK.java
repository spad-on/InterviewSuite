package com.paolotalks.algorithm.general;

import com.paolotalks.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(PartialTestRunner.class)
public class TestMergeK {

    @Test
    public void testEmpty(){

        List<Integer> result = new MergeK().merge(List.of());
        assertEquals(result, List.of());
    }

    @Test
    public void testTwoLists(){
        List<Integer> first = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> second = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> result = new MergeK().merge(List.of(first, second));
        assertEquals(result, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void testTwoListsDifferentLengths(){
        List<Integer> first = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> second = Arrays.asList(2, 4, 6, 8);

        List<Integer> result = new MergeK().merge(List.of(first, second));
        assertEquals(result, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void testListsWithDuplicates(){
        List<Integer> first =  Arrays.asList(1, 1, 2, 5, 7, 12, 12, 34, 75, 900, 900, 901);
        List<Integer> second = Arrays.asList(2, 2, 4, 8, 12, 13);
        List<Integer> third =  Arrays.asList(1, 33, 33, 73, 75, 101);
        List<Integer> fourth =  Arrays.asList(1, 5);

        List<Integer> expected = Stream.of(first, second, third, fourth)
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> result = new MergeK().merge(List.of(first, second));
        assertEquals(result, expected);
    }

    @Test
    public void testOneIsEmpty(){
        List<Integer> first =  Arrays.asList(1, 1, 2, 5, 7, 12, 12, 34, 75, 900, 900, 901);
        List<Integer> second = Arrays.asList(2, 2, 4, 8, 12, 13);
        List<Integer> third =  Arrays.asList(1, 33, 33, 73, 75, 101);
        List<Integer> fourth = Collections.emptyList();
        List<Integer> fifth =  Arrays.asList(1, 33, 34, 75, 101);

        List<Integer> expected = Stream.of(first, second, third, fourth, fifth)
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> result = new MergeK().merge(List.of(first, second));
        assertEquals(result, expected);
    }

}
