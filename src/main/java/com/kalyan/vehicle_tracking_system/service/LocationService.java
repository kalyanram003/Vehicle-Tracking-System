package com.kalyan.vehicle_tracking_system.service;


import java.util.List;
import java.util.Optional;

import com.kalyan.vehicle_tracking_system.model.Location;

public interface LocationService {

    Location createLocation(Location location, Long vehicleId);

    List<Location> getAllLocations();

    Optional<Location> getLocationById(Long id);

    List<Location> getLocationsByVehicleId(Long vehicleId);

    void deleteLocation(Long id);
}
