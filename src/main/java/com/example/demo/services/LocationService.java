package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Location;
import com.example.demo.repositories.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Integer id) {
		return locationRepository.findById(id);
	}

    public void AddLocation(Location location){
        locationRepository.save(location);
    }

	public void UpdateLocation(Location location) {
        locationRepository.save(location);
	}

}
