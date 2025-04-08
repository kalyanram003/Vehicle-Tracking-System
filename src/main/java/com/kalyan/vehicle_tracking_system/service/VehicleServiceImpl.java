package com.kalyan.vehicle_tracking_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.vehicle_tracking_system.entity.User;
import com.kalyan.vehicle_tracking_system.entity.Vehicle;
import com.kalyan.vehicle_tracking_system.repository.UserRepository;
import com.kalyan.vehicle_tracking_system.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Vehicle createVehicle(Vehicle vehicle, Long userId) {
        if (userId != null) {
            Optional<User> user = userRepository.findById(userId);
            user.ifPresent(vehicle::setUser);
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> getVehiclesByUserId(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }

    @Override
    public List<Vehicle> getVehiclesByStatus(String status) {
        return vehicleRepository.findByStatus(status);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle, Long userId) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setType(vehicle.getType());
        existingVehicle.setStatus(vehicle.getStatus());

        if (userId != null) {
            Optional<User> user = userRepository.findById(userId);
            user.ifPresent(existingVehicle::setUser);
        }

        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
