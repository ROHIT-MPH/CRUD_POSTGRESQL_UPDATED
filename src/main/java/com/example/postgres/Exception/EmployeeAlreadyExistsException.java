package com.example.postgres.Exception;

public class EmployeeAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

		public EmployeeAlreadyExistsException(String message) {
			super(message);
		}
}
