package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Prodotto;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProdottoRepository;

@Controller
@RequestMapping("/prodotti") // Aggiunto il path "/prodotti"
public class ProdottoController {

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Mostra i prodotti nella pagina index
    @GetMapping("/")
    public String mostraProdotti(Model model) {
        List<Prodotto> prodotti = prodottoRepository.findAll();
        model.addAttribute("prodotti", prodotti);
        return "index"; // Assicurati che la vista si chiami "index.html" nella cartella templates
    }

    // Mostra la pagina about
    @GetMapping("/about")
    public String mostraAbout() {
        return "about"; // La vista about.html
    }

    // Mostra la pagina per aggiungere un prodotto (GET per il modulo)
    @GetMapping("/aggiungi")
    public String aggiungiProdottoForm(Model model) {
        List<Categoria> categorie = categoriaRepository.findAll();
        model.addAttribute("categorie", categorie); // Passa le categorie alla vista
        return "aggiungi"; // Assicurati che la vista si chiami "aggiungi.html"
    }

    // Aggiungi un prodotto (POST per invio dati del modulo)
    @PostMapping("/aggiungi")
    public String aggiungiProdotto(@RequestParam String nome,
            @RequestParam double prezzo,
            @RequestParam int quantita_disponibile,
            @RequestParam Long categoriaId) {

        Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);

        // Controlla se la categoria è valida prima di creare il prodotto
        if (categoria != null) {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(nome);
            prodotto.setPrezzo(prezzo);
            prodotto.setQuantitaDisponibile(quantita_disponibile);
            prodotto.setCategoria(categoria); // Imposta l'entità categoria nel prodotto
            prodottoRepository.save(prodotto); // Salva il nuovo prodotto nel database
        }

        // Redirige alla lista dei prodotti dopo l'aggiunta
        return "redirect:/prodotti/";
    }
}
