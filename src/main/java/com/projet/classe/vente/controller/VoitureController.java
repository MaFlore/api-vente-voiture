package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Voiture;
import com.projet.classe.vente.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VoitureController {

    @Autowired
    public VoitureService voitureService;

    @RequestMapping(value = "/voitures/statuts", method = RequestMethod.GET)
    public List<Voiture> getAllVoituresByStatut() {

        List<Voiture> voitures = new ArrayList<>();

        try {
            voitures = this.voitureService.findByStatut(true);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return voitures;

    }
    @RequestMapping(value = "/voitures", method = RequestMethod.GET)
    public List<Voiture> getAllVoitures() {

        List<Voiture> voitures = new ArrayList<>();

        try {
            voitures = this.voitureService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return voitures;

    }

    @RequestMapping(value = "/voiture/{id}", method = RequestMethod.GET)
    public Voiture findById(@PathVariable Long id) {

        Voiture voiture = new Voiture();

        try {
            voiture = this.voitureService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return voiture;
    }

    @RequestMapping(value = "/voiture/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Voiture saveVoiture(@RequestBody Voiture voiture) {

        try {
            voiture.setStatut(true);
            voiture = this.voitureService.save(voiture);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return voiture;
    }

    @RequestMapping(value = "/voiture/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Voiture updateVoiture(@RequestBody Voiture voiture) {

        try {
            voiture = this.voitureService.update(voiture);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return voiture;

    }

    @RequestMapping(value = "/voiture/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteVoiture(@PathVariable Long id) {
        this.voitureService.deleteById(id);
    }
}
