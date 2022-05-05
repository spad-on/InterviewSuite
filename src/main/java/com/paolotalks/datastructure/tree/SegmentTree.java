package com.paolotalks.datastructure.tree;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class SegmentTree<E> {

    private class Node {
        private int v;

        Node(int v){
            this.v = v;
        }

        public Node getLeft(){
            int vl = v * 2 + 1;
            return new Node(vl);
        }

        public Node getRight(){
            int vr = v * 2 + 2;
            return new Node(vr);
        }

        public void setValue(E val) {
            tree[v] = val;
        }

        @SuppressWarnings("unchecked")
        public E getValue(){
            return (E)tree[v];
        }
    }

    private Object[] tree;
    private BinaryOperator<E> combiner;
    private int size;
    private Node root;

    public SegmentTree(E[] elements, BinaryOperator<E> combiner){
        this.size = elements.length;
        this.combiner = combiner;
        this.tree = new Object[elements.length*4];
        this.root = new Node(0);
        build(elements, root, 0, size-1);
    }

    private void build(E[] elements, Node v, int tl, int tr) {
        if (tl == tr){
            v.setValue(elements[tl]);
            return;
        }
        int tm = (tl + tr) >>> 1;
        build(elements, v.getLeft(), tl, tm);
        build(elements, v.getRight(), tm+1, tr);
        combineFromChildren(v);
    }

    public E query(int l, int r, Supplier<E> zero) {
        return query(root, 0, size-1, l, r, zero);
    }

    private E query(Node node, int tl, int tr, int l, int r, Supplier<E> zero) {
        if (l > r) {
            return zero.get();
        }
        if (l == tl && r == tr){
            return node.getValue();
        }
        int tm = (tr + tl) >>> 1;
        E left = query(node.getLeft(), tl, tm, l, Math.min(tm, r), zero);
        E right = query(node.getRight(), tm+1, tr, Math.max(l, tm+1),r, zero);
        return combiner.apply(left, right);
    }

    public void update(int pos, E newValue){
        update(root, 0, size-1, pos, newValue);
    }

    private void update(Node v, int tl, int tr, int pos, E newValue){
        if (tl == tr){
            v.setValue(newValue);
        } else {
            int tm = (tl + tr) >>> 1;
            if (pos <= tm){
                update(v.getLeft(), tl, tm, pos, newValue);
            } else {
                update(v.getRight(), tm + 1, tr, pos, newValue);
            }
            combineFromChildren(v);
        }
    }

    private void combineFromChildren(Node v){
        E value = combiner.apply(v.getLeft().getValue(), v.getRight().getValue());
        v.setValue(value);
    }
}
