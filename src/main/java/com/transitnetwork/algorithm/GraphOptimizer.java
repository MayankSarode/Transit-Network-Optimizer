package com.transitnetwork.algorithm;

import com.transitnetwork.model.Route;
import com.transitnetwork.model.Station;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphOptimizer {
    private List<Station> stations;
    private List<Route> routes;

    public GraphOptimizer(List<Station> stations, List<Route> routes) {
        this.stations = stations;
        this.routes = routes;
    }

    public List<Route> calculateMinimumSpanningTree() {
        List<Route> mst = new ArrayList<>();
        UnionFind uf = new UnionFind(stations);

        // Greedy choice: Sort all edges by weight, cheapest to most expensive
        Collections.sort(routes);

        for (Route route : routes) {
            // uf.union() returns true if a cycle is NOT formed
            if (uf.union(route.getSourceId(), route.getDestinationId())) {
                mst.add(route);
            }
            
            // Optimization: An MST will always have exactly (Vertices - 1) edges
            if (mst.size() == stations.size() - 1) {
                break; 
            }
        }
        
        return mst;
    }
}