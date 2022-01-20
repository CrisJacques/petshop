package com.cristhiane.petshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	@JsonIgnore // como o relacionamento entre produto e categoria é muitos para muitos, sem esse @JsonIgnore acontece uma referência cíclica, aí pra montar o JSON da resposta uma classe fica chamando a outra.
	// Como queremos que ao buscar uma categoria venham os produtos relacionados, mas não queremos que quando buscarmos os produtos venham as categorias, então temos que adicionar essa anotação aqui nos produtos!
	@ManyToMany // no relacionamento muitos para muitos, é criada uma nova tabela contendo os ids dos dois membros do relacionamento (no caso aqui, produtos e categorias)
	@JoinTable(name = "PRODUTO_CATEGORIA", //setando o nome da tabela que vai armazenar esses relacionamentos
				joinColumns = @JoinColumn(name = "id_produto"), // setando o nome da coluna que vai armazenar o id do produto
				inverseJoinColumns = @JoinColumn(name = "id_categoria")) // setando o nome da coluna que vai armazenar o id da categoria
	private List<Categoria> categorias = new ArrayList<>(); //como o relacionamento é many to many, tem que criar uma coleção de categorias aqui e lá na classe Categoria tem que criar uma coleção de produtos
	
	@JsonIgnore //porque eu não quero que o produto retorne os serviços, porque o serviço já retorna os produtos e aí vira referência cíclica
	@ManyToMany(mappedBy = "produtos")
	private List<Servico> servicos = new ArrayList<>();
	
	public Produto() {
		
	}

	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	
	
}
