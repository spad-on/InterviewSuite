package com.paolotalks.utils;

public class Container<T> {
    private T element;

    public Container(T el){
        this.element = el;
    }

    public Container(){
        this(null);
    }

    public void set(T el){
        this.element = el;
    }

    public T get(){
        return element;
    }
}
