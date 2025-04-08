package com.kalyan.vehicle_tracking_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.vehicle_tracking_system.api_call.GeocodingService;
import com.kalyan.vehicle_tracking_system.entity.Location;
import com.kalyan.vehicle_tracking_system.entity.Vehicle;
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

    @Autowired
    private GeocodingService geocodingService;


    @Override
public Location createLocation(Location location, Long vehicleId) {
    if (vehicleId != null) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        vehicle.ifPresent(location::setVehicle);
    }
    try {
        String address = geocodingService.getAddressFromCoordinates(
            location.getLatitude(), location.getLongitude()
        );
        location.setAddress(address);
    } catch (Exception e) {
        // Optional: Log the error if you have a logger
        // logger.error("Failed to fetch address: " + e.getMessage());
        location.setAddress("Unable to fetch address");
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
