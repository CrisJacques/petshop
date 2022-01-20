package com.cristhiane.petshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cristhiane.petshop.domain.Servico;
import com.cristhiane.petshop.service.ServicoService;

@RestController // marcando a classe como um controlador REST (o Spring exige isso)
@RequestMapping(value = "/servicos") // mapeamento de qual a URL deve ser chamada
public class ServicoResource {
	
	@Autowired
	ServicoService service; // fazendo a injeção de dependência da classe de serviço

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)// quando eu fizer um GET /Servicos/id, o fluxo vem pra esse método aqui embaixo
	public ResponseEntity<?> find(@PathVariable Integer id) {// @PathVariable permite pegar o id que veio da URL e passar para dentro do método
		// o <?> depois do ResponseEntity quer dizer que qualquer tipo de objeto pode ser retornado
		// o ResponseEntity permite devolver para o cliente uma resposta mais completa
		
		Servico obj = service.find(id);
		
		return ResponseEntity.ok().body(obj); // se deu tudo certo, retorna o obj dentro da resposta da requisição
	}
}
