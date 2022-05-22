package com.paolotalks.exercise.algorithm.sort;

import java.util.Arrays;

/**
 * Exercise:
 *  Count the minimum number of swaps that you need to do to sort the array.
 *  E.g.
 *     in: [5, 1, 4, 6, 3]
 *    out: 5
 *    ------
 *    0: [5, 1, 4, 6, 3]
 *    1: [1, 5, 4, 6, 3] (5, 1)
 *    2: [1, 5, 4, 3, 6] (6, 3)
 *    3: [1, 5, 3, 4, 6] (4, 3)
 *    4: [1, 3, 5, 4, 6] (5, 3)
 *    5: [1, 3, 4, 5, 6] (5, 4) Done.
 *    ------
 *
 * Pre-Conditions: 'array' is not null
 *
 * Try to come up with an algorithm having time complexity O(n log n)
 *
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
