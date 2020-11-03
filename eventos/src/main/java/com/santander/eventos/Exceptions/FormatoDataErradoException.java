package com.santander.eventos.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FormatoDataErradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FormatoDataErradoException(String dataEmString) {
        super(dataEmString);
    }
}
