package com.kalyan.vehicle_tracking_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;
    private Double longitude;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @JsonIgnoreProperties("locations") 
    private Vehicle vehicle;
}
