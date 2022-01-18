package com.cristhiane.petshop.service.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoException(String msg) {
		super(msg); // passando a mensagem recebida por parâmetro no construtor para o construtor da classe mãe
	}
	
	public ObjetoNaoEncontradoException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
