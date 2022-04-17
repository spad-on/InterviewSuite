package com.paolotalks.algorithm.general;

import com.paolotalks.exercise.algorithm.general.LongestCommonSubsequence;
import com.paolotalks.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(PartialTestRunner.class)
public class TestLongestCommonSubsequence {

    @Test
    public void testExample(){
        String first = "The hose has gone loose";
        String second = "The house is on fire";

        LongestCommonSubsequence.Solution sol = new LongestCommonSubsequence().find(first, second);
        assertEquals(15, sol.getLength());
        sol.getSubsequence().ifPresent(s -> assertEquals("The hose s on e", s));
    }

    @Test
    public void testEmpty(){
        String first = "";
        String second = "the cat is on the table";

        LongestCommonSubsequence.Solution sol = new LongestCommonSubsequence().find(first, second);
        assertEquals(0, sol.getLength());
        sol.getSubsequence().ifPresent(s -> assertEquals("", s));
    }

    @Test
    public void testNoSpaceStrings(){
        String first = "shinebrightlikeadiamond";
        String second = "shiningthroughlineofwoods";

        LongestCommonSubsequence.Solution sol = new LongestCommonSubsequence().find(first, second);
        assertEquals(12, sol.getLength());
        sol.getSubsequence().ifPresent(s -> assertEquals("shinrghlieod", s));
    }

    @Test
    public void testStringsWithSpaces(){
        String first = "the longest common subsequence";
        String second = "the problem of the longest common subsequence";

        LongestCommonSubsequence.Solution sol = new LongestCommonSubsequence().find(first, second);
        assertEquals(30, sol.getLength());
        sol.getSubsequence().ifPresent(s -> assertEquals("the longest common subsequence", s));
    }

    @Test
    public void testStringsWithSpacesAndPunctuation(){
        String first = "can you imagine if my grandmother had wheels?";
        String second = "what if the grandson hated her?";

        LongestCommonSubsequence.Solution sol = new LongestCommonSubsequence().find(first, second);
        assertEquals(20, sol.getLength());
        sol.getSubsequence().ifPresent(s -> assertEquals("a if  grando had he?", s));
    }

}
