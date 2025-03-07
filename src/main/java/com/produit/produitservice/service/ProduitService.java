package com.produit.produitservice.service;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(long id) throws Exception {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Désolé");
        }

        return optionalProduit.get();
    }

    public String deleteProduit(long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Prduit Inesistant");
        }
        produitRepository.delete(optionalProduit.get());
        return "Produit supprimé avec succès";
    }

    public Produit updateProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);

        if(optionalProduit.isEmpty()){
            throw  new RuntimeException("Modification impossible");
        }

        Produit produitAModifier = optionalProduit.get();
        produitAModifier.setName(produit.getName());
        produitAModifier.setName(String.valueOf(produit.getPrice()));

        return produitRepository.save(produitAModifier);
    }
}
