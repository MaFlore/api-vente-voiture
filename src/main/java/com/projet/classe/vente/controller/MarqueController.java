package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Marque;
import com.projet.classe.vente.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
@CrossOrigin(value = "*")
public class MarqueController {

    @Autowired
    public MarqueService marqueService;

    @RequestMapping(value = "/marques", method = RequestMethod.GET)
    public List<Marque> getAllMarques() {

        List<Marque> marques = new ArrayList<>();

        try {
            marques = this.marqueService.getAll();
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
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return marque;
    }

    @RequestMapping(value = "/marque/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Marque saveMarque(@RequestBody Marque marque) {

        try {
            marque = this.marqueService.save(marque);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return marque;
    }

    @RequestMapping(value = "/marque/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Marque updateMarque(@RequestBody Marque marque) {

        try {
            marque = this.marqueService.update(marque);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return marque;

    }

    @RequestMapping(value = "/marque/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteMarque(@PathVariable Long id) {
        this.marqueService.deleteById(id);
    }
}
