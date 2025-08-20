package com.example.OrganaEvent.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; //Importe les annotations JPA

@Entity //table
public class employe {

    @Id //cle primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) //comment le cle primaire generee
    private Long id;

    private String nom;
    private String email;
    private String motDePasse;
    private String poste;

    @ManyToOne  //genere une relation avec une autre entite
    private entreprise entreprise; //on stocke une référence à une instance Entreprise pour savoir à quelle entreprise appartient cet employé.

    // Constructeur vide (obligatoire pour JPA)
    public employe() {
    } //Permet à la bibliothèque de créer un objet Employe vide avant de remplir les champs.



    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
