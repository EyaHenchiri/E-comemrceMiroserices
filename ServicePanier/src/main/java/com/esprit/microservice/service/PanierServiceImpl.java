package com.esprit.microservice.service;

import com.esprit.microservice.model.Panier;
import com.esprit.microservice.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierServiceImpl implements PanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Override
    public void createPanier(Panier panier) {
        panierRepository.save(panier);
    }

    @Override
    public void addProductToPanier(Long idProduct, Long idPanier) {
        Panier panier = panierRepository.findById(idPanier).get();
        panier.setIdProduit(idProduct);
        panierRepository.save(panier);
    }
        


    @Override
    public void removeProductFromPanier(Long idProduct, Long idPanier) {
        Panier panier = panierRepository.findById(idPanier).get();
        panier.setIdProduit(null);
        panierRepository.save(panier);
    }

    @Override
    public void addProductToPanier(Long idProduct, Long idPanier, int total) {
        Panier panier = panierRepository.findById(idPanier).get();
        panier.setIdProduit(idProduct);
        panier.setTotal(total);
        panierRepository.save(panier);
    }

    @Override
    public void removeProductFromPanier(Long idProduct, Long idPanier, int total) {
        Panier panier = panierRepository.findById(idPanier).get();
        panier.setIdProduit(null);
        panier.setTotal(total);
        panierRepository.save(panier);
    }

    @Override
    public List<Panier> getAllPaniers() {
        return (List<Panier>) panierRepository.findAll();
    }

    @Override
    public Panier getPanierById(Long idPanier) {
        Panier panier = panierRepository.findById(idPanier).isPresent() ? panierRepository.findById(idPanier).get() : null;
        return panier;
    }

    @Override
    public void getPanierByUserId(Long idUser) {

    }

    @Override
    public Panier getPanierByProductId(Long idProduct) {
        return null;
    }

    @Override
    public void deletePanierById(Long idPanier) {
        panierRepository.deleteById(idPanier);
    }

    @Override
    public void updatePanier(Long idPanier, Panier panier) {
        Panier panier1 = panierRepository.findById(idPanier).get();
        panier1.setIdProduit(panier.getIdProduit());
        panier1.setTotal(panier.getTotal());
        panierRepository.save(panier1);
    }

}

