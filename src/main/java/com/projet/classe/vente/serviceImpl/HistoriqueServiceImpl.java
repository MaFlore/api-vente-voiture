package com.projet.classe.vente.serviceImpl;

import com.projet.classe.vente.model.Historique;
import com.projet.classe.vente.repository.HistoriqueRepository;
import com.projet.classe.vente.service.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {

    @Autowired
    public HistoriqueRepository historiqueRepository;

    @Override
    public List<Historique> getAll() {
        return this.historiqueRepository.findAll();
    }

    @Override
    public Historique findById(Long id) {
        return this.historiqueRepository.findById(id).orElse(null);
    }

    @Override
    public Historique save(Historique historique) {
        return this.historiqueRepository.save(historique);
    }

    @Override
    public Historique update(Historique historique) {
        return this.historiqueRepository.save(historique);
    }

    @Override
    public void deleteById(Long id) {
        this.historiqueRepository.deleteById(id);
    }
}
