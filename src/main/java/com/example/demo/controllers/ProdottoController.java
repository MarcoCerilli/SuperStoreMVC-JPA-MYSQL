package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Prodotto;
import com.example.demo.repository.ProdottoRepository;

@Controller
public class ProdottoController {
    @Autowired
    private ProdottoRepository prodottoRepository;

    @GetMapping("/")
    public String mostraProdotti(Model model) {
        List<Prodotto> prodotti = prodottoRepository.findAll();
        model.addAttribute("prodotti", prodotti);
        return "index";
    }
    @GetMapping("/about")
    public String mostraAbout() {
    	return "about";
    }
    
    	
    
    
}


