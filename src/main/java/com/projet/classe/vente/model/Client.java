package com.projet.classe.vente.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
@DiscriminatorValue(value = "Client")
public class Client extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    /*Relation OneToMany entre Client et Vente*/
    @OneToMany(mappedBy = "client")
    private Set<Vente> ventes;

    public Client() {
    }

    public Client(String nom, String prenom, String telephone, String username, String password) {
        super(nom, prenom, telephone, username, password);
    }

    @Override
    public Long getId() {
        return id;
    }

    public Set<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(Set<Vente> ventes) {
        this.ventes = ventes;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
