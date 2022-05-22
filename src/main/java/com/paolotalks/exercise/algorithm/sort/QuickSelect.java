package com.paolotalks.exercise.algorithm.sort;

import java.util.Random;

/**
 * Exercise:
 *  Implement the quick sort algorithm.
 */
public class QuickSelect {

    public int findKth(int[] array, int k) {
        return quickSelect(array, 0, array.length -1, k-1);
    }

    private int quickSelect(int[] a, int start, int end, int k){
        if (start >= end) return a[start];
        int mid = partition(a, start, end);
        if (mid == k) return a[mid];
        if (mid > k)
            return quickSelect(a, start, mid -1, k);
        else
            return quickSelect(a, mid + 1, end, k);
    }

    private int partition(int[] a, int start, int end){
        int pivot = start + new Random().nextInt(end - start + 1);
        int x = a[pivot];
        swap(a, end, pivot);
        int current = start;
        for (int i = start; i < end; i++){
            if (a[i] <= x){
                swap(a, current++, i);
            }
        }
        swap(a, current, end);
        return current;
    }

    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
