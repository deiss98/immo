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
    private Date finLocation;
    private double montantLocation;
    private Date dateRestitution;

    public Location() { super(); }

    public Location(Products product, Users user, Date debutLocation, Date finLocation, double montantLocation, Date dateRestitution){
        this.product = product;
        this.user = user;
        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
        this.montantLocation = montantLocation;
        this.dateRestitution = dateRestitution;
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

    public Date getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(Date dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

}
