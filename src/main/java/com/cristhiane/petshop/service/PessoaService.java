package com.cristhiane.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristhiane.petshop.domain.Pessoa;
import com.cristhiane.petshop.repository.PessoaRepository;
import com.cristhiane.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo; // fazendo a injeção de dependência da camada de repositório
	
	public Pessoa find(Integer id) {
		// Fazendo dessa forma, lidamos de forma mais elegante com o caso de não ser retornado nada do repository, evitando o uso de try-catch
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

}
