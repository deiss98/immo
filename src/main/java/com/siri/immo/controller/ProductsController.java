package com.siri.immo.controller;

import com.siri.immo.model.Products;
import com.siri.immo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;
    @PostMapping("/create-product")
    public ResponseEntity<Products> createProducts(@RequestBody Products products, HttpServletRequest httpServletRequest) throws URISyntaxException {

        Products result = productsRepository.save(products);

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/list-product")
    public ResponseEntity <List<Products>> getProducts(HttpServletRequest httpServletRequest) {
        List<Products> products = productsRepository.findAll();
        return ResponseEntity.ok().body(products);
    }
    //Update bien
    @PutMapping("/update-products")
    public ResponseEntity<Products> updateProducts(@RequestBody Products products,
                                           HttpServletRequest httpServletRequest) throws URISyntaxException {
        if (products.getId() == null) {
            //throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Products result = productsRepository.save(products);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete-products/{id}")
    public ResponseEntity<Void> deleteProducts(@PathVariable Long id,
                                           HttpServletRequest httpServletRequest) {
        productsRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
