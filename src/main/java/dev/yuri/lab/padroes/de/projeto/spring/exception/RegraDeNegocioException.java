package dev.yuri.lab.padroes.de.projeto.spring.exception;

public class RegraDeNegocioException extends RuntimeException {
    public RegraDeNegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
