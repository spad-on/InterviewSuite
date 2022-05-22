package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.DirectedGraph;
import com.paolotalks.datastructure.graph.Edge;
import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.exception.CyclicGraphException;
import com.paolotalks.exception.TestCaseNotImplementedException;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Exercise:
 *  Find out if the {@link DirectedGraph} is a acyclic or not.
 *
 */
public class IsDAG {

    /**
     * Find whether the {@link DirectedGraph} is a DAG or not.
     * @param graph the {@link DirectedGraph} to visit
     * @return whether the graph is a DAG or not.
     * Pre-condition: The graph is connected.
     */
    public boolean visit(DirectedGraph graph) {
        Map<Node, Boolean> visited = new HashMap<>();
        Node node = graph.nodes().findFirst().orElse(null);
        return visit(node, graph, visited);
    }

    private boolean visit(Node node, DirectedGraph graph, Map<Node, Boolean> visited){
        if (node == null) return true;
        visited.put(node, true);

        for (Edge e : graph.getEdges(node)){
            Node next = e.getTarget();
            if (!visited.containsKey(next)){
                if (!visit(next, graph, visited)){
                    return false;
                }
            } else if (visited.get(next)){
                return false;
            }
        }

        visited.put(node, false);
        return true;
    }

}
