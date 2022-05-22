package com.paolotalks.exercise.algorithm.general;

import com.paolotalks.utils.MathUtils;

import java.util.Optional;

/**
 * Exercise:
 *   Given two strings find the largest common subsequence.
 *   A common subsequence is a non consecutive, ordered set of characters
 *   common to both strings.
 * Optional: Retrieve the longest common subsequence
 *   E. g.
 *     ______ ___ _____   _
 *     The house is on fire
 *     _________  __ __ _    _
 *     The hose has gone loose
 *
 *   output:
 *    - Length: 15
 *    - subsequence (optional): "The hose s on e"
 *
 */
public class LongestCommonSubsequence {

    public static class Solution {
        private int length;
        private String subsequence;

        Solution(int length, String subsequence){
            this.length = length;
            this.subsequence = subsequence;
        }

        Solution(int length){ this(length, null);}

        public int getLength() {
            return length;
        }

        public Optional<String> getSubsequence() {
            return Optional.ofNullable(subsequence);
        }

        void setSubsequence(String subsequence) {
            this.subsequence = subsequence;
        }
    }

    /**
     * Check for the longest common subsequence and return the solution.
     * The matching is CASE SENSITIVE (i.e. A != a).
     * Optional: Retrieve the common subsequence and add it to the solution.
     * @param first the first string
     * @param second the second string
     * @return the a {@link Solution} class containing the result.
     *
     * Pre-condition: the input is never null.
     * Pre-condition: strings can contain any type of characters
     */
    public Solution find(String first, String second) {
        int n = first.length();
        int m = second.length();

        int[][] T = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (first.charAt(i-1) == second.charAt(j-1)){
                    T[i][j] = T[i-1][j-1] + 1;
                } else {
                    T[i][j] = MathUtils.max(T[i][j-1], T[i-1][j]);
                }
            }
        }
        String sol = findSolution(T, first, second);
        return new Solution(T[n][m], sol);
    }

    private String findSolution(int[][] T, String first, String second){
        int ni = first.length(), nj = second.length();
        StringBuilder sb = new StringBuilder();
        while (ni > 0 && nj > 0) {
            if (first.charAt(ni-1) == second.charAt(nj-1)){
                sb.append(first.charAt(ni-1));
                ni--; nj--;
            } else if (T[ni][nj] == T[ni-1][nj]){
                ni--;
            } else {
                nj--;
            }
        }
        return sb.reverse().toString();
    }
}
