package com.transitnetwork;

import com.transitnetwork.dao.MySQLNetworkDAO;
import com.transitnetwork.dao.NetworkDAO;
import com.transitnetwork.model.Route;
import com.transitnetwork.model.Station;
import com.transitnetwork.algorithm.GraphOptimizer;
import com.transitnetwork.ui.MainView;
import javafx.application.Application;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Application.launch(MainView.class, args);
        System.out.println("Starting Transit Network Optimizer...");
        
        // 1. Initialize the DAO (this will trigger the DatabaseConnection)
        NetworkDAO dao = new MySQLNetworkDAO();
        
        // 2. Fetch and print all stations
        System.out.println("\n--- Loaded Stations ---");
        List<Station> stations = dao.getAllStations();
        if (stations.isEmpty()) {
            System.out.println("No stations found. Did you run the SQL INSERT script?");
        } else {
            for (Station station : stations) {
                System.out.println(station.toString());
            }
        }

        // 3. Fetch and print all routes
        System.out.println("\n--- Loaded Routes ---");
        List<Route> routes = dao.getAllRoutes();
        if (routes.isEmpty()) {
            System.out.println("No routes found.");
        } else {
            for (Route route : routes) {
                System.out.println(route.toString());
            }
        }
        
        System.out.println("\nPhase 1 Pipeline Test Complete.");
        // ... (Keep your existing Phase 1 code above this) ...

        System.out.println("\n--- Phase 2: Algorithmic Optimization ---");
        GraphOptimizer optimizer = new GraphOptimizer(stations, routes);
        List<Route> optimizedNetwork = optimizer.calculateMinimumSpanningTree();
        
        System.out.println("Minimum Spanning Tree (Optimized Routes):");
        for (Route route : optimizedNetwork) {
            System.out.println(route.toString());
        }
    }
}