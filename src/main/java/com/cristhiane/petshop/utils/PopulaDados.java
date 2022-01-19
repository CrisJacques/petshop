package com.cristhiane.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristhiane.petshop.domain.Categoria;
import com.cristhiane.petshop.domain.Cidade;
import com.cristhiane.petshop.domain.Especie;
import com.cristhiane.petshop.domain.Estado;
import com.cristhiane.petshop.domain.Pet;
import com.cristhiane.petshop.domain.Produto;
import com.cristhiane.petshop.domain.Raca;
import com.cristhiane.petshop.repository.CategoriaRepository;
import com.cristhiane.petshop.repository.CidadeRepository;
import com.cristhiane.petshop.repository.EspecieRepository;
import com.cristhiane.petshop.repository.EstadoRepository;
import com.cristhiane.petshop.repository.PetRepository;
import com.cristhiane.petshop.repository.ProdutoRepository;
import com.cristhiane.petshop.repository.RacaRepository;

@Component // aqui é pra indicar que essa classe não tem nenhum papel específico (não é controller, nem service nem repository)
public class PopulaDados {
	
	@Autowired // pois como vamos usar os repositories para popular o banco de dados de teste, precisamos injetar a dependência deles
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	RacaRepository racaRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@PostConstruct // essa anotação faz com que esse método seja executado logo após a aplicação
					// ser construída (enquanto estamos só desenvolvendo e testando, podemos deixar
					// assim)
	// Quando formos usar o banco real (MySQL), aí temos que desativar isso, pq
	// senão cada vez que a gente subir a aplicação ele vai popular esses dados lá!
	public void cadastrar() {
		Categoria cat1 = new Categoria(null, "Alimento"); // não precisamos nos preocupar em informar id porque o JPA já
															// vai cuidar de criar os ids dos objetos
		Categoria cat2 = new Categoria(null, "Remédio");
		Categoria cat3 = new Categoria(null, "Cosmético");

		Produto p1 = new Produto(null, "Ração", 100.0);
		Produto p2 = new Produto(null, "Sache", 80.0);
		Produto p3 = new Produto(null, "Vermifugo", 20.0);
		Produto p4 = new Produto(null, "Shampoo", 50.0);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2)); // o getProdutos() veio do generate getters e setters lá na
															// classe Categoria
		cat2.getProdutos().addAll(Arrays.asList(p3, p4));
		cat3.getProdutos().addAll(Arrays.asList(p4));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2, cat3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // salvando as 3 categorias criadas acima no banco
																		// de dados
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4)); // salvando os 4 produtos criados acima no banco de
																	// dados

		Especie esp1 = new Especie(null, "Cachorro");
		Especie esp2 = new Especie(null, "Gato");

		Raca rac1 = new Raca(null, "Shitzu");
		Raca rac2 = new Raca(null, "Akita");
		Raca rac3 = new Raca(null, "Persa");

		Pet pet1 = new Pet(null, "John", 6, esp1, rac1);
		Pet pet2 = new Pet(null, "Hana", 5, esp1, rac2);
		Pet pet3 = new Pet(null, "Mewth", 8, esp2, rac3);

		especieRepository.saveAll(Arrays.asList(esp1, esp2));
		racaRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
		petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade(null, "Capelinha", est1);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
