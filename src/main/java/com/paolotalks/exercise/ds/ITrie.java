package com.paolotalks.exercise.ds;

/**
 * Represent a tree node in a binary tree.
 * 1) The subclass implementing this should go to
 *    the "impl" package and be called:
 *    "TrieImpl"
 *
 * 2) The CONSTRUCTOR should take no arguments.
 *
 * 3) The root of the trie should have '\0' as
 *    its data
 */
public interface ITrie {

    /**
     * Return the root of this trie.
     * This is used for testing to crawl the trie
     * and it will not exist in an actual Trie implementation
     * @return
     */
    ITrieNode getRoot();

    /**
     * Add a word to this trie
     * @param word the word to add
     */
    void addWord(String word);

}
