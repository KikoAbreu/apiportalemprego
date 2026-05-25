package com.portal.emprego.exception;

import com.portal.emprego.dto.ErroRespostaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Captura erros de validação (Campos em branco, nulos, inválidos) -> Retorna 400 Bad Request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO> tratarValidacao(MethodArgumentNotValidException ex) {
        List<String> erros = new ArrayList<>();
        
        for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
            erros.add(fe.getField() + ": " + fe.getDefaultMessage());
        }

        ErroRespostaDTO erroResposta = new ErroRespostaDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Dados inválidos na requisição",
                erros
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResposta);
    }

    // Captura erros quando um recurso não é encontrado (Vaga/Curso inexistente) -> Retorna 404 Not Found
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroRespostaDTO> tratarNaoEncontrado(RecursoNaoEncontradoException ex) {
        ErroRespostaDTO erroResposta = new ErroRespostaDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroResposta);
    }
}