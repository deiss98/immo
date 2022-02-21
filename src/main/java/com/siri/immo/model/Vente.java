package com.siri.immo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vente {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "products_id")
    private Products prod;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "users_id")
    private Users acheteur;
    private Date datevente;

    public Vente() {super();}

    public Vente(Products prod, Users acheteur, Date datevente) {
        this.prod = prod;
        this.acheteur = acheteur;
        this.datevente = datevente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Products getProd() {
        return prod;
    }

    public void setProd(Products prod) {
        this.prod = prod;
    }

    public Users getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(Users acheteur) {
        this.acheteur = acheteur;
    }

    public Date getDatevente() {
        return datevente;
    }

    public void setDatevente(Date datevente) {
        this.datevente = datevente;
    }

}
