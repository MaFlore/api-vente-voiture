package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Historique;
import com.projet.classe.vente.model.Voiture;
import com.projet.classe.vente.service.HistoriqueService;
import com.projet.classe.vente.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VoitureController {

    @Autowired
    public VoitureService voitureService;

    @Autowired
    public HistoriqueService historiqueService;

    @RequestMapping(value = "/voitures", method = RequestMethod.GET)
    public List<Voiture> getAllVoitures() {

        List<Voiture> voitures = new ArrayList<>();

        try {
            voitures = this.voitureService.getAll();

            Historique historique = new Historique();
            historique.setDescription("Consultation de la liste des voitures");
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
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

            Historique historique = new Historique();
            historique.setDescription("Affichage de la voiture " + voiture.getNumeroIdentifiant());
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
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

            Historique historique = new Historique();
            historique.setDescription("Ajout de la voiture " + voiture.getNumeroIdentifiant());
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return voiture;
    }

    @RequestMapping(value = "/voiture/modifier", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Voiture updateVoiture(@RequestBody Voiture voiture) {

        try {
            voiture = this.voitureService.update(voiture);

            Historique historique = new Historique();
            historique.setDescription("Modification de la voiture " + voiture.getNumeroIdentifiant());
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return voiture;

    }

    @RequestMapping(value = "/voiture/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteVoiture(@PathVariable Long id) {
        this.voitureService.deleteById(id);

        Historique historique = new Historique();
        historique.setDescription("Suppression de la voiture " + id);
        historique.setDateHistorique(new Date());
        this.historiqueService.save(historique);
    }

    @RequestMapping(value = "/voiture/count", method = RequestMethod.GET)
    public int countVoiture(){
        int nombres = (int) this.voitureService.count();
        return nombres;
    }
}
