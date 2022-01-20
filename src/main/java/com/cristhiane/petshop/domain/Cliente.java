package com.cristhiane.petshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private String tipo;
	
	@OneToMany(mappedBy = "cliente")
	private List<Servico> servicos = new ArrayList<>();
	
	public Cliente() {
		
	}

	public Cliente(Integer id, String nome, String email, String codNacional, String tipo) {
		super(id, nome, email, codNacional);
		this.tipo = tipo;
	}

	public String gettipo() {
		return tipo;
	}

	public void settipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	

}
