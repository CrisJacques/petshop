package com.cristhiane.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.cristhiane.petshop.domain.enums.SituacaoPagamento;

@Entity //aqui só precisa marcar como Entity, a coluna de chave primária ele pega da classe mãe
public class PagDinheiro extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Double desconto;
	
	public PagDinheiro() {
		
	}

	public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacaoPagamento, Servico servico, Date dataVencimento, Double desconto) {
		super(id, valor, situacaoPagamento, servico);
		this.dataVencimento = dataVencimento;
		this.desconto = desconto;
	}

	// nesta classe e na PagCartao não precisa criar os métodos hashCode e equals porque eles serão herdados da classe mãe!
	
	public Date getdataVencimento() {
		return dataVencimento;
	}

	public void setdataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	

}
