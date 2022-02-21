package com.siri.immo.controller;

import com.siri.immo.model.Location;
import com.siri.immo.model.Products;
import com.siri.immo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;
    @PostMapping("/create-location")
    public ResponseEntity<Location> createLocation(@RequestBody Location location, HttpServletRequest httpServletRequest) throws URISyntaxException {
        Location result = locationRepository.save(location);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/list-location")
    public ResponseEntity <List<Location>> getLocation(HttpServletRequest httpServletRequest) {
        List<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok().body(locations);
    }

    @PutMapping("/update-location")
    public ResponseEntity<Location> updateLocations(@RequestBody Location location, HttpServletRequest httpServletRequest) throws URISyntaxException {
        if (location.getId() == null) {
        }
        Location result = locationRepository.save(location);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete-location/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        locationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
