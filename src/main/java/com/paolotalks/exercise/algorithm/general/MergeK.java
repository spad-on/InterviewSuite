package com.paolotalks.exercise.algorithm.general;

import java.util.*;

/**
 * Exercise:
 *   Given n sorted list of integers, merge them in a single ordered list.
 *   Both input and output ordering is ascending.
 *   This should be implemented as a generalisation of the usual merge procedure
 *   used in the merge sort.
 */
public class MergeK {

    private static class ListIt implements Comparable<ListIt>, Iterator<ListIt>{
        private Iterator<Integer> it;
        private int element;

        ListIt(Iterator<Integer> it){
            if (!it.hasNext())
                throw new IllegalStateException("it has no next element");
            this.it = it;
            this.element = it.next();
        }

        public int getElement() {
            return element;
        }

        public boolean hasNext(){
            return it.hasNext();
        }
        public ListIt next(){
            return new ListIt(it);
        }

        public int compareTo(ListIt oth){
            return Integer.compare(this.element, oth.element);
        }
    }

    /**
     * Merges the n lists into a single ordered list.
     * @param lists
     * @return the resulting ordered list
     * Pre-condition: the input is never null.
     * Pre-condition: each list is sorted in ascending order.
     */
    public List<Integer> merge(List<List<Integer>> lists) {
        int total = 0;
        Queue<ListIt> queue = new PriorityQueue<>();
        for (List<Integer> lst : lists){
            if (lst.isEmpty()) continue;
            queue.offer(new ListIt(lst.iterator()));
            total += lst.size();
        }

        List<Integer> result = new ArrayList<>(total);
        while (!queue.isEmpty()){
            ListIt el = queue.poll();
            result.add(el.getElement());
            if (el.hasNext())
                queue.offer(el.next());
        }
        return result;
    }
}
