package me.dio.produtosapi.controller;

import me.dio.produtosapi.exception.PrecoErradoException;
import me.dio.produtosapi.exception.ProdutoNaoEncontradoException;
import me.dio.produtosapi.exception.ProdutoNuloException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProdutoNuloException.class)
    public ResponseEntity<Object> produtoNulo(){
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Verifique os campos do produto.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(PrecoErradoException.class)
    public ResponseEntity<Object> precoInvalido(){
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Preço inválido.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public final ResponseEntity<Object> produtoNaoEncontrado(ProdutoNaoEncontradoException ex){
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
