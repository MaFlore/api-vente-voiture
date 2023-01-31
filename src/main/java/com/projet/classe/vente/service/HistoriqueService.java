package com.projet.classe.vente.service;

import com.projet.classe.vente.model.Historique;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoriqueService {

    public List<Historique> getAll();
    public Historique findById(Long id);
    public Historique save(Historique historique);
    public Historique update(Historique historique);
    public void deleteById(Long id);
    public void count();
}
