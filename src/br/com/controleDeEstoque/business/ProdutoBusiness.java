/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.business;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.dao.IProdutoDAO;
import br.com.controleDeEstoque.dao.ProdutoDAO;
import br.com.controleDeEstoque.enuns.ComposicaoProduto;
import br.com.controleDeEstoque.enuns.TipoProduto;
import br.com.controleDeEstoque.facade.Facade;
import br.com.controleDeEstoque.gui.CadastrarProduto;
import br.com.controleDeEstoque.model.Fornecedor;

import br.com.controleDeEstoque.model.Produto;
import br.com.controleDeEstoque.strategy.MensagensUtilStrategy;
import br.com.controleDeEstoque.strategy.UtilitariosStrategy;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Onismar
 */
public class ProdutoBusiness implements IProdutoBusiness {

    private IProdutoDAO produtoDao;
    private Facade fachada = Facade.getInstance();

    public ProdutoBusiness() {
        produtoDao = new ProdutoDAO();
    }

    @Override
    public void salvar(Produto p) throws ExceptionDAO {
        produtoDao.salvar(p);
    }

    @Override
    public void atualizar(Produto p) throws ExceptionDAO {
        produtoDao.atualizar(p);
    }

    @Override
    public Produto getById(Long id) throws ExceptionDAO {
        return produtoDao.getById(id);
    }

    @Override
    public List<Produto> getTodos() throws ExceptionDAO {
        return produtoDao.getTodos();
    }

    @Override
    public List<Produto> getProdutoPorNome(String nome) throws ExceptionDAO {
        return produtoDao.getProdutoPorNome(nome);
    }

    @Override
    public void realizarCadastro(Long id, String descricao, TipoProduto tipoProduto, ComposicaoProduto composicaoProduto, String compraUnidade, String quantidade, Fornecedor f) throws ExceptionDAO {

        UtilitariosStrategy utilitarios = new UtilitariosStrategy();
        Produto p = new Produto();
        p.setId(id);
        p.setComposicaoProduto(composicaoProduto);
        p.setTipoProduto(tipoProduto);
        p.setDescricao(descricao);

        if (id == null) {
            salvar(p);
            JOptionPane.showMessageDialog(null, MensagensUtilStrategy.getValor(MensagensUtilStrategy.MSG_SUCESSO_SALVAR, ""));

        } else {
            atualizar(p);
            JOptionPane.showMessageDialog(null, MensagensUtilStrategy.getValor(MensagensUtilStrategy.MSG_SUCESSO_SALVAR, "  "));

        }

    }

}
