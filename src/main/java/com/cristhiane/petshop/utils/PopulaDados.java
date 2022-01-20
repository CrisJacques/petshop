package com.cristhiane.petshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristhiane.petshop.domain.Categoria;
import com.cristhiane.petshop.domain.Cidade;
import com.cristhiane.petshop.domain.Cliente;
import com.cristhiane.petshop.domain.Endereco;
import com.cristhiane.petshop.domain.Especie;
import com.cristhiane.petshop.domain.Estado;
import com.cristhiane.petshop.domain.Funcionario;
import com.cristhiane.petshop.domain.PagCartao;
import com.cristhiane.petshop.domain.PagDinheiro;
import com.cristhiane.petshop.domain.Pagamento;
import com.cristhiane.petshop.domain.Pet;
import com.cristhiane.petshop.domain.Produto;
import com.cristhiane.petshop.domain.Raca;
import com.cristhiane.petshop.domain.Servico;
import com.cristhiane.petshop.domain.enums.SituacaoPagamento;
import com.cristhiane.petshop.repository.CategoriaRepository;
import com.cristhiane.petshop.repository.CidadeRepository;
import com.cristhiane.petshop.repository.EnderecoRepository;
import com.cristhiane.petshop.repository.EspecieRepository;
import com.cristhiane.petshop.repository.EstadoRepository;
import com.cristhiane.petshop.repository.PagamentoRepository;
import com.cristhiane.petshop.repository.PessoaRepository;
import com.cristhiane.petshop.repository.PetRepository;
import com.cristhiane.petshop.repository.ProdutoRepository;
import com.cristhiane.petshop.repository.RacaRepository;
import com.cristhiane.petshop.repository.ServicoRepository;

@Component // aqui é pra indicar que essa classe não tem nenhum papel específico (não é
			// controller, nem service nem repository)
public class PopulaDados {

	@Autowired // pois como vamos usar os repositories para popular o banco de dados de teste,
				// precisamos injetar a dependência deles
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

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;

	@PostConstruct // essa anotação faz com que esse método seja executado logo após a aplicação
					// ser construída (enquanto estamos só desenvolvendo e testando, podemos deixar
					// assim)
	// Quando formos usar o banco real (MySQL), aí temos que desativar isso, pq
	// senão cada vez que a gente subir a aplicação ele vai popular esses dados lá!
	public void cadastrar() throws ParseException {// esse ParseException vem do parse da data quando se adiciona um serviço, lá embaixo
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
		
		Cliente clt1 = new Cliente(null, "Jose Maria", "jose@mail.com", "335.194.320-21", "FISICA");
		clt1.getTelefones().addAll(Arrays.asList("3516-2000","9191-0000"));
		
		Funcionario fnc1 = new Funcionario(null, "Maria Jose", "maria@mail.com", "551.872.200.12", "ATENDENTE");
		fnc1.getTelefones().addAll(Arrays.asList("3279-0001","9090-0002"));
		
		Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", c1, clt1);
		Endereco end2 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "3968000", c2, fnc1);
		Endereco end3 = new Endereco(null, "Rua Aranãs", "10", "Apto 201", "Centro", "01153000", c3, fnc1);
		
		pessoaRepository.saveAll(Arrays.asList(clt1, fnc1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Servico srv1 = new Servico(null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 12:00"), "Tosa", clt1, fnc1, pet1);// adicionado um throw ParseException lá na definição do método
		// Não precisamos nos preocupar em tratar essa exceção porque aqui estamos fazendo um cadastro na mão mesmo, então não tem perigo de dar problema
		Servico srv2 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("04/09/2021 12:00"), "Hotel", clt1, fnc1, pet2);
		Servico srv3 = new Servico(null, sdf.parse("05/09/2021 16:00"), sdf.parse("05/09/2021 16:30"), "Vermifugação", clt1, fnc1, pet3);
		
		Pagamento pgt1 = new PagCartao(null, 60.00, SituacaoPagamento.QUITADO, srv2, 6);
		srv2.setPagamento(pgt1);
		
		Pagamento pgt2 = new PagDinheiro(null, 100.00, SituacaoPagamento.PENDENTE, srv1, sdf.parse("02/09/2021 00:00"), null);
		srv1.setPagamento(pgt2);
		
		Pagamento pgt3 = new PagDinheiro(null, 75.00, SituacaoPagamento.QUITADO, srv3, sdf.parse("05/09/2021 16:30"), null);
		srv3.setPagamento(pgt3);
		
		clt1.getServicos().addAll(Arrays.asList(srv1, srv2, srv3));
		fnc1.getServicos().addAll(Arrays.asList(srv1, srv2, srv3));
		
		srv2.getProdutos().addAll(Arrays.asList(p1, p2, p4));
		srv3.getProdutos().addAll(Arrays.asList(p3));
		
		servicoRepository.saveAll(Arrays.asList(srv1, srv2, srv3));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2, pgt3));
	}

}
