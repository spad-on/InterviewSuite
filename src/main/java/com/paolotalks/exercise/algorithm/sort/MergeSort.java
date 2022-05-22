package com.paolotalks.exercise.algorithm.sort;

/**
 * Exercise:
 *  Implement the merge sort algorithm.
 */
public class MergeSort implements Sorter {

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(int[] array, int start, int end){
        if (end - start <= 1) return;
        int mid = (end + start) >>> 1;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private void merge(int[] array, int start, int mid, int end){
        int s = start, e = mid;
        int[] X = new int[end - start];
        int i = 0;
        while (s < mid && e < end){
            if (array[s] <= array[e]){
                X[i++] = array[s++];
            } else {
                X[i++] = array[e++];
            }
        }
        while (s < mid){
            X[i++] = array[s++];
        }
        while (e < end){
            X[i++] = array[e++];
        }
        System.arraycopy(X, 0, array, start, X.length);
    }
}
