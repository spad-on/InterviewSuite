package com.paolotalks.algorithm.sort;

import com.paolotalks.exercise.algorithm.sort.MergeSort;
import com.paolotalks.util.PartialTestRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(PartialTestRunner.class)
public class TestMergeSort extends BaseTestSorter {

    @Before
    public void setUp(){
        sorter = new MergeSort();
    }
}
