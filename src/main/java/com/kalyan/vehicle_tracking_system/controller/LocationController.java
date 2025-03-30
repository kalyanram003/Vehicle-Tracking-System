package com.kalyan.vehicle_tracking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kalyan.vehicle_tracking_system.model.Location;
import com.kalyan.vehicle_tracking_system.service.LocationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/vts/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Map<String, Object> request) {
        Location location = new Location();

        location.setLatitude(Double.parseDouble(request.get("latitude").toString()));
        location.setLongitude(Double.parseDouble(request.get("longitude").toString()));

        // ✅ Parse the timestamp properly
        String timestampStr = request.get("timestamp").toString();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime timestamp = LocalDateTime.parse(timestampStr, formatter);
        location.setTimestamp(timestamp);

        // Extract vehicleId from request
        Long vehicleId = request.get("vehicleId") != null ? Long.parseLong(request.get("vehicleId").toString()) : null;

        Location savedLocation = locationService.createLocation(location, vehicleId);
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
