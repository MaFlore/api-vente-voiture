package com.projet.classe.vente.serviceImpl;

import com.projet.classe.vente.model.Vente;
import com.projet.classe.vente.repository.VenteRepository;
import com.projet.classe.vente.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteServiceImpl implements VenteService {

    @Autowired
    public VenteRepository venteRepository;

    @Override
    public List<Vente> getAll() {
        return this.venteRepository.findAll();
    }

    @Override
    public Vente findById(Long id) {
        return this.venteRepository.findById(id).orElse(null);
    }

    @Override
    public Vente save(Vente vente) {
        return this.venteRepository.save(vente);
    }

    @Override
    public Vente update(Vente vente) {
        return this.venteRepository.save(vente);
    }

    @Override
    public void deleteById(Long id) {
        this.venteRepository.deleteById(id);
    }

    @Override
    public void count() {
        this.venteRepository.count();
    }
}
