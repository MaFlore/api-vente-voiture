package com.projet.classe.vente.service;

import com.projet.classe.vente.model.Voiture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoitureService {

    public List<Voiture> getAll();
    public List<Voiture> findByStatut(Boolean statut);
    public Voiture findById(Long id);
    public Voiture save(Voiture voiture);
    public Voiture update(Voiture voiture);
    public void deleteById(Long id);
}
