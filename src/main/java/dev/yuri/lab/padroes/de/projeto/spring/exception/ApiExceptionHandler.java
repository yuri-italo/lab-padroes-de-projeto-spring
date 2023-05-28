package dev.yuri.lab.padroes.de.projeto.spring.exception;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ExceptionView> handleRegraDeNegocioException(RegraDeNegocioException e) {
        Map<String, String> detalhes = new HashMap<>() {{
            put(e.getCause().toString(), e.getMessage());
        }};

        return ResponseEntity
                .badRequest()
                .body(new ExceptionView("Regra de negócio violada",
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        e.getClass().getSimpleName(),
                        detalhes)
                );
    }

    @ExceptionHandler(HibernateException.class)
    public ResponseEntity<ExceptionView> handleHibernateException(HibernateException e) {

        Map<String, String> detalhes = new HashMap<>() {{
            put(e.getClass().getName(), e.getMessage());
        }};

        return ResponseEntity
                .badRequest()
                .body(new ExceptionView("Falha ao consultar CEP, procure o admin.",
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        e.getClass().getSimpleName(),
                        detalhes)
                );
    }
}
