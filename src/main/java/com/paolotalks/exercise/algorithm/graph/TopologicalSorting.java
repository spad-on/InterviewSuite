package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.DirectedGraph;
import com.paolotalks.datastructure.graph.Edge;
import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.exception.CyclicGraphException;

import java.util.*;

/**
 * Exercise:
 *  Return a topological order of the graph
 * Optional:
 *  *  If the graph is not a acyclic, raise a {@link CyclicGraphException}
 */
public class TopologicalSorting {
    /**
     * Controls whether to run the optional tests.
     */
    public static final boolean RUN_OPTIONAL_TESTS = true;

    /**
     * Returns a topological sort of the current graph.
     * If RUN_OPTIONAL_TESTS is set to true the algorithm should
     * check if the graph is indeed acyclic and, if not, it should
     * throw a {@link CyclicGraphException}.
     * @param graph an {@link DirectedGraph}
     * @return a topological sort of the current graph
     * Pre-conditions: the graph is not null
     * Pre-conditions: the graph might NOT be connected
     */
    public List<Node> visit(DirectedGraph graph) {
        LinkedList<Node> order = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        for (Node node : graph.nodeSet()){
            if (visited.containsKey(node)) continue;
            visit(node, graph, visited, order);
        }
        return order;
    }

    private void visit(Node node, DirectedGraph graph, Map<Node, Boolean> visited, Deque<Node> result){
        if (node == null) return;
        visited.put(node, true);

        for (Edge e : graph.getEdges(node)){
            Node next = e.getTarget();
            if (!visited.containsKey(next)){
                visit(next, graph, visited, result);
            } else if (visited.get(next)){
                throw new CyclicGraphException();
            }
        }
        result.addFirst(node);
        visited.put(node, false);
    }
}
