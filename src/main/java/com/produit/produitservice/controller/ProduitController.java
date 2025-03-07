package com.produit.produitservice.controller;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import com.produit.produitservice.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @GetMapping("/")
    public String sayWelcome() {
        return "Welcome to Produit Service";
    }

    @GetMapping("/all_produits")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduit();
    }

    @PostMapping("/produits")
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.createProduit(produit);
    }

    @GetMapping("produit/{id}")
    public Produit getProduitById(@PathVariable long id) throws Exception {
        return produitService.getProduitById(id);
    }

    @DeleteMapping("produit/{id}")
    public String deleteProduitById(@PathVariable long id){
        return produitService.deleteProduit(id);
    }

    @PutMapping("produit/{id}")
    public Produit updateProduit(@PathVariable long id,@RequestBody Produit produit){
        return produitService.updateProduit(id,produit);
    }
}
