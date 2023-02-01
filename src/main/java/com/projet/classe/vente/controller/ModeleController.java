package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Modele;
import com.projet.classe.vente.service.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ModeleController {

    @Autowired
    public ModeleService modeleService;
    @RequestMapping(value = "/modeles", method = RequestMethod.GET)
    public List<Modele> getAllModeles() {

        List<Modele> modeles = new ArrayList<>();

        try {
            modeles = this.modeleService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return modeles;

    }

    @RequestMapping(value = "/modele/{id}", method = RequestMethod.GET)
    public Modele getOneModele(@PathVariable Long id) {

        Modele modele = new Modele();

        try {
            modele = this.modeleService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return modele;
    }

    @RequestMapping(value = "/modele/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Modele saveModele(@RequestBody Modele modele) {

        try {
            modele = this.modeleService.save(modele);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return modele;
    }

    @RequestMapping(value = "/modele/modifier", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Modele updateModele(@RequestBody Modele modele) {

        try {
            modele = this.modeleService.update(modele);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return modele;

    }

    @RequestMapping(value = "/modele/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteModele(@PathVariable Long id) {
        this.modeleService.deleteById(id);
    }

    @RequestMapping(value = "/modele/count", method = RequestMethod.GET)
    public int countModele(){
        int nombres = (int) this.modeleService.count();
        return nombres;
    }
}
