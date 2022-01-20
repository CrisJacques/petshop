package com.cristhiane.petshop.dto;

import java.io.Serializable;

import com.cristhiane.petshop.domain.Pessoa;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// estas são as informações da classe Pessoa que queremos que sejam trafegadas (a ideia do DTO é criar um objeto para trafegar só as informações que queremos, não todas as da entidade)
	private String nome;
	private String email;
	private String CodNacional;
	
	public PessoaDTO() {
		
	}

	public PessoaDTO(Pessoa obj) {
		// setando nos atributos da classe as informações da entidade Pessoa que devem ser trafegadas
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		CodNacional = obj.getCodNacional();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodNacional() {
		return CodNacional;
	}

	public void setCodNacional(String codNacional) {
		CodNacional = codNacional;
	}
	
	

}
