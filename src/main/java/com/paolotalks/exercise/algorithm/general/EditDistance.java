package com.paolotalks.exercise.algorithm.general;

import java.util.stream.IntStream;

import static com.paolotalks.utils.MathUtils.min;

/**
 * Exercise:
 *   Given two strings find the edit distance between the two.
 *   The edit distance is <i>minimum</i> the number of operations
 *   that you need to perform on the string so they become the same.
 *   An operation can be:
 *     - Substitution: Replace one character with another one
 *     - Insertion: Insert a new character at the i-th position
 *     - Deletion: Delete the character at the i-th position

 *   E. g.
 *     (cat, cut) -> 1 [only one substitution from a -> u]
 *     (cut, cute) -> 1 [only one insertion/deletion: e at the end]
 */
public class EditDistance {

    /**
     * Check for the edit distance between two strings and return the number
     *   of operations.
     * The matching is CASE INSENSITIVE (i.e. A == a).
     * @param first the first string
     * @param second the second string
     * @return the edit distance in number of operations
     *
     * Pre-condition: the input is never null.
     * Pre-condition: strings can contain any type of characters
     */
    public int editDistance(String first, String second) {
        first = first.toLowerCase();
        second = second.toLowerCase();
        int n = first.length();
        int m = second.length();
        int[][] T = new int[n+1][m+1];
        IntStream.range(0, n+1).forEach(s -> T[s][0] = s);
        IntStream.range(0, m+1).forEach(s -> T[0][s] = s);
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <=m; j++){
                if (first.charAt(i-1) != second.charAt(j-1)){
                    T[i][j] = 1 + min(T[i-1][j-1], T[i][j-1], T[i-1][j]);
                } else {
                    T[i][j] = T[i-1][j-1];

                }
            }
        }
        return T[n][m];
    }

}
