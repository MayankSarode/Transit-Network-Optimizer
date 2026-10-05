package com.transitnetwork.dao;

import com.transitnetwork.model.Station;
import com.transitnetwork.model.Route;
import java.util.List;

public interface NetworkDAO {
    List<Station> getAllStations();
    List<Route> getAllRoutes();

    void addStation(Station station);
    void updateStation(Station station);
    void deleteStation(Station station);

    // We can add addStation() and addRoute() later if needed
}