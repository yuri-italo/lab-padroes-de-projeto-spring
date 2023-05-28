package dev.yuri.lab.padroes.de.projeto.spring.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ExceptionView {
    private final String titulo;
    private final LocalDateTime timeStamp;
    private final Integer status;
    private final String exception;
    private final Map<String, String> detalhes;

    public ExceptionView(
            String titulo,
            LocalDateTime timeStamp,
            Integer status,
            String exception,
            Map<String, String> detalhes
    ) {
        this.titulo = titulo;
        this.timeStamp = timeStamp;
        this.status = status;
        this.exception = exception;
        this.detalhes = detalhes;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getException() {
        return exception;
    }

    public Map<String, String> getDetalhes() {
        return detalhes;
    }
}
