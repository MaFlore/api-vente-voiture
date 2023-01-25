package com.projet.classe.vente.service;

import com.projet.classe.vente.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    public List<Client> getAll();
    public Client findById(Long id);
    public Client save(Client client);
    public Client update(Client client);
    public void deleteById(Long id);
}
