package com.paolotalks.exercise.algorithm.sort;

import java.util.Arrays;

/**
 * Exercise:
 *  Implement the merge sort algorithm.
 */
public class CountSwaps {

    public int count(int[] array) {
        int[] tmp = Arrays.copyOf(array, array.length);
        return mergeSort(tmp, 0, tmp.length);
    }

    private int mergeSort(int[] array, int start, int end){
        if (end - start <= 1) return 0;
        int mid = (end + start) >>> 1;
        int first = mergeSort(array, start, mid);
        int second = mergeSort(array, mid, end);
        int current = merge(array, start, mid, end);
        return first + second + current;
    }

    private int merge(int[] array, int start, int mid, int end){
        int s = start, e = mid;
        int[] X = new int[end - start];
        int i = 0;
        int count = 0;
        while (s < mid && e < end){
            if (array[s] <= array[e]){
                X[i++] = array[s++];
            } else {
                X[i++] = array[e++];
                count += (mid - s);
            }
        }
        while (s < mid){
            X[i++] = array[s++];
        }
        while (e < end){
            X[i++] = array[e++];
        }
        System.arraycopy(X, 0, array, start, X.length);
        return count;
    }
}
