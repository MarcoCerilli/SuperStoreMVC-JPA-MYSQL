package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Prodotto;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProdottoRepository;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoRestController {

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired 
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Prodotto> getAllProdottiList() {
        return prodottoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prodotto> getProdottoById(@PathVariable Long id) {
        return prodottoRepository.findById(id)
                .map(prod -> ResponseEntity.ok().body(prod))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<Prodotto>> saveProdotti(@RequestBody List<Prodotto> prodotti) {
        return new ResponseEntity<>(prodottoRepository.saveAll(prodotti), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prodotto> updateProdotto(@PathVariable Long id, @RequestBody Prodotto prodotto) {
        if (!prodottoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prodotto.setId(id);
        return ResponseEntity.ok(prodottoRepository.save(prodotto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdotto(@PathVariable Long id) {
        if (!prodottoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        prodottoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Salva un prodotto associato a una categoria
    @PostMapping("/categoria/{categoriaId}")
    public ResponseEntity<Prodotto> saveProdottoConCategoria(@RequestBody Prodotto prodotto, @PathVariable Long categoriaId) {
        return categoriaRepository.findById(categoriaId)
                .map(categoria -> {
                    prodotto.setCategoria(categoria);
                    return new ResponseEntity<>(prodottoRepository.save(prodotto), HttpStatus.CREATED);
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
    // Recupera tutti i prodotti di una categoria
    @GetMapping("/categoria/{categoriaId}")
    public List<Prodotto> getProdottiByCategoria(@PathVariable Long categoriaId) {
        return prodottoRepository.findByCategoriaId(categoriaId);
    }
}
