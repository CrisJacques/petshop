package com.cristhiane.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristhiane.petshop.domain.Servico;
import com.cristhiane.petshop.repository.ServicoRepository;
import com.cristhiane.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo; // fazendo a injeção de dependência da camada de repositório
	
	public Servico find(Integer id) {
		// Fazendo dessa forma, lidamos de forma mais elegante com o caso de não ser retornado nada do repository, evitando o uso de try-catch
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + ", Tipo: " + Servico.class.getName()));
	}

}
