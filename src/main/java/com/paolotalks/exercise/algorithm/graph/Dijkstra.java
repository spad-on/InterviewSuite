package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.datastructure.graph.UndirectedWeightedGraph;
import com.paolotalks.exception.TestCaseNotImplementedException;

import java.util.Map;

/**
 * Exercise:
 *  Implement the Dijkstra algorithm.
 *      The Dijkstra algorithm calculates the shortest paths from a single node
 *      in a weighted graph with non-negative weights.
 */
public class Dijkstra {

    /**
     * Implement the Dijkstra algorithm.
     * Return a map of distances from the 'source' node (the 'source' node
     * should be considered as having distance 0 from itself, and be included
     * in the result).
     * @param graph the underlying {@link UndirectedWeightedGraph}
     * @param source the source node of the 'graph' to start our visit.
     * @return A mapping of the nodes in the graph with the minimum distance
     *   from the source node.
     * Pre-condition: The graph is connected and has non-negative weights.
     * Pre-condition: The source node belongs with the graph.
     */
    public Map<Node, Integer> visit(UndirectedWeightedGraph graph, Node source) {
        // TODO implement
        throw new TestCaseNotImplementedException();
    }
}
