package com.wdagency.atipykhouse.exception;

public class EntityException extends RuntimeException {

	private static final long serialVersionUID = -8148797822554301115L;

	EntityException(Long id) {
		    super("Could not find entity " + id);
		  }
}
