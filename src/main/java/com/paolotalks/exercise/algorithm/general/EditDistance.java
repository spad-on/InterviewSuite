package com.paolotalks.exercise.algorithm.general;

import com.paolotalks.exception.TestCaseNotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

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
        // TODO implement
        throw new TestCaseNotImplementedException();
    }

}
