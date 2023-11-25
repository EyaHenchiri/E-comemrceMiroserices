package com.esprit.microservice.service;

import com.esprit.microservice.model.Panier;

import java.util.List;

public interface PanierService {
    void createPanier(Panier panier);
    void updatePanier(Long idPanier, Panier panier);
    public void addProductToPanier(Long idProduct, Long idPanier);
    public void removeProductFromPanier(Long idProduct, Long idPanier);
    public void addProductToPanier(Long idProduct, Long idPanier, int quantity);
    public void removeProductFromPanier(Long idProduct, Long idPanier, int quantity);
    public List<Panier> getAllPaniers();
    public Panier getPanierById(Long idPanier);
    public void getPanierByUserId(Long idUser);
    public Panier getPanierByProductId(Long idProduct);
    public void deletePanierById(Long idPanier);


}
