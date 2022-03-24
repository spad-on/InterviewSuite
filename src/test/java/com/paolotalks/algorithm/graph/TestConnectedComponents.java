package com.paolotalks.algorithm.graph;

import com.paolotalks.datastructure.graph.UndirectedGraph;
import com.paolotalks.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(PartialTestRunner.class)
public class TestConnectedComponents {

    @Test
    public void testSingleComponent(){
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 9);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);

        int cc = new ConnectedComponents().visit(graph);
        assertEquals("Wrong number of connected components", 1, cc);
    }

    @Test
    public void testMultipleComponents(){
        UndirectedGraph graph = new UndirectedGraph();
        // 1
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        // 2
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 9);
        // 3
        graph.addEdge(10, 11);
        graph.addEdge(12, 11);
        graph.addEdge(12, 14);
        graph.addEdge(13, 14);
        // 4
        graph.addEdge(15, 16);

        int cc = new ConnectedComponents().visit(graph);
        assertEquals("Wrong number of connected components", 4, cc);
    }

    @Test
    public void testSingleNode(){
        UndirectedGraph graph = new UndirectedGraph();
        graph.addNode(1);

        int cc = new ConnectedComponents().visit(graph);
        assertEquals("Wrong number of connected components", 1, cc);
    }

    @Test
    public void testEmptyGraph(){
        UndirectedGraph graph = new UndirectedGraph();

        int cc = new ConnectedComponents().visit(graph);
        assertEquals("Empty graph has no components", 0, cc);
    }

}
