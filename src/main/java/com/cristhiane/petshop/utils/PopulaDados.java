package com.cristhiane.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristhiane.petshop.domain.Categoria;
import com.cristhiane.petshop.domain.Produto;
import com.cristhiane.petshop.repository.CategoriaRepository;
import com.cristhiane.petshop.repository.ProdutoRepository;

@Component // aqui é pra indicar que essa classe não tem nenhum papel específico (não é controller, nem service nem repository)
public class PopulaDados {
	
	@Autowired // pois como vamos usar os repositories para popular o banco de dados de teste, precisamos injetar a dependência deles
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostConstruct //essa anotação faz com que esse método seja executado logo após a aplicação ser construída (enquanto estamos só desenvolvendo e testando, podemos deixar assim)
	// Quando formos usar o banco real (MySQL), aí temos que desativar isso, pq senão cada vez que a gente subir a aplicação ele vai popular esses dados lá!
	public void cadastrar() {
		Categoria cat1 = new Categoria(null, "Alimento"); // não precisamos nos preocupar em informar id porque o JPA já vai cuidar de criar os ids dos objetos
		Categoria cat2 = new Categoria(null, "Remédio");
		Categoria cat3 = new Categoria(null, "Cosmético");
		
		Produto p1 = new Produto(null, "Ração", 100.0);
		Produto p2 = new Produto(null, "Sache", 80.0);
		Produto p3 = new Produto(null, "Vermifugo", 20.0);
		Produto p4 = new Produto(null, "Shampoo", 50.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2)); //o getProdutos() veio do generate getters e setters lá na classe Categoria
		cat2.getProdutos().addAll(Arrays.asList(p3, p4));
		cat3.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2, cat3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // salvando as 3 categorias criadas acima no banco de dados
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4)); // salvando os 4 produtos criados acima no banco de dados
	}

}
