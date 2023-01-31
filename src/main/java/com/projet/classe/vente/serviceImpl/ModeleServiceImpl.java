package com.projet.classe.vente.serviceImpl;

import com.projet.classe.vente.model.Modele;
import com.projet.classe.vente.repository.ModeleRepository;
import com.projet.classe.vente.service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleServiceImpl implements ModeleService {

    @Autowired
    public ModeleRepository modeleRepository;

    @Override
    public List<Modele> getAll() {
        return this.modeleRepository.findAll();
    }

    @Override
    public Modele findById(Long id) {
        return this.modeleRepository.findById(id).orElse(null);
    }

    @Override
    public Modele save(Modele modele) {
        return this.modeleRepository.save(modele);
    }

    @Override
    public Modele update(Modele modele) {
        return this.modeleRepository.save(modele);
    }

    @Override
    public void deleteById(Long id) {
        this.modeleRepository.deleteById(id);
    }

    @Override
    public void count() {
        this.modeleRepository.count();
    }
}
