package com.paolotalks.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph extends AbstractGraph<Edge> implements SimpleGraph<Edge> {

    @Override
    public void addEdge(int from, int to) {
        Node src = getOrCreateNode(from);
        Node tgt = getOrCreateNode(to);
        addEdgeInternal(src, tgt);
        addEdgeInternal(tgt, src);
    }

    protected void addEdgeInternal(Node src, Node tgt){
        edges.computeIfAbsent(src, s -> new HashSet<>());
        edges.get(src).add(new Edge(src, tgt));
    }

}
