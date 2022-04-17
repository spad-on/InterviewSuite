package com.paolotalks.exercise.ds;

/**
 * Represent an edge in a simple graph.
 * 1) The subclass implementing this should go to
 *    the "impl" package and be called:
 *    "GraphEdgeImpl"
 *
 * 2) The CONSTRUCTOR should take 2 arguments:
 *  - source: Where the edge is coming from
 *  - target: Where the edge is pointed to
 *
 *  As such a graphEdge has a direction and is
 *  therefore a directed edge
 */
public interface IGraphEdge {

    /**
     * Return the source node of this edge.
     * @return the source node of this edge
     */
    IGraphNode getSource();
    /**
     * Return the target node of this edge.
     * @return the target node of this edge
     */
    IGraphNode getTarget();

    /**
     * Equal should be base on source and target.
     * An edge with equal source and equal target should be
     * considered as the same edge.
     * @param obj the other edge to check
     * @return true iff source and target match
     */
    @Override
    boolean equals(Object obj);

    /**
     * This should return a hash representation of
     * the edge based exclusively on the source and the target
     * values.
     * @return a hash representation based on source and target
     */
    @Override
    int hashCode();

    /**
     * Return a string representation of the edge in the format:
     * "(source, target)" with parenthesis and comma included.
     * @return a string representation of the edge
     */
    @Override
    String toString();
}
