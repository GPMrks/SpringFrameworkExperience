package me.dio.produtosapi.service;

import me.dio.produtosapi.entity.Produto;
import me.dio.produtosapi.exception.PrecoErradoException;
import me.dio.produtosapi.exception.ProdutoNaoEncontradoException;
import me.dio.produtosapi.exception.ProdutoNuloException;
import me.dio.produtosapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) throws Exception {
        verificaCamposDoProduto(produto);
        return produtoRepository.save(produto);
    }

    public Produto findById(Long id){
        return verificaSeExiste(id);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public void deleteById(Long id){
        verificaSeExiste(id);
        produtoRepository.deleteById(id);
    }

    public Produto updateProduto(Produto produto, Long id) throws Exception {
        final Produto produtoIndicado = verificaSeExiste(id);
        verificaCamposDoProduto(produto);
        produtoIndicado.setNome(produto.getNome());
        produtoIndicado.setPreco(produto.getPreco());
        produtoIndicado.setDescricao(produto.getDescricao());

        return produtoRepository.save(produtoIndicado);
    }

    private Produto verificaSeExiste(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        final Produto produtoIndicado;
        if (optionalProduto.isPresent()){
            produtoIndicado = optionalProduto.get();
        } else {
            throw new ProdutoNaoEncontradoException(id);
        }
        return produtoIndicado;
    }

    private void verificaCamposDoProduto(Produto produto) throws Exception {
        if (produto.getNome() == null || produto.getDescricao() == null || produto.getPreco() == null){
            throw new ProdutoNuloException();
        }
        if (produto.getPreco() < 0){
            throw new PrecoErradoException();
        }
    }

}
