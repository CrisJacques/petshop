package com.cristhiane.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cristhiane.petshop.domain.Pessoa;
import com.cristhiane.petshop.repository.PessoaRepository;
import com.cristhiane.petshop.service.exceptions.DataIntegrityException;
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
	
	public Pessoa insert(Pessoa obj) {
		obj.setId(null); // tanto o POST quanto o PUT usarão em seus services o save para gravar no banco de dados; a diferença é que no POST a gente tem que garantir que o id do objeto seja nulo para que ele seja inserido no banco
		return repo.save(obj); //quando formos implementar o service do PUT usaremos o save também
	}
	
	public Pessoa update(Pessoa obj) {
		find(obj.getId()); // antes de pedir pro repository salvar, é preciso verificar se o registro existe: aqui reutilizamos o método find, criado logo acima, que já retorna uma exceção se não achar o objeto
		return repo.save(obj); // se não estourar exceção ali em cima, o objeto existe, então é só mandar salvar no banco
	}
	
	public void delete(Integer id) {
		find(id); // antes de pedir pro repository salvar, é preciso verificar se o registro existe: aqui reutilizamos o método find, criado logo acima, que já retorna uma exceção se não achar o objeto
		try {
			repo.deleteById(id); // se não estourar exceção ali em cima, o objeto existe, então é só mandar deletar do banco (caso não dê exceção aqui dentro)
		} catch (DataIntegrityViolationException e) {// DataIntegrityViolationException é a exceção lançada quando se tenta deletar uma Pessoa
			throw new DataIntegrityException("Pessoa não pode ser deletada!");
		}
		
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}

}
