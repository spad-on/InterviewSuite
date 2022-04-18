package com.paolotalks.exercise.algorithm.graph;

import com.paolotalks.datastructure.graph.Node;
import com.paolotalks.datastructure.graph.UndirectedGraph;
import com.paolotalks.exception.GraphNotBipartiteException;
import com.paolotalks.exercise.util.PartialTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(PartialTestRunner.class)
public class TestBipartiteGraph {

    @Test
    public void testPartition(){
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 9);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(5, 8);
        graph.addEdge(8, 9);

        BipartiteGraph.Partition partition = new BipartiteGraph().visit(graph);
        Set<Integer> odds = partition.getOdd().stream().map(Node::getId).collect(Collectors.toSet());
        Set<Integer> evens = partition.getEven().stream().map(Node::getId).collect(Collectors.toSet());
        if (odds.size() == 4){
            Set<Integer> tmp = odds;
            odds = evens;
            evens = tmp;
        }
        assertEquals("One partition should have 5 elements", 5, odds.size());
        assertEquals("One partition should have 4 elements", 4, evens.size());
        assertTrue(odds.containsAll(Arrays.asList(1, 3, 5, 7, 9)));
        assertTrue(evens.containsAll(Arrays.asList(2, 4, 6, 8)));
    }

    @Test
    public void testSingleNodePartition(){
        UndirectedGraph graph = new UndirectedGraph();
        graph.addNode(42);

        BipartiteGraph.Partition partition = new BipartiteGraph().visit(graph);
        Set<Integer> odds = partition.getOdd().stream().map(Node::getId).collect(Collectors.toSet());
        Set<Integer> evens = partition.getEven().stream().map(Node::getId).collect(Collectors.toSet());
        if (odds.isEmpty()){
            Set<Integer> tmp = odds;
            odds = evens;
            evens = tmp;
        }
        assertEquals("One partition should have 1 element", 1, odds.size());
        assertEquals("One partition should have 0 elements", 0, evens.size());
        assertTrue(odds.contains(42));
        assertTrue(evens.isEmpty());
    }

    @Test
    public void testNonBipartite(){
        if (!BipartiteGraph.RUN_OPTIONAL_TESTS) return;
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        assertThrows(GraphNotBipartiteException.class, () -> new BipartiteGraph().visit(graph));
    }

}
