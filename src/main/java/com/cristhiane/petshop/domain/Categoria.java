package com.cristhiane.petshop.domain;

import java.io.Serializable;
import java.util.Objects;

// Nesta classe está anotado tudo o que precisa ser feito dentro das classes de domínio de uma aplicação que usa o Spring Framework

// O passo a passo anotado dentro desta classe deve ser seguido por todas as classes de domínio!

// É necessário fazer tudo isso porque estamos usando um framework, dessa forma precisamos seguir as regras dele para que ele já possa nos entregar algumas coisas prontas

//PASSO 4: Classe deve implementar a interface Serializable e deve ter o atributo serial version
public class Categoria implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	// PASSO 1: Criar os atributos
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
