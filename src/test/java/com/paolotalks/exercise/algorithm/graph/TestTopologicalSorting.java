package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.DirectedGraph;
import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.exception.CyclicGraphException;
import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(PartialTestRunner.class)
public class TestTopologicalSorting {

    private enum P{
        N,Z,P;
    }

    @Test
    public void testSingleComponent(){
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(6, 7);

        List<Node> topologicalSort = new TopologicalSorting().visit(graph);
        for (Node node : graph.nodeSet()){
            assertTrue("Node '" + node + "' not found in order", topologicalSort.contains(node));
        }
        for (int i = 1; i < 7; i++){
            for (int j = i+1; j <= 7; j++){
                if (i == 1 && j == 2) continue; // those two can be inverted
                assertTrue(isBefore(graph.getNode(i), graph.getNode(j), topologicalSort));
            }
        }
    }

    @Test
    public void testMultipleComponents(){
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(6, 7);
        //
        graph.addEdge(10, 20);
        graph.addEdge(10, 30);
        graph.addEdge(10, 40);
        graph.addEdge(10, 50);
        graph.addEdge(20, 30);
        graph.addEdge(20, 40);
        graph.addEdge(30, 40);
        graph.addEdge(30, 50);
        graph.addEdge(40, 50);

        List<Node> topologicalSort = new TopologicalSorting().visit(graph);
        for (Node node : graph.nodeSet()){
            assertTrue("Node '" + node + "' not found in order", topologicalSort.contains(node));
        }
        for (int i = 1; i < 7; i++){
            for (int j = i+1; j <= 7; j++){
                if (i == 1 && j == 2) continue; // those two can be inverted
                assertTrue(isBefore(graph.getNode(i), graph.getNode(j), topologicalSort));
            }
        }

        for (int i = 10; i < 50; i += 10){
            for (int j = i+10; j <= 50; j += 10){
                assertTrue(isBefore(graph.getNode(i), graph.getNode(j), topologicalSort));
            }
        }
    }


    private boolean isBefore(Node src, Node tgt, List<Node> order){
        int srcIndex = order.indexOf(src);
        assertTrue(srcIndex >= 0);
        int tgtIndex = order.indexOf(tgt);
        assertTrue(tgtIndex >= 0);
        return srcIndex < tgtIndex;
    }

    @Test
    public void testCyclicGraph(){
        if (!TopologicalSorting.RUN_OPTIONAL_TESTS) return;
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);

        assertThrows(CyclicGraphException.class, () -> new TopologicalSorting().visit(graph));
    }

}
