package me.dio.produtosapi.controller;

import me.dio.produtosapi.entity.Pedido;
import me.dio.produtosapi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodos() {
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        pedido = pedidoService.save(pedido);
        return ResponseEntity.ok().body(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaPedido(@PathVariable Long id) {
        pedidoService.deleleById(id);
        return ResponseEntity.ok().build();
    }

}
