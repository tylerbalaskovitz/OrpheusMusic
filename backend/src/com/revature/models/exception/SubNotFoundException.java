package com.revature.models.exception;
import java.text.MessageFormat;

 
public class SubNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SubNotFoundException(final long id) {
	    super(MessageFormat.format("Could not find subscription with id: {0}", id));

	}

	

}
