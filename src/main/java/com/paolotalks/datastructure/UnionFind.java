package com.paolotalks.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnionFind {

    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> ranks;
    private Map<Integer, Integer> sizes;
    private int numSets;

    public UnionFind() {
        this.parent = new HashMap<>();
        this.ranks = new HashMap<>();
        this.sizes = new HashMap<>();
    }

    public int find(int i){
        Integer p = parent.get(i);
        if (p == null){
            throw new IllegalArgumentException("i does not exists");
        }
        if (p == i){
            return i;
        } else {
          parent.put(i, find(p));
          return parent.get(i);
        }
    }

    public boolean exists(int i){
        return parent.containsKey(i);
    }

    public void makeSet(int i ){
        if (exists(i)) return;
        parent.put(i, i);
        ranks.put(i, 0);
        sizes.put(i, 1);
        numSets++;
    }

    public boolean isSameSet(int i, int j){
        return find(i) == find(j);
    }

    public void union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI == rootJ) return;
        numSets--;
        int rankI = ranks.get(rootI);
        int rankJ = ranks.get(rootJ);
        if ( rankI >= rankJ) {
            parent.put(rootJ, rootI);
            sizes.merge(rootI, sizes.get(rootJ), Integer::sum);
            if (rankI == rankJ) ranks.merge(rootI, 1, Integer::sum);
        } else {
            parent.put(rootI, rootJ); sizes.merge(rootI, sizes.get(rootJ), Integer::sum);
        }
    }

    public int size(int i ){
        return sizes.getOrDefault(find(i), 0);
    }

    public int getNumSets(){
        return numSets;
    }
}
