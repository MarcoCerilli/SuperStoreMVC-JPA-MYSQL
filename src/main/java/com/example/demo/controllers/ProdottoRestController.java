package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Prodotto;
import com.example.demo.repository.ProdottoRepository;



@RestController
@RequestMapping("/api/prodotti")
public class ProdottoRestController {

	@Autowired
	private ProdottoRepository prodottoRepository;
	
	@GetMapping
	public List <Prodotto> getAllProdottiList(){
		return prodottoRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Prodotto getProdottoById(@PathVariable Long id) {
		return prodottoRepository.findById(id).orElse(null);
					
	}
	
	@PostMapping("/saveAll")
	public  List<Prodotto> saveProdotti(@RequestBody List<Prodotto> prodotti) {
	    return prodottoRepository.saveAll(prodotti);
	
		
	}
	
	@PutMapping("/{id}")
	public Prodotto updateProdotto( @PathVariable Long id, @RequestBody Prodotto prodotto) {
		prodotto.setId(id);
		return prodottoRepository.save(prodotto); 
		
	}
	
	 @DeleteMapping("/{id}")
	  public void deleteProdotto(@PathVariable Long id ) {
		 prodottoRepository.deleteById(id); 
		 
		 
	 }
	
	
	
	
	
}
