package com.siri.immo.model;

import javax.persistence.*;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private  ERoles nomRoles;

    public Roles() { super();}

    public Roles(ERoles nomRoles) {
        this.nomRoles = nomRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERoles getNomRoles() {
        return nomRoles;
    }

    public void setNomRoles(ERoles nomRoles) {
        this.nomRoles = nomRoles;
    }
}
