package me.dio.produtosapi.service;

import me.dio.produtosapi.entity.Pedido;
import me.dio.produtosapi.entity.Produto;
import me.dio.produtosapi.exception.PedidoNaoEncontradoException;
import me.dio.produtosapi.exception.ProdutoNaoEncontradoException;
import me.dio.produtosapi.repository.PedidoRepository;
import me.dio.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id){
        return verificaSeExiste(id);
    }

    public Pedido save(Pedido pedido){
        Set<Produto> produtos = new HashSet<>();

        pedido.setDataPedido(LocalDateTime.now());
        pedido.getProdutos().forEach(produto -> {
            produtos.add(produtoRepository.getReferenceById(produto.getId()));
        });
        pedido.setProdutos(produtos);

        return pedidoRepository.save(pedido);
    }

    public void deleleById(Long id){
        pedidoRepository.deleteById(id);
    }

    private Pedido verificaSeExiste(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        final Pedido pedidoIndicado;
        if (optionalPedido.isPresent()){
            pedidoIndicado = optionalPedido.get();
        } else {
            throw new PedidoNaoEncontradoException(id);
        }
        return pedidoIndicado;
    }
}
