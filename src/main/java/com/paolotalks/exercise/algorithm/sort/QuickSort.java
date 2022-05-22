package com.paolotalks.exercise.algorithm.sort;

import java.util.Random;

/**
 * Exercise:
 *  Implement the quick sort algorithm.
 */
public class QuickSort implements Sorter {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length -1);
    }

    private void quickSort(int[] a, int start, int end){
        if (start >= end) return;
        int mid = partition(a, start, end);
        quickSort(a, start, mid -1);
        quickSort(a, mid + 1, end);
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
