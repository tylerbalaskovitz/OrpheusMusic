package com.revature.models.exception;

import java.text.MessageFormat;

public class CartNotFoundException 
	extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public CartNotFoundException(final long id) {
		    super(MessageFormat.format("Could not find Cart with id: {0}", id));

		}

		

	}



