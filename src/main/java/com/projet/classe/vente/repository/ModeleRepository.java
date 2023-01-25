package com.projet.classe.vente.repository;

import com.projet.classe.vente.model.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleRepository extends JpaRepository<Modele, Long> {
}
