package br.com.fiap.empregados.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
