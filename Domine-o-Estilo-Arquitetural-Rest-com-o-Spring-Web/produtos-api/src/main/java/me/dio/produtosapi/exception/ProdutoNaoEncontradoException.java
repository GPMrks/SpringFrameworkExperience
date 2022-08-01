package me.dio.produtosapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProdutoNaoEncontradoException extends RuntimeException{
    public ProdutoNaoEncontradoException(Long id){
        super("Produto não encontrado com ID " + id);
    }
}
