package com.paolotalks.exercise.algorithm.general;

import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(PartialTestRunner.class)
public class TestEditDistance {

    @Test
    public void testExample(){
        String first = "pale";
        String second = "bale";

        EditDistance ed = new EditDistance();
        assertEquals(1, ed.editDistance(first, second));
    }

    @Test
    public void testLastCharacter(){
        String first = "ciao";
        String second = "ciae";

        EditDistance ed = new EditDistance();
        assertEquals(1, ed.editDistance(first, second));
    }

    @Test
    public void testLastRemove(){
        String first = "ciao";
        String second = "cia";

        EditDistance ed = new EditDistance();
        assertEquals(1, ed.editDistance(first, second));
    }

    @Test
    public void testEmpty(){
        String first = "";
        String second = "the cat is on the table";

        EditDistance ed = new EditDistance();
        assertEquals(second.length(), ed.editDistance(first, second));
    }

    @Test
    public void testMixedRemovalAndReplacements(){
        String first = "shine bright";
        String second ="shining right";

        EditDistance ed = new EditDistance();
        assertEquals(4, ed.editDistance(first, second));
    }


    @Test
    public void testSentences(){
        String first = "the quick brown fox jumps over the green land";
        String second ="the lazy brown pix rolls over the greenwich lad";

        EditDistance ed = new EditDistance();
        assertEquals(16, ed.editDistance(first, second));
    }


    @Test
    public void testCaseInsensitive(){
        String first = "PAR";
        String second ="park";

        EditDistance ed = new EditDistance();
        assertEquals(1, ed.editDistance(first, second));
    }


    @Test
    public void testEquals(){
        String first = "doggo";
        String second ="Doggo";

        EditDistance ed = new EditDistance();
        assertEquals(0, ed.editDistance(first, second));
    }

}
