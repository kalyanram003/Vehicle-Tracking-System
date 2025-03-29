package com.kalyan.vehicle_tracking_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kalyan.vehicle_tracking_system.model.Location;
import com.kalyan.vehicle_tracking_system.service.LocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location savedLocation = locationService.createLocation(location);
        return ResponseEntity.ok(savedLocation);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Location>> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationService.getLocationById(id);
        return ResponseEntity.ok(location);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<Location>> getLocationsByVehicleId(@PathVariable Long vehicleId) {
        List<Location> locations = locationService.getLocationsByVehicleId(vehicleId);
        return ResponseEntity.ok(locations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.ok("Location deleted successfully.");
    }
}
