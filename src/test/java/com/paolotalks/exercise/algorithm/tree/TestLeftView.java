package com.paolotalks.exercise.algorithm.tree;

import com.paolotalks.datastructure.tree.BinaryNode;
import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(PartialTestRunner.class)
public class TestLeftView {

    /**
     *        --- 4---
     *      /         \
     *     2            12
     *      \         /   \
     *        5     14     6
     *       /             \
     *      8               9
     *                     /
     *                    10
     */
    @Test
    public void testExampleTree(){
        // build tree
        BinaryNode ten = new BinaryNode(10);
        BinaryNode nine = new BinaryNode(9);
        nine.setLeft(ten);
        BinaryNode six = new BinaryNode(6);
        six.setRight(nine);
        BinaryNode fourteen = new BinaryNode(14);
        BinaryNode twelve = new BinaryNode(12);
        twelve.setLeft(fourteen); twelve.setRight(six);
        BinaryNode eight = new BinaryNode(8);
        BinaryNode five = new BinaryNode(5);
        five.setLeft(eight);
        BinaryNode two = new BinaryNode(2);
        two.setRight(five);
        BinaryNode four = new BinaryNode(4);
        four.setLeft(two); four.setRight(twelve);

        BinaryNode root = four;

        List<Integer> leftView = new LeftView().visit(root);
        assertEquals(leftView, Arrays.asList(4, 2, 5, 8, 10));
    }


    /**
     *        1
     *         \
     *          8
     *           \
     *            9
     *             \
     *              42
     *              /
     *             51
     */
    @Test
    public void testRightChainThenLeft(){
        // build tree
        BinaryNode fiftyone = new BinaryNode(51);
        BinaryNode fourtytwo = new BinaryNode(42);
        fourtytwo.setLeft(fiftyone);
        BinaryNode nine = new BinaryNode(9);
        nine.setRight(fourtytwo);
        BinaryNode eight = new BinaryNode(8);
        eight.setRight(eight);
        BinaryNode one = new BinaryNode(1);
        eight.setRight(one);

        BinaryNode root = one;
        List<Integer> leftView = new LeftView().visit(root);
        assertEquals(leftView, Arrays.asList(1, 8, 9, 42, 51));
    }

    @Test
    public void testSingleNode(){
        // build tree
        BinaryNode root = new BinaryNode(100);
        List<Integer> leftView = new LeftView().visit(root);
        assertEquals(leftView, Arrays.asList(100));
    }

}
