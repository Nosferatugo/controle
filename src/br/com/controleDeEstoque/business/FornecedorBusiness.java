/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.business;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.dao.FornecedorDAO;
import br.com.controleDeEstoque.dao.IFornecedorDAO;
import br.com.controleDeEstoque.facade.Facade;
//import br.com.controleDeEstoque.telas.TelaCadastrarFornecedor;
import br.com.controleDeEstoque.model.Endereco;
import br.com.controleDeEstoque.model.Fornecedor;
import br.com.controleDeEstoque.strategy.MensagensUtilStrategy;
import br.com.controleDeEstoque.strategy.UtilitariosStrategy;
import br.com.controleDeEstoque.strategy.ValidationStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Onismar
 */
public class FornecedorBusiness implements IFornecedorBusiness {

    private IFornecedorDAO fornecedorDao;
    private Facade fachada = Facade.getInstance();
    private ValidationStrategy valida = new ValidationStrategy();

    public FornecedorBusiness() {
        fornecedorDao = new FornecedorDAO();
    }

    @Override
    public void salvar(Fornecedor f) throws ExceptionDAO {
        fornecedorDao.salvar(f);
    }

    @Override
    public void atualizar(Fornecedor f) throws ExceptionDAO {
        fornecedorDao.atualizar(f);
    }

    @Override
    public Fornecedor getById(Long id) throws ExceptionDAO {
        return fornecedorDao.getById(id);
    }

    @Override
    public List<Fornecedor> getTodos() throws ExceptionDAO {
        return fornecedorDao.getTodos();
    }

//    @Override
//    public Boolean realizarCadastraFornecedor(Long id, String nome, String cnpj, String rua, String cep, String numero, String bairro, String cidade, String estado) throws ExceptionDAO {

//        CadastrarFornecedor cf = new CadastrarFornecedor(null, true);
//        Utilitarios utilitarios = new Utilitarios();
//        Endereco end = new Endereco();
//        Fornecedor forne = new Fornecedor();
//
//        try {
//            end.setRua(rua);
//            end.setNumero(numero);
//            end.setBairro(bairro);
//            end.setCep(cep);
//            end.setCidade(cidade);
//            end.setEstado(estado);
//
//            forne.setId(id);
//            forne.setNome(nome);
//            forne.setCnpj(cnpj);
//            forne.setEndereco(end);
//
//            if (valida.validaFornecedor(forne)) {
//                if (id == null) {
//
//                    salvar(forne);
//                    JOptionPane.showMessageDialog(null, MensagensUtilStrategy.getValor(MensagensUtilStrategy.MSG_SUCESSO_SALVAR, "  "));
//                  
//                } else {
//                    atualizar(forne);
//                    JOptionPane.showMessageDialog(null, MensagensUtilStrategy.getValor(MensagensUtilStrategy.MSG_ALTERAR, "  "));
//                  
//                }
//                 return true;
//            }else
//                return false;
//             
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    

//    }

    @Override
    public void gerarTabelaFornecedor(JTable tabela) throws BusinessException {

        DefaultTableModel modelo = new DefaultTableModel();
        Fornecedor f = new Fornecedor();

        modelo = (DefaultTableModel) tabela.getModel();

        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("CNPJ");

        //Definindo o tamanho das colunas
        tabela.getColumnModel().getColumn(1).setPreferredWidth(280);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);

        //Definindo tamanho 0 a coluna ID
        tabela.getColumnModel().getColumn(0).setMinWidth(0);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabela.getColumnModel().getColumn(0).setMaxWidth(0);

        tabela.setRowHeight(25);
        modelo.setNumRows(0);

        List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();

        try {
            listaFornecedor = getTodos();
        } catch (Exception ex) {

        }

        if (!listaFornecedor.isEmpty()) {

            for (int i = 0; i < listaFornecedor.size(); i++) {
                Vector linha = new Vector();
                linha.add(listaFornecedor.get(i).getId());
                linha.add(listaFornecedor.get(i).getNome());
                linha.add(listaFornecedor.get(i).getCnpj());
                modelo.addRow(linha);

            }

        }

    }

    @Override
    public void gerarTelaEditarFornecedor(Fornecedor f) throws BusinessException {
//
//        CadastrarFornecedor cf = new CadastrarFornecedor(null, true);
//        Utilitarios fd = new Utilitarios();
//
//        cf.jTextFieldRazãoSocial.setText(f.getNome());
//        cf.jTextFieldCNPJ.setText(f.getCnpj());
//        cf.jTextFieldBairro.setText(f.getEndereco().getBairro());
//        cf.jTextFieldCEP.setText(f.getEndereco().getCep());
//        cf.jTextFieldCidade.setText(f.getEndereco().getCidade());
//        cf.jTextFieldNumeroDaRua.setText(f.getEndereco().getNumero());
//        cf.jTextFieldRua.setText(f.getEndereco().getRua());
//        cf.jComboBoxEstado.setSelectedItem(f.getEndereco().getEstado());
//
//        cf.setVisible(true);

    }

}
