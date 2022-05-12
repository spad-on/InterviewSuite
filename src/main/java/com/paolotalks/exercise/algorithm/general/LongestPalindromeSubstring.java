package com.paolotalks.exercise.algorithm.general;

import com.paolotalks.exception.TestCaseNotImplementedException;

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
        // TODO implement
        throw new TestCaseNotImplementedException();
    }

}
