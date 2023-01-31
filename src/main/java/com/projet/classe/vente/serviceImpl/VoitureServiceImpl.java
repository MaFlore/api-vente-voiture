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
         return this.voitureRepository.findAll();
    }

    public List<Voiture> findByStatut(Boolean statut){
        return this.voitureRepository.findByStatut(statut);
    }
    @Override
    public Voiture findById(Long id) {
        return this.voitureRepository.findById(id).orElse(null)    ;
    }

    @Override
    public Voiture save(Voiture voiture) {
        return this.voitureRepository.save(voiture);
    }

    @Override
    public Voiture update(Voiture voiture) {
        return this.voitureRepository.save(voiture);
    }

    @Override
    public void deleteById(Long id) {
        this.voitureRepository.deleteById(id);
    }

    @Override
    public long count() {
        return this.voitureRepository.count();
    }
}
