package com.projet.classe.vente.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "voitures")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numero_identifiant")
    private String numeroIdentifiant;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "date_achat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    @Column(name = "couleur")
    private String couleur;

    @Column(name = "statut")
    private Boolean statut;

    /*Relation ManyToOne entre Voiture et Modele*/
    @ManyToOne()
    @JoinColumn(name = "modele_id", referencedColumnName = "id")
    private Modele modele;

    /*Relation ManyToOne entre Voiture et Marque*/
    @ManyToOne()
    @JoinColumn(name = "marque_id", referencedColumnName = "id")
    private Marque marque;

    /**Relation OneToMany entre Voiture et Vente*/
    @OneToMany(mappedBy = "voiture")
    private Set<Vente> ventes;

    public Voiture() {
    }

    public Voiture(String numeroIdentifiant, String numeroSerie, Date dateAchat, String couleur, Boolean statut, Modele modele, Marque marque) {
        this.numeroIdentifiant = numeroIdentifiant;
        this.numeroSerie = numeroSerie;
        this.dateAchat = dateAchat;
        this.couleur = couleur;
        this.statut = statut;
        this.modele = modele;
        this.marque = marque;
    }

    public Long getId() {
        return id;
    }

    public String getNumeroIdentifiant() {
        return numeroIdentifiant;
    }

    public void setNumeroIdentifiant(String numeroIdentifiant) {
        this.numeroIdentifiant = numeroIdentifiant;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Boolean getStatut() {
        return statut;
    }

    public Boolean setStatut(Boolean statut) {
        return this.statut = statut;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Set<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(Set<Vente> ventes) {
        this.ventes = ventes;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "numeroIdentifiant='" + numeroIdentifiant + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", dateAchat=" + dateAchat +
                ", couleur='" + couleur + '\'' +
                ", statut=" + statut +
                ", modele=" + modele +
                ", marque=" + marque +
                '}';
    }
}
