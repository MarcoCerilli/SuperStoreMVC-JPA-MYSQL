package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categorie")
public class CategoriaRestController {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaRestController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Recupera tutte le categorie
    @GetMapping
    public List<Categoria> getAllCategorie() {
        return categoriaRepository.findAll();
    }

    // Crea una nuova categoria
    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Restituisce errore se il nome è vuoto
        }

        Categoria categoriaSalvata = categoriaRepository.save(categoria);
        return new ResponseEntity<>(categoriaSalvata, HttpStatus.CREATED); // Restituisce un 201 per la creazione
    }
}
