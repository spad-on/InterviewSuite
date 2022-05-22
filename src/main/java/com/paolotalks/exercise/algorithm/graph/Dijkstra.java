package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.datastructure.graph.UndirectedWeightedGraph;
import com.paolotalks.datastructure.graph.WeightedEdge;

import java.util.*;

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
        Map<Node, Integer> distances = new HashMap<>();

        final Map<Node, Integer> partials = new HashMap<>();
        TreeSet<Node> queue = new TreeSet<>((a, b) -> {
            int aa = partials.get(a);
            int bb = partials.get(b);
            int cmp = Integer.compare(aa, bb);
            return cmp == 0 ? a.compareTo(b) : cmp;
        });
        partials.put(source, 0);
        queue.add(source);
        while (!queue.isEmpty()){
            Node current = queue.pollFirst();
            int distSoFar = partials.get(current);
            distances.put(current, distSoFar);
            partials.remove(current);
            for (WeightedEdge e : graph.getEdges(current)) {
                Node target = e.getTarget();
                if (distances.containsKey(target)) continue;
                int w = e.getWeight();
                Integer dist = partials.get(target);
                if (dist == null) {
                    dist = distSoFar + w;
                    partials.put(target, dist);
                    queue.add(target);
                } else if (dist > distSoFar + w){
                    queue.remove(target); // O(log n)
                    partials.put(target, distSoFar + w);
                    queue.add(target); // O(log n)
                }
            }
        }
        return distances;
    }
}
