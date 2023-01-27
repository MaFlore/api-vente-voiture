package com.projet.classe.vente.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historiques")
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "date_historique")
    @Temporal(TemporalType.DATE)
    private Date dateHistorique;

    public Historique() {
    }

    public Historique(String description, Date dateHistorique, Vente vente) {
        this.description = description;
        this.dateHistorique = dateHistorique;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateHistorique() {
        return dateHistorique;
    }

    public void setDateHistorique(Date dateHistorique) {
        this.dateHistorique = dateHistorique;
    }

    @Override
    public String toString() {
        return "Historique{" +
                "description='" + description + '\'' +
                ", dateHistorique=" + dateHistorique +
                '}';
    }
}
