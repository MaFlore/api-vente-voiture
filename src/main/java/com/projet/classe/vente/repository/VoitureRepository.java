package com.projet.classe.vente.repository;

import com.projet.classe.vente.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    public List<Voiture> findByStatut(Boolean statut);
}
