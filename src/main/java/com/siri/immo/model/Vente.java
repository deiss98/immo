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
    private Users  acheteur;
    private Date   datevente;
    private double montantRemis;
    private double reliquat;
    @Column(nullable = false,  columnDefinition = "boolean default true")
    private boolean validation = false;
    private Date dateValidation;

    public Vente() {super();}

    public Vente(Products prod, Users acheteur, Date datevente, double montantRemis, double reliquat, boolean validation, Date dateValidation) {
        this.prod = prod;
        this.acheteur = acheteur;
        this.datevente = datevente;
        this.montantRemis = montantRemis;
        this.reliquat = reliquat;
        this.validation = validation;
        this.dateValidation = dateValidation;
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

    public double getMontantRemis() {
        return montantRemis;
    }

    public void setMontantRemis(double montantRemis) {
        this.montantRemis = montantRemis;
    }

    public double getReliquat() {
        return reliquat;
    }

    public void setReliquat(double reliquat) {this.reliquat = reliquat; }

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
}
