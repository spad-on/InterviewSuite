package com.paolotalks.exercise.algorithm.tree;

import com.paolotalks.datastructure.tree.BinaryNode;
import com.paolotalks.datastructure.tree.TreeNode;
import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(PartialTestRunner.class)
public class TestDepth {

    /**
     *                   3
     *          1                 5
     *     8        0        6         2
     *                              7     4
     */
    @Test
    public void testBinaryTree(){
        // build tree
        BinaryNode four = new BinaryNode(4);
        BinaryNode seven = new BinaryNode(7);
        BinaryNode two = new BinaryNode(2);
        two.setLeft(seven);two.setRight(four);;
        BinaryNode six = new BinaryNode(6);
        BinaryNode five = new BinaryNode(5);
        five.setLeft(six); five.setRight(two);
        BinaryNode zero = new BinaryNode(0);
        BinaryNode eight = new BinaryNode(8);
        BinaryNode one = new BinaryNode(1);
        one.setRight(zero); one.setLeft(eight);
        BinaryNode three = new BinaryNode(3);
        three.setRight(five); three.setLeft(one);

        int depth = new Depth().visit(three);
        assertEquals(3, depth);

    }

    /**
     *                     3
     *          1                        5
     *     8            0          6            2
     *  11  12  13                           7     4
     * 9
     */
    @Test
    public void testGeneralTree(){
        // build tree
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        two.addChild(seven);two.addChild(four);;
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        five.addChild(six); five.addChild(two);
        TreeNode zero = new TreeNode(0);
        TreeNode nine = new TreeNode(9);
        TreeNode eleven = new TreeNode(11);
        eleven.addChild(nine);
        TreeNode twelve = new TreeNode(12);
        TreeNode thirteen = new TreeNode(13);
        TreeNode eight = new TreeNode(8);
        eight.addChild(eleven);eight.addChild(twelve);eight.addChild(thirteen);
        TreeNode one = new TreeNode(1);
        one.addChild(zero); one.addChild(eight);
        TreeNode three = new TreeNode(3);
        three.addChild(five); three.addChild(one);

        int depth = new Depth().visit(three);
        assertEquals(4, depth);
    }

}
