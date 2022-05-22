package com.paolotalks.exercise.algorithm.tree;

import com.paolotalks.datastructure.tree.BinaryNode;
import com.paolotalks.datastructure.tree.Tree;
import com.paolotalks.exception.TestCaseNotImplementedException;

/**
 * Exercise:
 *  Implement a Binary search tree.
 *  A Search tree is a tree for which all children in the LEFT subtree are <= than the node;
 *  all children in the RIGHT subtree are > node.
 *  This is, of course, a recursive definition.
 *
 *  Note: This should not be a balanced tree.
 */
public class BinarySearchTree implements Tree<BinaryNode> {

    private BinaryNode root;

    public BinarySearchTree(){
    }

    @Override
    public void addNode(int data) {
        if (root == null){
            root = new BinaryNode(data);
        } else {
            insertInto(root, data);
        }
    }

    private void insertInto(BinaryNode node, int data){
        if (data <= node.getData()){
            if (node.getLeft() == null){
                node.setLeft(new BinaryNode(data));
            } else {
                insertInto(node.getLeft(), data);
            }
        } else {
            if (node.getRight() == null){
                node.setRight(new BinaryNode(data));
            } else {
                insertInto(node.getRight(), data);
            }
        }
    }

    @Override
    public boolean contains(int data) {
        BinaryNode node = root;
        while (node != null){
            if (node.getData() == data) return true;
            else if (node.getData() < data){
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return false;
    }

    @Override
    public BinaryNode getRoot() {
        return root;
    }

}
