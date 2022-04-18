package com.paolotalks.exercise.algorithm.sort;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(PartialTestRunner.class)
public class TestQuickSort extends BaseTestSorter {

    @Before
    public void setUp(){
        sorter = new QuickSort();
    }
}
