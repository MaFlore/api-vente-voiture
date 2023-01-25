package com.projet.classe.vente.service;

import com.projet.classe.vente.model.Vente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VenteService {

    public List<Vente> getAll();
    public Vente findById(Long id);
    public Vente save(Vente vente);
    public Vente update(Vente vente);
    public void deleteById(Long id);
}
