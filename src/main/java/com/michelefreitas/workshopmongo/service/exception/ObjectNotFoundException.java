package com.michelefreitas.workshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//sobrepor construtor básico
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
