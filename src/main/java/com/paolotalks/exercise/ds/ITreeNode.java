package com.paolotalks.exercise.ds;

/**
 * Represent a tree node in a binary tree.
 * 1) The subclass implementing this should go to
 *    the "impl" package and be called:
 *    "TreeNodeImpl"
 *
 * 2) The CONSTRUCTOR should take 1 argument:
 *  - data: the data associated with this node
 */
public interface ITreeNode {

    /**
     * Return the left child of this tree node.
     * @return the left child of this tree node
     */
    ITreeNode getLeft();

    /**
     * Return the right child of this tree node.
     * @return the right child of this tree node
     */
    ITreeNode getRight();

    /**
     * Set the left child of this tree node.
     * @param left the left child of this tree node
     */
    void setLeft(ITreeNode left);

    /**
     * Set the right child of this tree node.
     * @param right the right child of this tree node
     */
    void setRight(ITreeNode right);

    /**
     * Return the data associated with this node
     * @return the data associated with this node
     */
    int getData();

    /**
     * This should be overridden to return the node's data.
     * @return a string containing the node's data
     */
    @Override
    String toString();
}
