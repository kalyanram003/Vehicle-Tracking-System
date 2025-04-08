package com.kalyan.vehicle_tracking_system.controller;

import com.kalyan.vehicle_tracking_system.api_call.GeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vts/geocode")
public class GeocodingController {

    @Autowired
    private GeocodingService geocodingService;

    @GetMapping
    public String getAddress(@RequestParam double latitude, @RequestParam double longitude) {
        return geocodingService.getAddressFromCoordinates(latitude, longitude);
    }
}

