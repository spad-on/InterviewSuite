package com.paolotalks.exercise.algorithm.sort;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PartialTestRunner.class)
public class TestQuickSelect {

    @Test
    public void testFirstElement(){
        int[] a = {3, 4, 1, 6, 3, 7, 8};
        QuickSelect select = new QuickSelect();

        Assert.assertEquals(1, select.findKth(a, 1));
        Assert.assertEquals(6, select.findKth(a, 5));
    }


    @Test
    public void testNElement(){
        int[] a = {3, 4, 1, 6, 3, 7, 8};
        QuickSelect select = new QuickSelect();

        Assert.assertEquals(6, select.findKth(a, 5));
    }


    @Test
    public void testSingleElement(){
        int[] a = {3};
        QuickSelect select = new QuickSelect();

        Assert.assertEquals(3, select.findKth(a, 1));
    }

    @Test
    public void testLastElement(){
        int[] a = {3, 4, 1, 6, 3, 7, 8, 12};
        QuickSelect select = new QuickSelect();

        Assert.assertEquals(12, select.findKth(a, 8));
    }
}
