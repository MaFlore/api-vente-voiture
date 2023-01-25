package com.projet.classe.vente.serviceImpl;

import com.projet.classe.vente.model.Voiture;
import com.projet.classe.vente.repository.VoitureRepository;
import com.projet.classe.vente.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {

    @Autowired
    public VoitureRepository voitureRepository;

    @Override
    public List<Voiture> getAll() {
        return null;
    }

    @Override
    public Voiture findById(Long id) {
        return null;
    }

    @Override
    public Voiture save(Voiture voiture) {
        return null;
    }

    @Override
    public Voiture update(Voiture voiture) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
