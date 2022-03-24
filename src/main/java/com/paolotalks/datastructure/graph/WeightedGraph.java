package com.paolotalks.datastructure.graph;

public interface WeightedGraph<E extends WeightedEdge> extends Graph<E> {

    void addEdge(int from, int to, int weight);
}
