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
        //TODO implement
        throw new TestCaseNotImplementedException();
    }
}
