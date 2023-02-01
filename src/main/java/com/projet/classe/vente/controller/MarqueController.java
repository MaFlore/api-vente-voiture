package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Historique;
import com.projet.classe.vente.model.Marque;
import com.projet.classe.vente.service.HistoriqueService;
import com.projet.classe.vente.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MarqueController {

    @Autowired
    public MarqueService marqueService;

    @Autowired
    public HistoriqueService historiqueService;

    @RequestMapping(value = "/marques", method = RequestMethod.GET)
    public List<Marque> getAllMarques() {

        List<Marque> marques = new ArrayList<>();

        try {
            marques = this.marqueService.getAll();

            Historique historique = new Historique();
            historique.setDescription("Consultation de la liste des marques");
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return marques;

    }

    @RequestMapping(value = "/marque/{id}", method = RequestMethod.GET)
    public Marque findById(@PathVariable Long id) {

        Marque marque = new Marque();

        try {
            marque = this.marqueService.findById(id);

            Historique historique = new Historique();
            historique.setDescription("Affichage de la marque " + marque.getCode());
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return marque;
    }

    @RequestMapping(value = "/marque/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Marque saveMarque(@RequestBody Marque marque) {

        try {
            marque = this.marqueService.save(marque);

            Historique historique = new Historique();
            historique.setDescription("Ajout de la marque " + marque.getCode());
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return marque;
    }

    @RequestMapping(value = "/marque/modifier", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Marque updateMarque(@RequestBody Marque marque) {

        try {
            marque = this.marqueService.update(marque);

            Historique historique = new Historique();
            historique.setDescription("Modification de la marque " + marque.getCode());
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return marque;

    }

    @RequestMapping(value = "/marque/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteMarque(@PathVariable Long id) {
        this.marqueService.deleteById(id);

        Historique historique = new Historique();
        historique.setDescription("Suppression de la marque " + id);
        historique.setDateHistorique(new Date());
        this.historiqueService.save(historique);
    }

    @RequestMapping(value = "/marque/count", method = RequestMethod.GET)
    public int countMarque(){
        int nombres = (int) this.marqueService.count();
        return nombres;
    }
}
