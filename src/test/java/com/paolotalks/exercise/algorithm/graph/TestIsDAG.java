package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.DirectedGraph;
import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(PartialTestRunner.class)
public class TestIsDAG {

    @Test
    public void testDAG(){
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 9);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(8, 9);

        boolean isDAG = new IsDAG().visit(graph);
        assertTrue(isDAG);
    }

    @Test
    public void testNotDAG(){
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 8);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(6, 2);

        boolean isDAG = new IsDAG().visit(graph);
        assertFalse(isDAG);
    }

    @Test
    public void testDAGForest(){
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 9);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(8, 9);

        graph.addEdge(10, 20);
        graph.addEdge(20, 30);
        graph.addEdge(20, 60);
        graph.addEdge(60, 40);
        graph.addEdge(40, 50);
        graph.addEdge(30, 40);

        boolean isDAG = new IsDAG().visit(graph);
        assertTrue(isDAG);
    }

    @Test
    public void testNonDAGForest(){
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 9);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(8, 9);

        graph.addEdge(10, 20);
        graph.addEdge(20, 30);
        graph.addEdge(20, 60);
        graph.addEdge(60, 40);
        graph.addEdge(40, 20);

        boolean isDAG = new IsDAG().visit(graph);
        assertFalse(isDAG);
    }

}
