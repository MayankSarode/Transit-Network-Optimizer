package com.transitnetwork.algorithm;

import com.transitnetwork.model.Station;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind {
    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> rank = new HashMap<>();

    public UnionFind(List<Station> stations) {
        // Initially, every station is its own parent (a disconnected island)
        for (Station s : stations) {
            parent.put(s.getStationId(), s.getStationId());
            rank.put(s.getStationId(), 0);
        }
    }

    // Path Compression: Flattens the tree to speed up future lookups
    public int find(int i) {
        if (parent.get(i) == i) {
            return i;
        }
        int root = find(parent.get(i));
        parent.put(i, root);
        return root;
    }

    // Union by Rank: Attaches the smaller tree under the taller tree
    public boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        // If they have the same root, connecting them would cause a cycle
        if (rootI == rootJ) {
            return false;
        }

        int rankI = rank.get(rootI);
        int rankJ = rank.get(rootJ);

        if (rankI > rankJ) {
            parent.put(rootJ, rootI);
        } else if (rankI < rankJ) {
            parent.put(rootI, rootJ);
        } else {
            parent.put(rootJ, rootI);
            rank.put(rootI, rankI + 1);
        }
        
        return true; // Successfully connected without forming a cycle
    }
}