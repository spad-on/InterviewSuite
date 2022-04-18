package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.DirectedGraph;
import com.paolotalks.datastructure.graph.Edge;
import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.exception.TestCaseNotImplementedException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Exercise:
 *  Partition all edges of a directed graph according to their definition.
 *  Tree edges: These are the edges that make up the tree resulting from the visit.
 *  Forward edges: These are the edges that goes from a node up the tree to a node
 *                 down the tree, already visited.
 *  Backward edges: These edges goes from a visited node to one of its anchestors,
 *                  forming a loop.
 *  Across edges: These edges goes from a one subtree to another.
 *  More info: https://www.geeksforgeeks.org/tree-back-edge-and-cross-edges-in-dfs-of-graph
 *
 */
public class EdgePartition {
    /**
     * Contains all types of edges to save during the visit.
     */
    public static class EdgeData {
        private Set<Edge> tree;
        private Set<Edge> forward;
        private Set<Edge> backward;
        private Set<Edge> across;

        EdgeData(){
            this.tree = new HashSet<>();
            this.forward = new HashSet<>();
            this.backward = new HashSet<>();
            this.across = new HashSet<>();

        }
        void addTreeEdge(Edge e){
            this.tree.add(e);
        }

        void addForwardEdge(Edge e){
            this.forward.add(e);
        }

        void addAcrossEdge(Edge e){
            this.across.add(e);
        }

        void addBackwardEdge(Edge e){
            this.backward.add(e);
        }

        public Set<Edge> getAcross() {
            return across;
        }

        public Set<Edge> getBackward() {
            return backward;
        }

        public Set<Edge> getForward() {
            return forward;
        }

        public Set<Edge> getTree() {
            return tree;
        }
    }

    /**
     * Partition all edges of a {@link DirectedGraph} to their category.
     * @param graph the {@link DirectedGraph} to visit
     * @return the {@link EdgeData} saving all edges
     *  according to their definition.
     * Pre-condition: The graph is connected.
     */
    public EdgeData visit(Node start, DirectedGraph graph){
        // TODO implement
        throw new TestCaseNotImplementedException();
    }

}
