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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private LocationRepository locationRepository;


    @PostMapping("/create-product")
    public ResponseEntity<Products> createProducts(@RequestBody Products products, HttpServletRequest httpServletRequest) throws URISyntaxException {
        products.setStatut("cree");
        products.setDateAjout(new Date());
        Products result = productsRepository.save(products);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/list-product/{type}/{statut}")
    public ResponseEntity <List<Products>> getProducts(@PathVariable("type") String type, @PathVariable("statut") String statut, HttpServletRequest httpServletRequest) {
        try {
            List<Products> products = productsRepository.findAllByTypeAndStatut(type, statut);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok().body(products);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //Update bien
    @PutMapping("/update-products")
    public ResponseEntity<Products> updateProducts(@RequestBody Products products,
                                           HttpServletRequest httpServletRequest) throws URISyntaxException {
        if (products.getId() == null) {
            //throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        products.setDateModification(new Date());
        Products result = productsRepository.save(products);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete-products/{id}")
    public ResponseEntity<Void> deleteProducts(@PathVariable("id") Long id,
                                           HttpServletRequest httpServletRequest) {
        List<Location> locationList = new ArrayList<>();
        locationList = locationRepository.findAllByProduct_Id(id);

        if (locationList.size()>0){

        }
        if (locationList.size()<=0){
            productsRepository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }

}
