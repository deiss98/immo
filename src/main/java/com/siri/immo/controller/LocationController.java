package com.siri.immo.controller;

import com.siri.immo.model.Location;
import com.siri.immo.model.Products;
import com.siri.immo.repository.LocationRepository;
import com.siri.immo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ProductsRepository productsRepository;
    @PostMapping("/create-location")
    public ResponseEntity<Location> createLocation(@RequestBody Location location, HttpServletRequest httpServletRequest) throws URISyntaxException {

        Products productsLouer = location.getProduct();
        if (!productsLouer.getType().equals("a-louer")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productsLouer.setStatut("loue");
        productsRepository.save(productsLouer);
        location.setDebutLocation(new Date());
        Location result = locationRepository.save(location);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/list-location")
    public ResponseEntity <List<Location>> getLocation(HttpServletRequest httpServletRequest) {
        List<Location> locations = locationRepository.findAll();
        try {
            if (locations.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok().body(locations);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*@PutMapping("/update-location")
    public ResponseEntity<Location> updateLocations(@RequestBody Location location, HttpServletRequest httpServletRequest) throws URISyntaxException {
        if (location.getId() == null) {
        }
        Location result = locationRepository.save(location);

        return ResponseEntity.ok().body(result);
    }*/

    @PutMapping("/restitution-location")
    public ResponseEntity<Location> restitutionLocations(@RequestBody Location location, HttpServletRequest httpServletRequest) throws URISyntaxException {
        if (location.getId() == null) {
        }
        location.setDateRestitution(new Date());

        Location result = locationRepository.save(location);

        Products productsLouer = location.getProduct();
        productsLouer.setStatut("cree");
        productsRepository.save(productsLouer);
        return ResponseEntity.ok().body(result);
    }
    // Impossible de supprimer de location
    /*@DeleteMapping("/delete-location/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id, HttpServletRequest httpServletRequest) {
        locationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/

}
