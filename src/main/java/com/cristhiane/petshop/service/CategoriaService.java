package com.cristhiane.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristhiane.petshop.domain.Categoria;
import com.cristhiane.petshop.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo; // fazendo a injeção de dependência da camada de repositório
	
	public Categoria find(Integer id) {
		// Fazendo dessa forma, lidamos de forma mais elegante com o caso de não ser retornado nada do repository, evitando o uso de try-catch
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null); // se nada for retornado do repository, será retornado null (é o Optional ali em cima que possibilita o uso desse método)
	}

}
