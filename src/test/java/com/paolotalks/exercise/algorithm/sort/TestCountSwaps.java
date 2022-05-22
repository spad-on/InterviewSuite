package com.paolotalks.exercise.algorithm.sort;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PartialTestRunner.class)
public class TestCountSwaps {

    @Test
    public void testSimple(){
        int[] a = {3, 1, 4, 2};
        CountSwaps swaps = new CountSwaps();
        Assert.assertEquals(3, swaps.count(a));
    }

    @Test
    public void testSimple2(){
        int[] a = {1, 3, 5, 2};
        CountSwaps swaps = new CountSwaps();
        Assert.assertEquals(2, swaps.count(a));
    }

    @Test
    public void testSimple3(){
        int[] a = {1, 3, 5, 2, 4};
        CountSwaps swaps = new CountSwaps();
        Assert.assertEquals(3, swaps.count(a));
    }

    @Test
    public void testComplicated(){
        int[] a = {3, 4, 1, 6, 3, 7, 8};

        CountSwaps swaps = new CountSwaps();
        Assert.assertEquals(4, swaps.count(a));
    }

    @Test
    public void testSingleElement(){
        int[] a = {3};

        CountSwaps swaps = new CountSwaps();
        Assert.assertEquals(0, swaps.count(a));
    }

    @Test
    public void testSorted(){
        int[] a = {1, 2, 3, 4, 5, 6, 8, 20};

        CountSwaps swaps = new CountSwaps();
        Assert.assertEquals(0, swaps.count(a));
    }

    @Test
    public void testReversed(){
        int[] a = {5, 4, 3, 2, 1};

        CountSwaps swaps = new CountSwaps();
        Assert.assertEquals(10, swaps.count(a));
    }
}
