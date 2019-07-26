package com.michelefreitas.workshopmongo.resource;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michelefreitas.workshopmongo.resource.exception.StandardError;
import com.michelefreitas.workshopmongo.service.exception.ObjectNotFoundException;

//anotação que indica que essa classe resp. tratar possível erros nas requisições 
@ControllerAdvice
public class ResourceExceptionHandler {

	//padrão framework, quando ocorrer essa excessão fazer o tratamento abaixo
	@ExceptionHandler(ObjectNotFoundException.class)
	//retorno StandardError                            //parâmetro tipo da excessão a tratar com nome e. Depois tipo parametro http... exigencia do framework
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
			
		//excessão obj não encontrado 404
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		// tempo ocorreu erro(Syst...Millis...) tempo atual sistema, status.valu... converte nº inteiro, a message pega do ObjectNot... e o path (caminho) 
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	

}
