package com.projet.classe.vente.model;

import javax.persistence.*;

@Entity
@Table(name = "personnes")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_personne")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "prenom")
    protected String prenom;

    @Column(name = "telephone", nullable = false, unique = true)
    protected String telephone;

    @Column(name = "username")
    protected String username;

    @Column(name = "password")
    protected String password;

    public Personne() {
    }

    public Personne(String nom, String prenom, String telephone, String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
