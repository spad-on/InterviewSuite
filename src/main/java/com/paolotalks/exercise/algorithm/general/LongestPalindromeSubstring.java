package com.paolotalks.exercise.algorithm.general;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Exercise:
 *   Given two strings find the largest common subsequence.
 *   A common subsequence is a non consecutive, ordered set of characters
 *   common to both strings.
 * Optional: Retrieve the longest common subsequence
 *   E. g.
 *      ____
 *     cabbage
 *
 *   output:
 *    - Length: 4
 *    - subsequence (optional): "abba"
 *
 */
public class LongestPalindromeSubstring {

    public static class Solution {
        private final int length;
        private final String substring;

        Solution(int length, String substring){
            this.length = length;
            this.substring = substring;
        }

        Solution(int length){
            this(length, null);
        }

        public int getLength() {
            return length;
        }

        public Optional<String> getSubstring() {
            return Optional.ofNullable(substring);
        }
    }

    /**
     * Check for the size of the longest substring that is palindrome.
     * The matching is CASE INSENSITIVE (i.e. A == a).
     * Optional: Retrieve the actual substring and add it to the solution.
     * @param input the input string
     * @return the {@link Solution} class containing the result.
     *
     * Pre-condition: the input is never null.
     * Pre-condition: strings can contain any type of characters
     */
    public Solution find(String input) {
        input = input.toLowerCase();
        int n = input.length();
        boolean[][] T = new boolean[n+1][n+1];
        IntStream.range(0, n+1).forEach(s -> T[s][s] = true);
        int max = 0;
        int start = 0, end = 0;
        for (int k = 1; k <= n; k++){
            for (int i = 0; i < n - k; i++){
                int j = i + k;
                if (input.charAt(i) == input.charAt(j)) {
                    T[i][j] = k == 1 || T[i + 1][j - 1];
                } else {
                    T[i][j] = false;
                }
                if (T[i][j] && k > max) {
                    max = k + 1;
                    start = i; end = j + 1;
                }
            }
        }
        return new Solution(max, input.substring(start, end));
    }

}
