package com.siri.immo.controller;

import com.siri.immo.model.Vente;
import com.siri.immo.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class VenteController {
    @Autowired
    private VenteRepository venteRepository;
    @PostMapping("/create-vente")
    public ResponseEntity<Vente> createVente(@RequestBody Vente vente, HttpServletRequest httpServletRequest) throws URISyntaxException {

        Vente result = venteRepository.save(vente);

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
