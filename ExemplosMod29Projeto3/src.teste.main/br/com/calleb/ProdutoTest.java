package br.com.calleb;

import br.com.calleb.dao.generic.jdbc.dao.IProdutoDAO;
import br.com.calleb.dao.generic.jdbc.dao.ProdutoDAO;
import br.com.calleb.domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description of ProdutoTest
 * Created by calle on 01/09/2023.
 */
public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarProdutoTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("RedBull energy");
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produto1 = new Produto();
        produto1.setCodigo("03");
        produto1.setNome("TNT energy");
        Integer qtd1 = dao.cadastrar(produto1);
        assertTrue(qtd1 == 1);
    }

    @Test
    public void consultarProdutoTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigo("02");
        produto1.setNome("Monster energy");
        Integer qtd1 = produtoDAO.cadastrar(produto1);
        assertTrue(qtd1 == 1);

        Produto produtoBD = produtoDAO.consultar(produto1.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto1.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto1.getNome(), produtoBD.getNome());
    }

    @Test
    public void buscarTodosProdutosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        try {
            List<Produto> produtos = produtoDAO.buscarTodosProdutos();

            assertNotNull(produtos);
            assertTrue(produtos.size() > 0);
        } catch (Exception e) {
            fail("O teste lançou uma exceção: " + e.getMessage());
        }
    }

    @Test
    public void excluirProdutosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigo("04");
        produto1.setNome("Billy energy");
        Integer qtd1 = produtoDAO.cadastrar(produto1);
        assertTrue(qtd1 == 1);

        Produto produtoBD = produtoDAO.consultar("04");
        assertNotNull(produtoBD);
        assertEquals(produto1.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto1.getNome(), produtoBD.getNome());

        Integer prodDel = produtoDAO.excluir(produtoBD);
        assertTrue(prodDel == 1);
    }

    @Test
    public void atualizarProdutosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigo("05");
        produto1.setNome("Billy energy");
        Integer qtd1 = produtoDAO.cadastrar(produto1);
        assertTrue(qtd1 == 1);

        Produto produtoBD = produtoDAO.consultar("05");
        assertNotNull(produtoBD);
        assertEquals(produto1.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto1.getNome(), produtoBD.getNome());

        produtoBD.setCodigo("06");
        produtoBD.setNome("NOS energy");
        Integer atualizarProduto = produtoDAO.atualizarProd(produtoBD);
        assertTrue(atualizarProduto == 1);

        Produto produtoBD1 = produtoDAO.consultar("06");
        assertNotNull(produtoBD1);
        assertEquals(produtoBD.getId(), produtoBD1.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD1.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD1.getNome());
    }
}
