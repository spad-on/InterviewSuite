package com.paolotalks.algorithm.general;

import com.paolotalks.exception.TestCaseNotImplementedException;

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
        throw new TestCaseNotImplementedException();
    }
}
