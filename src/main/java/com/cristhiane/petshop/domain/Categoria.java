package com.cristhiane.petshop.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Nesta classe está anotado tudo o que precisa ser feito dentro das classes de domínio de uma aplicação que usa o Spring Framework

// O passo a passo anotado dentro desta classe deve ser seguido por todas as classes de domínio!

// É necessário fazer tudo isso porque estamos usando um framework, dessa forma precisamos seguir as regras dele para que ele já possa nos entregar algumas coisas prontas

@Entity //marcando a classe como Entity para o JPA mapear ela para o banco de dados
public class Categoria implements Serializable  {
	//PASSO 4: Classe deve implementar a interface Serializable e deve ter o atributo serial version
	private static final long serialVersionUID = 1L;
	
	// PASSO 1: Criar os atributos
	@Id // fazendo com que o atributo id seja a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //definindo a estratégia de geração automática de valor dessa coluna
	private Integer id;
	private String nome;
	
	//PASSO 2: Criar construtores vazio e com campos
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	
	//PASSO 5: Implementar os métodos hashCode e equals (apenas para o atributo id, pois como ele é único, é suficiente fazer a comparação de objetos por ele)
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	//PASSO 3: Criar o encapsulamento (getters e setters)
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
	
	

}
