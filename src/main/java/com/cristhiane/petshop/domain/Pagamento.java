package com.cristhiane.petshop.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.cristhiane.petshop.domain.enums.SituacaoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // como essa é a classe mãe, temos que adicionar o @Inheritance e dizer como será feita a criação das tabelas das classes filhas
//A opção JOINED siginfica que será criada uma tabela para cada classe filha, onde serão armazenados os atributos que não são comuns à classe mãe
public abstract class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id // aqui não precisa setar aquela estratégia de geração automática de Ids por causa do @MapsId ali embaixo (mas na classe Serviço vai precisar)
	// O MapsId vai fazer com que a chave primária da tabela pagamento seja o id_servico, ao invés de criar mais uma coluna só pra chave primária!!!
	private Integer id;
	private Double valor;
	private Integer situacao;
	
	@OneToOne
	@JoinColumn(name = "id_servico") // eu configuro a relação aqui porque o pagamento só existe se existir um serviço. Logo, o id_servico será uma chave estrangeira dentro da tabela de pagamentos
	@MapsId
	private Servico servico;
	
	public Pagamento() {
		
	}

	public Pagamento(Integer id, Double valor, SituacaoPagamento situacao, Servico servico) {
		super();
		this.id = id;
		this.valor = valor;
		this.situacao = situacao.getCod(); //pegando o código da opção para depois salvar isso no banco
		this.setServico(servico);
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
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public SituacaoPagamento getSituacao() {
		return SituacaoPagamento.toEnum(situacao);
	}

	public void setSituacao(SituacaoPagamento situacao) {
		this.situacao = situacao.getCod();
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	

}
