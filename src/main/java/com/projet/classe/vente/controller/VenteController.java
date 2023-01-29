package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Historique;
import com.projet.classe.vente.model.Vente;
import com.projet.classe.vente.model.Voiture;
import com.projet.classe.vente.service.HistoriqueService;
import com.projet.classe.vente.service.VenteService;
import com.projet.classe.vente.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VenteController {

    @Autowired
    public VenteService venteService;

    @Autowired
    public VoitureService voitureService;

    @Autowired
    public HistoriqueService historiqueService;

    public Historique historique;

    @RequestMapping(value = "/ventes", method = RequestMethod.GET)
    public List<Vente> getAllVentes() {

        List<Vente> ventes = new ArrayList<>();

        try {
            ventes = this.venteService.getAll();

            historique.setDescription("Consultation de la liste des ventes");
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
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

            historique.setDescription("Affichage de la vente " + vente.getId());
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return vente;
    }

    @RequestMapping(value = "/vente/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Vente saveVente(@RequestBody Vente vente) {

        try {
            Voiture voiture = vente.getVoiture();
            voiture = this.voitureService.findById(voiture.getId());
            voiture.setCouleur(voiture.getCouleur());
            voiture.setDateAchat(voiture.getDateAchat());
            voiture.setMarque(voiture.getMarque());
            voiture.setModele(voiture.getModele());
            voiture.setNumeroIdentifiant(voiture.getNumeroIdentifiant());
            voiture.setNumeroSerie(voiture.getNumeroSerie());
            voiture.setStatut(false);
            this.voitureService.save(voiture);
            vente.setVoiture(voiture);
            vente = this.venteService.save(vente);

            historique.setDescription("Ajout de la vente " + vente.getId());
            historique.setDateHistorique(new Date());
            this.historiqueService.save(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return vente;
    }

    @RequestMapping(value = "/vente/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteVente(@PathVariable Long id) {
        this.venteService.deleteById(id);
        historique.setDescription("Suppression de la vente : " + id);
        historique.setDateHistorique(new Date());
        this.historiqueService.save(historique);
    }
}
