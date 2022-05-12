package com.paolotalks.exercise.algorithm.general;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(PartialTestRunner.class)
public class TestLongestPalindromeSubstring {

    @Test
    public void testWithPadding(){
        String input = "rabbah";

        LongestPalindromeSubstring.Solution sol = new LongestPalindromeSubstring().find(input);
        assertEquals(4, sol.getLength());
        sol.getSubstring().ifPresent(s -> assertEquals("abba", s));
    }

    @Test
    public void testWhole(){
        String input = "itopinonavevanonipoti";

        LongestPalindromeSubstring.Solution sol = new LongestPalindromeSubstring().find(input);
        assertEquals(input.length(), sol.getLength());
        sol.getSubstring().ifPresent(s -> assertEquals(input, s));
    }

    @Test
    public void testEmpty(){
        String input = "";

        LongestPalindromeSubstring.Solution sol = new LongestPalindromeSubstring().find(input);
        assertEquals(0, sol.getLength());
        sol.getSubstring().ifPresent(s -> assertEquals("", s));
    }


    @Test
    public void testExample(){
        String input = "cabbage";

        LongestPalindromeSubstring.Solution sol = new LongestPalindromeSubstring().find(input);
        assertEquals(4, sol.getLength());
        sol.getSubstring().ifPresent(s -> assertEquals("abba", s));
    }

}
