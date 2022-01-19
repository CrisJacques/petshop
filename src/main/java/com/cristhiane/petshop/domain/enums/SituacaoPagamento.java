package com.cristhiane.petshop.domain.enums;

public enum SituacaoPagamento {
	
	QUITADO(1, "Quitado"),
	CANCELADO(2, "Cancelado"),
	PENDENTE(3, "Pendente");
	
	private int cod;
	private String descricao;
	
	private SituacaoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static SituacaoPagamento toEnum(Integer cod) {// está sendo usado Integer ao invés de int porque int é um tipo primitivo, logo não tem métodos associados a ele
		// Já o Integer possui vários métodos associados, entre eles o equals, que será usado logo abaixo
		if (cod == null) {
			return null;
		}
		
		for (SituacaoPagamento sp : SituacaoPagamento.values()) {
			if (cod.equals(sp.getCod())){
				return sp;
			}
		}
		
		throw new IllegalArgumentException(); // necessário ter essa exceção aqui no final porque se o argumento não se encaixar em nenhum dos casos acima a função não
		// retornaria o tipo que ela deve retornar, e estava dando erro na declaração da função
		
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
