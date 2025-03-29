package com.kalyan.vehicle_tracking_system.service;

import java.util.List;
import java.util.Optional;

import com.kalyan.vehicle_tracking_system.model.Vehicle;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getVehicleById(Long id);

    List<Vehicle> getVehiclesByUserId(Long userId);

    List<Vehicle> getVehiclesByStatus(String status);

    Vehicle updateVehicle(Long id, Vehicle vehicle);

    void deleteVehicle(Long id);
}
