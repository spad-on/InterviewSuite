package com.paolotalks.exercise.algorithm.tree;

import com.paolotalks.datastructure.tree.BinaryNode;
import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(PartialTestRunner.class)
public class TestBinarySearchTree {

    @Test
    public void testBST(){
        // build BST
        BinarySearchTree tree = new BinarySearchTree();
        tree.addNode(8);
        tree.addNode(3);
        tree.addNode(1);
        tree.addNode(1);
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(4);
        tree.addNode(10);
        tree.addNode(14);
        tree.addNode(13);
        // TEST root
        BinaryNode root = tree.getRoot();
        assertNotNull(root);
        assertEquals(8, root.getData());
        // check 3 is on the left
        BinaryNode three = root.getLeft();
        assertNotNull(three);
        assertEquals(3, three.getData());
        // check 1 is left child of 3
        BinaryNode one = three.getLeft();
        assertNotNull(one);
        assertEquals(1, one.getData());
        // check == elements are on the right
        BinaryNode one2 = one.getLeft();
        assertNotNull(one2);
        assertEquals(1, one2.getData());
        // check > root
        BinaryNode ten = root.getRight();
        assertNotNull(ten);
        assertEquals(10, ten.getData());
        // check right of right works
        BinaryNode fourteen = ten.getRight();
        assertNotNull(fourteen);
        assertEquals(14, fourteen.getData());
        // check left of right works
        BinaryNode thirteen = fourteen.getLeft();
        assertNotNull(thirteen);
        assertEquals(13, thirteen.getData());
    }

}
