package me.dio.academia.digital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNaoEncontradoException extends RuntimeException{
    public AlunoNaoEncontradoException(Long id){
        super("Aluno não encontrado com ID " + id);
    }
}
