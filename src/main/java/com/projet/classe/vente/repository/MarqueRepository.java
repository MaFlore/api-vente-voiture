package com.projet.classe.vente.repository;

import com.projet.classe.vente.model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Long> {
}
