package com.paolotalks.exercise.algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BaseTestSorter {

    protected Sorter sorter;

    @Test
    public void testSorting(){
        int[] array = {3, 7, 2, 7, 12, 473, 7, 23, 1, 1, 5, 8, 34};
        int[] expected = {1, 1, 2, 3, 5, 7, 7, 7, 8, 12, 23, 34, 473};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSingleElement(){
        int[] array = {30};
        int[] expected = {30};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testEmptyArray(){
        int[] array = {};
        int[] expected = {};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testReverseOrder(){
        int[] array = {23, 19, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 19, 23};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testAlreadySorted(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

}
