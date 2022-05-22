package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.Edge;
import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.datastructure.graph.UndirectedGraph;
import com.paolotalks.exception.TestCaseNotImplementedException;

import java.util.HashSet;
import java.util.Set;

/**
 * Exercise:
 *  Find the number of connected components in a graph.
 */
public class ConnectedComponents {
    /**
     * Returns the number of connected components in the graph
     * @param graph an {@link UndirectedGraph}
     * @return the number of connected components
     * Pre-conditions: the graph is not null
     */
    public int visit(UndirectedGraph graph) {
        Set<Node> visited = new HashSet<>();
        int cc = 0;
        for (Node node : graph.nodeSet()){
            if (!visited.contains(node)){
                visit(node, graph, visited);
                cc++;
            }
        }
        return cc;
    }

    private void visit(Node node, UndirectedGraph graph, Set<Node> visited){
        visited.add(node);
        for (Edge e : graph.getEdges(node)){
            Node next = e.getTarget();
            if (!visited.contains(next)){
                visit(next, graph, visited);
            }
        }
    }
}
