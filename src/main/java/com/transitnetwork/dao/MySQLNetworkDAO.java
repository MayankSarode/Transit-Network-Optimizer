package com.transitnetwork.dao;

import com.transitnetwork.model.Station;
import com.transitnetwork.model.Route;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLNetworkDAO implements NetworkDAO {
    private Connection connection;

    public MySQLNetworkDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Station> getAllStations() {
        List<Station> stations = new ArrayList<>();
        String query = "SELECT * FROM Stations";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Station station = new Station();
                station.setStationId(rs.getInt("station_id"));
                station.setName(rs.getString("name"));
                station.setXCoordinate(rs.getInt("x_coordinate"));
                station.setYCoordinate(rs.getInt("y_coordinate"));
                stations.add(station);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stations;
    }

    @Override
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String query = "SELECT * FROM Routes";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Route route = new Route();
                route.setRouteId(rs.getInt("route_id"));
                route.setSourceId(rs.getInt("source_id"));
                route.setDestinationId(rs.getInt("destination_id"));
                route.setWeight(rs.getDouble("weight"));
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }

    @Override 
    public void addStation(Station station){

    }
    @Override 
    public void updateStation(Station station){
        
    }
    @Override 
    public void deleteStation(Station station){
        
    }


}