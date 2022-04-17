package com.paolotalks.exercise.ds;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Represent a tree node in a n-ary tree.
 * 1) The subclass implementing this should go to
 *    the "impl" package and be called:
 *    "NTreeNodeImpl"
 *
 * 2) The CONSTRUCTOR should take 1 argument:
 *  - data: the data associated with this node
 */
public interface INTreeNode {

    /**
     * Add a child to this {@link INTreeNode}
     * @param node the node to add
     * @throws IllegalArgumentException if node is null
     */
    void addChild(INTreeNode node);
    /**
     * Return a collection of all the children of this {@link INTreeNode}
     * @return all the children of this {@link INTreeNode}
     */
    Collection<INTreeNode> getChildren();
    /**
     * Return a stream of all the children of this {@link INTreeNode}
     * @return a stream of all the children of this {@link INTreeNode}
     */
    Stream<INTreeNode> children();


    /**
     * Return the data associated to this node
     * @return the data associated to this node
     */
    int getData();

    /**
     * toString() method should be re-defined to
     * print the data associated with the node
     */
    @Override
    String toString();
}
