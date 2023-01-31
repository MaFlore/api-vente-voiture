package com.projet.classe.vente.serviceImpl;

import com.projet.classe.vente.model.Marque;
import com.projet.classe.vente.repository.MarqueRepository;
import com.projet.classe.vente.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueServiceImpl implements MarqueService {

    @Autowired
    public MarqueRepository marqueRepository;

    @Override
    public List<Marque> getAll() {
        return this.marqueRepository.findAll();
    }

    @Override
    public Marque findById(Long id) {
        return this.marqueRepository.findById(id).orElse(null);
    }

    @Override
    public Marque save(Marque marque) {
        return this.marqueRepository.save(marque);
    }

    @Override
    public Marque update(Marque marque) {
        return this.marqueRepository.save(marque);
    }

    @Override
    public void deleteById(Long id) {
        this.marqueRepository.deleteById(id);
    }

    @Override
    public void count() {
        this.marqueRepository.count();
    }
}
