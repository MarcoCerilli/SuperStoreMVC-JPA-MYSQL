package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @JsonManagedReference
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prodotto> prodotti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

}

/*
 * @OneToMany(mappedBy = "categoria") → Significa che una categoria può avere
 * molti prodotti.
 * mappedBy = "categoria" → Indica che la relazione è mappata dal campo
 * categoria della classe Prodotto.
 * 
 * cascade = CascadeType.ALL → Se elimini una categoria, elimina anche i
 * prodotti associati.
 * 
 * orphanRemoval = true → Se rimuovi un prodotto dalla lista, viene eliminato
 * dal database.
 * 
 * @Column(nullable = false, unique = true) → Ogni categoria ha un nome univoco.
 * 
 */
