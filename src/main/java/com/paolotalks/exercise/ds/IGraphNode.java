package com.paolotalks.exercise.ds;

import java.util.Set;
import java.util.stream.Stream;

/**
 * Represent a node in a simple graph.
 *
 * 1) The subclass implementing this should go to
 *    the "impl" package and be called:
 *    "GraphNodeImpl"
 *
 * 2) The CONSTRUCTOR should take 1 argument:
 *  - id: the id associated with this node
 *
 */
public interface IGraphNode {

    /**
     * Add a node to this {@link IGraphNode}
     * @param node the node to add
     * @throws IllegalArgumentException if node is null
     */
    void addNode(IGraphNode node);

    /**
     * Return a collection of adjacent edges of this {@link IGraphNode}
     * @return a collection of adjacent edges of this {@link IGraphNode}
     */
    Set<IGraphEdge> getEdges();
    /**
     * Return a stream of adjacent edges of this {@link IGraphNode}
     * @return a stream of adjacent edges of this {@link IGraphNode}
     */
    Stream<IGraphEdge> edges();

    /**
     * Return the node's unique Id
     * @return the node's unique Id
     */
    int getId();

    /**
     * Equal should be overridden to use the node's unique id
     */
    @Override
    boolean equals(Object obj);

    /**
     * This should be overridden to use the node's unique id
     * @return a hash code based on the node's id
     */
    @Override
    int hashCode();

    /**
     * This method should print the node's id.
     * @return a string containing the node's id.
     */
    @Override
    String toString();
}
