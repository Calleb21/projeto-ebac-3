package br.com.calleb.dao.generic.jdbc.dao;

import br.com.calleb.dao.generic.jdbc.domain.Produto;

import java.util.List;

/**
 * Description of IProdutoDAO
 * Created by calle on 20/09/2023.
 */
public interface IProdutoDAO {
    Integer cadastrarProduto(Produto produto) throws Exception;

    Integer atalizarProduto(Produto produto) throws Exception;

    Produto consultarProduto(String codigo) throws Exception;

    Integer excluirProduto(Produto produto) throws Exception;

    List<Produto> buscarTodosProdutos() throws Exception;
}
