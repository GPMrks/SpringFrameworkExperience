package me.dio.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AvaliacaoNaoEncontradaException extends RuntimeException{

    public AvaliacaoNaoEncontradaException(Long id){
        super("Avaliação Física não encontrada com ID " + id);
    }

}
