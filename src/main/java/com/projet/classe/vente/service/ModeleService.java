package com.projet.classe.vente.service;

import com.projet.classe.vente.model.Modele;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModeleService {

    public List<Modele> getAll();
    public Modele findById(Long id);
    public Modele save(Modele modele);
    public Modele update(Modele modele);
    public void deleteById(Long id);
    public long count();
}
