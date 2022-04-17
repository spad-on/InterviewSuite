package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.DirectedGraph;
import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.exception.CyclicGraphException;
import com.paolotalks.exception.TestCaseNotImplementedException;

import java.util.List;

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
    public static final boolean RUN_OPTIONAL_TESTS = false;

    /**
     * Returns the number of connected components in the graph
     * @param graph an {@link DirectedGraph}
     * @return the number of connected components
     * Pre-conditions: the graph is not null
     */
    public List<Node> visit(DirectedGraph graph) {
        //TODO implement
        throw new TestCaseNotImplementedException();
    }
}
