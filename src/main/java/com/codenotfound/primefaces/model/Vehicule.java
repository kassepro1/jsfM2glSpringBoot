package com.codenotfound.primefaces.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;


@Entity(name = "Vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 25)
    private String matricule;
    @NotNull
    @Column(length = 25)
    private String marque;
    @NotNull
    @Column(length = 25)
    private String model;
    @NotNull
    @Column(length = 25)
    private String couleur;
    @NotNull
    private int prixjour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getPrixjour() {
        return prixjour;
    }

    public void setPrixjour(int prixjour) {
        this.prixjour = prixjour;
    }

    public Vehicule() {
    }

    public Vehicule(String matricule, String marque, String model, String couleur, int prixjour) {
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.couleur = couleur;
        this.prixjour = prixjour;
    }
}
