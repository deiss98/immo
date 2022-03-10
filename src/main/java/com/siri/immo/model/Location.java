package com.siri.immo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "products_id")
    private Products product;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "users_id")
    private Users user;
    private Date debutLocation;
    @Column(nullable = false)
    private Date finLocation;
    private double montantLocation;
    @Column(nullable = false)
    private double montantRemis;
    private double reliquat;
    @Column(nullable = false)
    private String typeLocation;
    private Date dateRestitution;
    @Column(nullable = false,  columnDefinition = "boolean default true")
    private boolean validation = false;
    private Date dateValidation;
    private double prixLocation;
    private double montantAmende;

    public Location() { super(); }

    public Location(Products product, Users user, Date debutLocation, Date finLocation, double montantLocation, double montantRemis, double reliquat, String typeLocation, Date dateRestitution, boolean validation, Date dateValidation, double prixLocation, double montantAmende) {
        this.product = product;
        this.user = user;
        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
        this.montantLocation = montantLocation;
        this.montantRemis = montantRemis;
        this.reliquat = reliquat;
        this.typeLocation = typeLocation;
        this.dateRestitution = dateRestitution;
        this.validation = validation;
        this.dateValidation = dateValidation;
        this.prixLocation = prixLocation;
        this.montantAmende = montantAmende;
    }

    public  Users getUser(){
        return user;
    }
    public void setUser(Users user){
        this.user = user;
    }

    public Products getProduct() {
        return product;
    }
    public void setProduct(Products product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDebutLocation() {
        return debutLocation;
    }

    public void setDebutLocation(Date debutLocation) {
        this.debutLocation = debutLocation;
    }

    public Date getFinLocation() {
        return finLocation;
    }

    public void setFinLocation(Date finLocation) {
        this.finLocation = finLocation;
    }

    public double getMontantLocation() {
        return montantLocation;
    }

    public void setMontantLocation(double montantLocation) {
        this.montantLocation = montantLocation;
    }

    public double getMontantRemis() {
        return montantRemis;
    }

    public void setMontantRemis(double montantRemis) {
        this.montantRemis = montantRemis;
    }

    public double getReliquat() {
        return reliquat;
    }

    public void setReliquat(double reliquat) {
        this.reliquat = reliquat;
    }

    public String getTypeLocation() {
        return typeLocation;
    }

    public void setTypeLocation(String typeLocation) {
        this.typeLocation = typeLocation;
    }

    public Date getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(Date dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public double getMontantAmende() {
        return montantAmende;
    }

    public void setMontantAmende(double montantAmende) {
        this.montantAmende = montantAmende;
    }
}
