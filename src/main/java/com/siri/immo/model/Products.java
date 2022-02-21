package com.siri.immo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Products {
    @Id
    @GeneratedValue
    private Long id;
    private String libelle;
    private String type;
    private double prix;
    private String description;
    private  String photo;
    private String statut;
    private Date dateAjout;
    private Date dateModification;


    public Products() {
        super();
    }

    public Products(String libelle, String type, double prix, String description, String photo, String statut, Date dateAjout, Date dateModification) {
        this.libelle = libelle;
        this.type = type;
        this.prix = prix;
        this.description = description;
        this.photo = photo;
        this.statut = statut;
        this.dateAjout = dateAjout;
        this.dateModification = dateModification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
