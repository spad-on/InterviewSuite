package com.paolotalks.exercise.ds;

import java.util.List;

/**
 * Represent a tree node in a binary tree.
 * 1) The subclass implementing this should go to
 *    the "impl" package and be called:
 *    "TrieNodeImpl"
 *
 * 2) The CONSTRUCTOR should take 1 argument:
 *  - data: the data associated with this node
 *    any other field should be default initialised.
 */
public interface ITrieNode {

    /**
     * Return the data associated with this node
     * @return the data associated with this node
     */
    char getData();

    /**
     * Return whether the current node is the end
     * of a valid word
     * @return true if the current node is the end
     * of a valid word, false otherwise
     */
    boolean isWord();

    /**
     * Set whether the current node mark the end of
     * a valid word
     * @param word true if the current node is a
     *             valid word, false otherwise
     */
    void setWord(boolean word);

    /**
     * Add a child to this node for the specified char.
     * @param data the char associated with the new child node
     * @return the node associated with the data
     */
    ITrieNode addChild(char data);

    /**
     * Return the child associated with the char,
     * null if no child is associated with it.
     * @param data the data associated with the child
     * @return the child for the current data
     */
    ITrieNode getChild(char data);

    /**
     * This should be overridden to return the node's data.
     * @return a string containing the node's data
     */
    @Override
    String toString();
}
