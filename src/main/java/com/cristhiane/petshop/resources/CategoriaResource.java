package com.cristhiane.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // marcando a classe como um controlador REST (o Spring exige isso)
@RequestMapping(value = "/categorias") // mapeamento de qual a URL deve ser chamada
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)// quando eu fizer um GET /categorias, o fluxo vem pra esse método aqui embaixo
	public String mostrar() {
		return "Teste REST Categorias";
	}
}
