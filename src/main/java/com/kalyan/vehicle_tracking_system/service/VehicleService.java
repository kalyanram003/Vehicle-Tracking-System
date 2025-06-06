package com.kalyan.vehicle_tracking_system.service;

import java.util.List;
import java.util.Optional;

import com.kalyan.vehicle_tracking_system.entity.Vehicle;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle, Long userId);

    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getVehicleById(Long id);

    List<Vehicle> getVehiclesByUserId(Long userId);

    List<Vehicle> getVehiclesByStatus(String status);

    Vehicle updateVehicle(Long id, Vehicle vehicle, Long userId);

    void deleteVehicle(Long id);
}
