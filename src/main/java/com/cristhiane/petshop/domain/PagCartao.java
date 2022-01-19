package com.cristhiane.petshop.domain;

import javax.persistence.Entity;

import com.cristhiane.petshop.domain.enums.SituacaoPagamento;

@Entity //aqui só precisa marcar como Entity, a coluna de chave primária ele pega da classe mãe
public class PagCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Integer parcelas;
	
	public PagCartao() {
		
	}

	public PagCartao(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico, Integer parcelas) {
		super(id, valor, situacaoPagamento, servico);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	
	
	

}
