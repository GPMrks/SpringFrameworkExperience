package me.dio.produtosapi.controller;

import me.dio.produtosapi.entity.Produto;
import me.dio.produtosapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) throws Exception {
        produto = produtoService.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto, @PathVariable Long id) throws Exception {
        Produto produtoUpdate = produtoService.updateProduto(produto, id);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaProduto(@PathVariable Long id){
        produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
