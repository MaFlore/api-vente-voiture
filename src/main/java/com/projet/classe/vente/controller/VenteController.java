package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Vente;
import com.projet.classe.vente.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(name = "/api")
@CrossOrigin(value = "*")
public class VenteController {

    @Autowired
    public VenteService venteService;

    @RequestMapping(value = "/ventes", method = RequestMethod.GET)
    public List<Vente> getAllVentes() {

        List<Vente> ventes = new ArrayList<>();

        try {
            ventes = this.venteService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return ventes;

    }

    @RequestMapping(value = "/vente/{id}", method = RequestMethod.GET)
    public Vente findById(@PathVariable Long id) {

        Vente vente = new Vente();

        try {
            vente = this.venteService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return vente;
    }

    @RequestMapping(value = "/vente/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Vente saveVente(@RequestBody Vente vente) {

        try {
            vente = this.venteService.save(vente);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return vente;
    }

    @RequestMapping(value = "/vente/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Vente updateVente(@RequestBody Vente vente) {

        try {
            vente = this.venteService.update(vente);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return vente;

    }

    @RequestMapping(value = "/vente/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteVente(@PathVariable Long id) {
        this.venteService.deleteById(id);
    }
}
