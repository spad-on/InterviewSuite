package com.paolotalks.algorithm.graph;

import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.datastructure.graph.UndirectedGraph;
import com.paolotalks.exception.TestCaseNotImplementedException;

import java.util.HashSet;
import java.util.Set;

/**
 * Exercise:
 *  Given a {@link UndirectedGraph} calculate the bipartition of a graph.
 * Optional:
 *  If the graph is not bipartite, raise a {@link com.paolotalks.exception.GraphNotBipartiteException}
 */
public class BipartiteGraph {
    /**
     * Controls whether to run the optional tests.
     */
    public static final boolean RUN_OPTIONAL_TESTS = false;

    /**
     * Represents the partition of a bipartite graph.
     * We use 'even' and 'odd' as naming conventions, although
     * this has nothing to do with the node id in the graph.
     */
    public static class Partition {
        private Set<Node> even = new HashSet<>();
        private Set<Node> odd = new HashSet<>();

        public Set<Node> getOdd() {
            return odd;
        }

        public Set<Node> getEven() {
            return even;
        }

        private void addOdd(Node node){
            this.odd.add(node);
        }

        private void addEven(Node node){
            this.even.add(node);
        }
    }

    /**
     * Calculate the bipartition of a graph.
     * @param graph an {@link UndirectedGraph}
     * @return the partition of the graph into two sets.
     * @throws {@link com.paolotalks.exception.GraphNotBipartiteException}
     *  if the graph is not a bipartite one (optional).
     * Pre-conditions: the graph is not null.
     * Pre-conditions: the graph is connected.
     */
    public Partition visit(UndirectedGraph graph){
        // TODO implement
        throw new TestCaseNotImplementedException();
    }


}
