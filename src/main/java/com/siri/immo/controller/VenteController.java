package com.siri.immo.controller;

import com.siri.immo.model.Products;
import com.siri.immo.model.Vente;
import com.siri.immo.repository.ProductsRepository;
import com.siri.immo.repository.VenteRepository;
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
public class VenteController {
    @Autowired
    private VenteRepository venteRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping("/create-vente")
    public ResponseEntity<Vente> createVente(@RequestBody Vente vente, HttpServletRequest httpServletRequest) throws URISyntaxException {
        Products productsVendu = vente.getProd();
        if (!productsVendu.getType().equals("a-vendre")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productsVendu.setStatut("vendu");
        productsRepository.save(productsVendu);
        vente.setDatevente(new Date());
        Vente result = venteRepository.save(vente);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/list-vente")
    public ResponseEntity<List<Vente>> getVente(HttpServletRequest httpServletRequest) {
        List<Vente> ventesList = venteRepository.findAll();
        try {
            if (ventesList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok().body(ventesList);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
