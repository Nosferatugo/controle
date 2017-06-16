/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.facade;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.enuns.ComposicaoProduto;
import br.com.controleDeEstoque.enuns.EstadoCivil;
import br.com.controleDeEstoque.enuns.Sexo;
import br.com.controleDeEstoque.enuns.TipoDeEscola;
import br.com.controleDeEstoque.enuns.TipoProduto;
import br.com.controleDeEstoque.model.Escola;
import br.com.controleDeEstoque.model.Contato;
import br.com.controleDeEstoque.model.Fornecedor;
import br.com.controleDeEstoque.model.Funcionario;
import br.com.controleDeEstoque.model.Produto;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Onismar
 */
public interface IFacade {

    //Escola
    public void salvarEscola(Escola e) throws BusinessException, ExceptionDAO;

    public void realizarCadastroDaEscola(Long id, String nome,TipoDeEscola tipoEscola,String rua, String numeroDaRua, String bairro, String cep,
            String cidade, String estado, List<Contato> listaContatos) throws BusinessException, ExceptionDAO;

    public void atualizarEscola(Escola e) throws BusinessException, ExceptionDAO;

    public Escola getByIdEscola(Long id) throws BusinessException, ExceptionDAO;

    public List<Escola> getTodosEscola() throws BusinessException, ExceptionDAO;

    public Escola getporNomeEscola(String nome) throws BusinessException, ExceptionDAO;
   
    public void gerarTabelaEscola (JTable tabela) throws BusinessException;
    
    public void gerarTelaEditarEscola (Escola e) throws BusinessException;
    
    
    //Fornecedor
    public void salvarFornecedor(Fornecedor f) throws ExceptionDAO;

    public void atualizarForncedor(Fornecedor f) throws ExceptionDAO;

    public Fornecedor getByIdFornecedor(Long id) throws ExceptionDAO;

    public List<Fornecedor> getTodosFornecedores() throws ExceptionDAO;

//    public Boolean realizarCadastraFornecedor(Long id,String nome, String cnpj, String rua, String cep, String numero, String bairro,
//            String cidade, String estado) throws ExceptionDAO;
//    
    public void gerarTabelaFornecedor (JTable tabela) throws BusinessException;
    
    public void gerarTelaEditarFornecedor (Fornecedor f) throws BusinessException;
    

   
    //Produto
    public void salvarProduto(Produto p) throws ExceptionDAO;

    public void atualizarProduto(Produto p) throws ExceptionDAO;

    public Produto getByIdProduto(Long id) throws ExceptionDAO;

    public List<Produto> getTodosProdutos() throws ExceptionDAO;

    public List<Produto> getProdutoPorNome(String nome) throws ExceptionDAO;
    
    public void realizarCadastroProduto(Long id, String descricao, TipoProduto tipoProduto, ComposicaoProduto composicaoProduto,String atacado ,String varejo,String compraUnidade,String quantidade, Fornecedor f) throws ExceptionDAO;


    //Funcionário
    public void salvarFuncionario(Funcionario f) throws BusinessException, ExceptionDAO;

    public void atualizarFuncionario(Funcionario f) throws BusinessException, ExceptionDAO;

    public Funcionario getByIdFuncionario(Long id) throws BusinessException, ExceptionDAO;

    public List<Funcionario> getTodosFuncionarios() throws BusinessException, ExceptionDAO;

    public void modificaStatusFuncionario(Funcionario f, boolean status) throws BusinessException, ExceptionDAO;

    public List<Funcionario> autorizacaoDescontoFuncionario(boolean status) throws BusinessException, ExceptionDAO;

    public List<Funcionario> statusFuncionario(boolean status) throws BusinessException, ExceptionDAO;

    public Funcionario retornaFuncionario(String cpf) throws BusinessException, ExceptionDAO;

    public void realizarCadastroFuncionario(Long id,String nome, String cpf, String rg, String dataNascimento,
            String dataExpedicao, String orgaoEmissor, String rua, String numeroDaRua, String bairro, String cep,
            String cidade, String estado, List<Contato> listaContatos, Sexo sexo, EstadoCivil estadoSivil) throws BusinessException, ExceptionDAO;

    public void gerarTabelaFuncionario(JTable tabela) throws BusinessException;

    public void gerarTelaEditarFuncionario(Funcionario f) throws BusinessException;
    
    public Funcionario retornaFuncionarioPorLogin(String login) throws ExceptionDAO, BusinessException;
    
    public Boolean confirmaFuncionarioPorLogin(String login, String senha) throws ExceptionDAO, BusinessException;

    
    
   
    //
}
