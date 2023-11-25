package com.esprit.microservice.model;

import javax.persistence.*;

@Entity
public class Panier implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    private Long id;
    @Column(name = "id_user", nullable = true)
    private Long idUser;
    @Column(name = "id_produit", nullable = true)
    private Long idProduit;
    @Column(name = "total", nullable = true)
    private int total;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
