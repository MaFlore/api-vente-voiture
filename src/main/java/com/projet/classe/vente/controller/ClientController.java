package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Client;
import com.projet.classe.vente.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    public ClientService clientService;
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> getAllClients() {

        List<Client> clients = new ArrayList<>();

        try {
            clients = this.clientService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return clients;

    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public Client findById(@PathVariable Long id) {

        Client client = new Client();

        try {
            client = this.clientService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return client;
    }

    @RequestMapping(value = "/client/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Client saveClient(@RequestBody Client client) {

        try {
            client = this.clientService.save(client);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return client;
    }

    @RequestMapping(value = "/client/modifier", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Client updateClient(@RequestBody Client client) {

        try {
            client = this.clientService.update(client);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return client;

    }

    @RequestMapping(value = "/client/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteClient(@PathVariable Long id) {
        this.clientService.deleteById(id);
    }

    @RequestMapping(value = "/client/count", method = RequestMethod.GET)
    public int countClient(){
        int nombres = (int) this.clientService.count();
        return nombres;
    }
}
