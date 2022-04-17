package com.paolotalks.algorithm.tree;

import com.paolotalks.datastructure.tree.BinaryNode;
import com.paolotalks.datastructure.tree.TreeNode;
import com.paolotalks.exercise.algorithm.tree.LowestCommonAncestor;
import com.paolotalks.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(PartialTestRunner.class)
public class TestLowestCommonAncestor {

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

        BinaryNode root = three;
        BinaryNode result = null;
        result = new LowestCommonAncestor().visit(four, seven, root);
        assertEquals(two, result); // 2
        result = new LowestCommonAncestor().visit(zero, six, root);
        assertEquals(three, result); // 3
        result = new LowestCommonAncestor().visit(four, six, root);
        assertEquals(five, result); // 5
        result = new LowestCommonAncestor().visit(seven, four, root);
        assertEquals(two, result); // 2
        result = new LowestCommonAncestor().visit(seven, two, root);
        assertEquals(two, result); // 2
        result = new LowestCommonAncestor().visit(zero, zero, root);
        assertEquals(zero, result); // 0
        result = new LowestCommonAncestor().visit(seven, three, root);
        assertEquals(three, result); // 3

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

        TreeNode root = three;
        TreeNode result = null;
        result = new LowestCommonAncestor().visit(four, seven, root);
        assertEquals(two, result); // 2
        result = new LowestCommonAncestor().visit(zero, six, root);
        assertEquals(three, result); // 3
        result = new LowestCommonAncestor().visit(four, six, root);
        assertEquals(five, result); // 5
        result = new LowestCommonAncestor().visit(seven, four, root);
        assertEquals(two, result); // 2
        result = new LowestCommonAncestor().visit(seven, two, root);
        assertEquals(two, result); // 2
        result = new LowestCommonAncestor().visit(zero, zero, root);
        assertEquals(zero, result); // 0
        result = new LowestCommonAncestor().visit(seven, three, root);
        assertEquals(three, result); // 3
        result = new LowestCommonAncestor().visit(nine, thirteen, root);
        assertEquals(eight, result); // 8
        result = new LowestCommonAncestor().visit(eleven, thirteen, root);
        assertEquals(eight, result); // 8
        result = new LowestCommonAncestor().visit(twelve, zero, root);
        assertEquals(one, result); // 1
    }

}
