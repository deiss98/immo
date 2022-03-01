package com.siri.immo.repository;


import com.siri.immo.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    List<Products> findAllByTypeAndStatut(String type, String statut);
}
