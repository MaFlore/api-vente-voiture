package com.projet.classe.vente.service;

import com.projet.classe.vente.model.Marque;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarqueService {

    public List<Marque> getAll();
    public Marque findById(Long id);
    public Marque save(Marque marque);
    public Marque update(Marque marque);
    public void deleteById(Long id);
    public long count();
}
