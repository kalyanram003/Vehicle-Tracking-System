package com.kalyan.vehicle_tracking_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.vehicle_tracking_system.model.Location;
import com.kalyan.vehicle_tracking_system.model.Vehicle;
import com.kalyan.vehicle_tracking_system.repository.LocationRepository;
import com.kalyan.vehicle_tracking_system.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Location createLocation(Location location, Long vehicleId) {
        if (vehicleId != null) {
            Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
            vehicle.ifPresent(location::setVehicle);
        }

        return locationRepository.save(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getLocationsByVehicleId(Long vehicleId) {
        return locationRepository.findByVehicleId(vehicleId);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
