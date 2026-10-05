package com.transitnetwork.ui;

import com.transitnetwork.algorithm.GraphOptimizer;
import com.transitnetwork.dao.MySQLNetworkDAO;
import com.transitnetwork.dao.NetworkDAO;
import com.transitnetwork.model.Route;
import com.transitnetwork.model.Station;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: #f4f4f4;");

        // 1. Fetch data and optimize
        NetworkDAO dao = new MySQLNetworkDAO();
        List<Station> stations = dao.getAllStations();
        List<Route> allRoutes = dao.getAllRoutes();
        
        GraphOptimizer optimizer = new GraphOptimizer(stations, allRoutes);
        List<Route> mstRoutes = optimizer.calculateMinimumSpanningTree();

        // 2. Draw ALL routes (in light gray)
        for (Route route : allRoutes) {
            drawLine(root, route, stations, Color.LIGHTGRAY, 2.0);
        }

        // 3. Draw the MST routes (in bold red)
        for (Route route : mstRoutes) {
            drawLine(root, route, stations, Color.RED, 4.0);
        }

        // 4. Draw the Stations (circles) on top of the lines
        for (Station station : stations) {
            Circle circle = new Circle(station.getXCoordinate(), station.getYCoordinate(), 10, Color.BLUE);
            Text label = new Text(station.getXCoordinate() - 15, station.getYCoordinate() - 15, station.getName());
            root.getChildren().addAll(circle, label);
        }

        // 5. Display the window
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Transit Network Optimizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to connect the dots
    private void drawLine(Pane root, Route route, List<Station> stations, Color color, double width) {
        Station source = stations.stream().filter(s -> s.getStationId() == route.getSourceId()).findFirst().orElse(null);
        Station dest = stations.stream().filter(s -> s.getStationId() == route.getDestinationId()).findFirst().orElse(null);

        if (source != null && dest != null) {
            Line line = new Line(source.getXCoordinate(), source.getYCoordinate(), 
                                 dest.getXCoordinate(), dest.getYCoordinate());
            line.setStroke(color);
            line.setStrokeWidth(width);
            root.getChildren().add(line);
        }
    }
}