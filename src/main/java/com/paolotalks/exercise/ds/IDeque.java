package com.paolotalks.exercise.ds;

public interface IDeque {

    void offerFirst(int i);
    void offerLast(int i);
    int pollFirst();
    int pollLast();
    int peekFirst();
    int peekLast();
    boolean isEmpty();
}
