package com.paolotalks.datastructure.tree;

public interface Tree<E extends Node> {

    void addNode(int data);
    boolean contains(int data);
    E getRoot();
}
