package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Prodotto;


@Repository
public interface ProdottoRepository  extends JpaRepository<Prodotto, Long>{

    List<Prodotto> findByCategoriaId(Long categoriaId);

    List<Prodotto> findByCategoriaIdAndPrezzoLessThan(Long categoriaId, double prezzo);

	
	
	
}
