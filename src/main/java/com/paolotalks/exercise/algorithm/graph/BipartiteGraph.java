package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.Edge;
import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.datastructure.graph.UndirectedGraph;
import com.paolotalks.exception.GraphNotBipartiteException;
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
    public static final boolean RUN_OPTIONAL_TESTS = true;

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
        Partition partition = new Partition();
        Node node = graph.nodes().findFirst().orElse(null);
        visit(node, graph, partition, true);
        return partition;
    }

    private void visit(Node node, UndirectedGraph graph, Partition partition, boolean even){
        if (node == null) return;
        if (even){
            partition.addEven(node);
        } else{
            partition.addOdd(node);
        }

        for (Edge edge : graph.getEdges(node)){
            Node target = edge.getTarget();
            if (even && isEven(target, partition) ||
                !even && isOdd(target, partition)){
                throw new GraphNotBipartiteException();
            }
            if (!visited(target, partition)){
                visit(target, graph, partition, !even);
            }
        }

    }

    private boolean isEven(Node node, Partition p){
        return p.getEven().contains(node);
    }

    private boolean isOdd(Node node, Partition p){
        return p.getOdd().contains(node);
    }

    private boolean visited(Node node, Partition p){
        return isEven(node, p) || isOdd(node, p);
    }


}
