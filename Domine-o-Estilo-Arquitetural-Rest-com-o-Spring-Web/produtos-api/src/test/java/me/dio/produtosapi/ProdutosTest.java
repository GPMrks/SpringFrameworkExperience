package me.dio.produtosapi;

import me.dio.produtosapi.entity.Produto;
import me.dio.produtosapi.exception.PrecoErradoException;
import me.dio.produtosapi.exception.ProdutoNuloException;
import me.dio.produtosapi.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutosTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void deveRetornarErroDeProdutoNuloSeOsCamposForamPreenchidosIncorretamente() throws Exception {
        Produto produto = new Produto();
        produto.setNome("Teste");
        produto.setPreco(10.0);
        //produto.setDescricao("Teste"); Ausência do campo descrição causa erro de campo

        assertThrows(ProdutoNuloException.class, () -> produtoService.save(produto));
    }

    @Test
    public void deveRetornarErroSeValorNegativoNoPrecoDoProduto() throws Exception {
        Produto produto = new Produto();
        produto.setNome("Teste");
        produto.setPreco(10.0);
        produto.setDescricao("Teste");

        produtoService.save(produto);

        assertEquals(produto.getId(), 1);

        produto.setPreco(-15.0);

        assertThrows(PrecoErradoException.class, () -> produtoService.updateProduto(produto, 1L));
    }

}
