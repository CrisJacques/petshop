package com.cristhiane.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristhiane.petshop.domain.Categoria;
import com.cristhiane.petshop.repository.CategoriaRepository;

@Component // aqui é pra indicar que essa classe não tem nenhum papel específico (não é controller, nem service nem repository)
public class PopulaDados {
	
	@Autowired // pois como vamos usar os repositories para popular o banco de dados de teste, precisamos injetar a dependência deles
	CategoriaRepository categoriaRepository;
	
	@PostConstruct //essa anotação faz com que esse método seja executado logo após a aplicação ser construída (enquanto estamos só desenvolvendo e testando, podemos deixar assim)
	// Quando formos usar o banco real (MySQL), aí temos que desativar isso, pq senão cada vez que a gente subir a aplicação ele vai popular esses dados lá!
	public void cadastrar() {
		Categoria cat1 = new Categoria(null, "Alimento"); // não precisamos nos preocupar em informar id porque o JPA já vai cuidar de criar os ids dos objetos
		Categoria cat2 = new Categoria(null, "Cosmético");
		Categoria cat3 = new Categoria(null, "Remédio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // salvando as 3 categorias criadas acima no banco de dados
	}

}
