package com.kalyan.vehicle_tracking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kalyan.vehicle_tracking_system.entity.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    List<Vehicle> findByStatus(String status);

    List<Vehicle> findByUserId(Long userId);
}
