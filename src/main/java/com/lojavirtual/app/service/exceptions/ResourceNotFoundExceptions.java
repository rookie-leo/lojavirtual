package com.lojavirtual.app.service.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExceptions(Object id) {
		super("Resourcer not found: id " + id);
	}
	
}
