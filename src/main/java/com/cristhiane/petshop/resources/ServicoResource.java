package com.cristhiane.petshop.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method = RequestMethod.POST)// quando eu fizer um POST /Servicos/, o fluxo vem pra esse método aqui embaixo
	public ResponseEntity<?> insert(@RequestBody Servico obj) {// @RequestBody permite pegar o corpo da requisição e passar para dentro do método
		// o <?> depois do ResponseEntity quer dizer que qualquer tipo de objeto pode ser retornado
		// o ResponseEntity permite devolver para o cliente uma resposta mais completa
		
		obj = service.insert(obj);
		
		//criando a URI para acessar o recurso recém criado (essa URI estará disponível no cabeçalho da resposta):
		// vai retornar algo assim, por exemplo: http://localhost:8080/Servicos/5 (sendo 5 o id da Servico recém criada)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build(); //retorna status code 201 e no cabeçalho da resposta informa a uri do recurso recém criado
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)// quando eu fizer um PUT /Servicos/id, o fluxo vem pra esse método aqui embaixo
	public ResponseEntity<Void> update(@RequestBody Servico obj, @PathVariable Integer id) {
		// o <void> depois do ResponseEntity quer dizer que nada será retornado no corpo da resposta
		// o ResponseEntity permite devolver para o cliente uma resposta mais completa
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)// quando eu fizer um DELETE /Servicos/id, o fluxo vem pra esse método aqui embaixo
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		// o <void> depois do ResponseEntity quer dizer que nada será retornado no corpo da resposta
		// o ResponseEntity permite devolver para o cliente uma resposta mais completa
		service.delete(id); // esse método pode retornar uma DataIntegrityException, mas quem vai lidar com isso é a classe ResourceExceptionHandler
		
		return ResponseEntity.noContent().build();
	}
}
