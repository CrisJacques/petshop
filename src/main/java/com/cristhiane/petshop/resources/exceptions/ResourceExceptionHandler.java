package com.cristhiane.petshop.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cristhiane.petshop.service.exceptions.DataIntegrityException;
import com.cristhiane.petshop.service.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice //ele é focado na manipulação de erros (inclusive por isso está sendo implementado em uma outra classe separada, ao invés de ir junto no Controller)
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjetoNaoEncontradoException e, HttpServletRequest request){
		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrityViolation(DataIntegrityException e, HttpServletRequest request){
		StandardError erro = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
