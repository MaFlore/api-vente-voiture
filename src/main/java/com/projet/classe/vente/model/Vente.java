package com.projet.classe.vente.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ventes")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_vente")
    @Temporal(TemporalType.DATE)
    private Date dateVente;

    @Column(name = "montant")
    private Double montant;

    /*Relation ManyToOne entre Vente et Client*/
    @ManyToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    /*Relation ManyToOne entre Vente et Voiture*/
    @ManyToOne()
    @JoinColumn(name = "voiture_id", referencedColumnName = "id")
    private Voiture voiture;

    /*Relation OneToMany entre Vente et Historique*/
    @OneToMany(mappedBy = "vente")
    private Set<Historique> historiques;

    public Vente() {
    }

    public Vente(Date dateVente, Double montant, Client client, Voiture voiture) {
        this.dateVente = dateVente;
        this.montant = montant;
        this.client = client;
        this.voiture = voiture;
    }

    public Long getId() {
        return id;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Set<Historique> getHistoriques() {
        return historiques;
    }

    public void setHistoriques(Set<Historique> historiques) {
        this.historiques = historiques;
    }

    @Override
    public String toString() {
        return "Vente{" +
                "dateVente=" + dateVente +
                ", montant=" + montant +
                ", client=" + client +
                ", voiture=" + voiture +
                '}';
    }
}
