package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Location;
import com.example.demo.models.User;
import com.example.demo.services.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/locations/{id}")
    public Optional<Location> getLocationById(@PathVariable Integer id)
    {
        return locationService.getLocationById(id);
    }

    @GetMapping("/locations/{id}/users")
    public List<User> getUsersByLocation(@PathVariable Integer id)
    {
        Optional<Location> location = locationService.getLocationById(id);
        if(location.isPresent())
        {
            return location.get().getUsers();
        }
        return null;
    }

    @PostMapping("/locations")
    public void AddLocation(@RequestBody Location location)
    {
        locationService.AddLocation(location);
    }

    @PutMapping("/locations/{id}")
    public void UpdateLocation(@RequestBody Location location)
    {
        locationService.UpdateLocation(location);
    }
}
