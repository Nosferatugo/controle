/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.business;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.dao.EscolaDAO;
import br.com.controleDeEstoque.dao.IEscolaDAO;
import br.com.controleDeEstoque.enuns.EstadoCivil;
import br.com.controleDeEstoque.enuns.Operadora;
import br.com.controleDeEstoque.enuns.Sexo;
import br.com.controleDeEstoque.enuns.TipoDeEscola;
import br.com.controleDeEstoque.facade.Facade;
import br.com.controleDeEstoque.telas.TelaCadastrarEscolas;
import br.com.controleDeEstoque.model.Escola;
import br.com.controleDeEstoque.model.Contato;
import br.com.controleDeEstoque.model.Endereco;
import br.com.controleDeEstoque.model.Rg;
import br.com.controleDeEstoque.strategy.MensagensUtilStrategy;
import br.com.controleDeEstoque.strategy.UtilitariosStrategy;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Onismar
 */
public class EscolaBusiness implements IEscolaBusiness {

    private IEscolaDAO clienteDao;
    

    public EscolaBusiness() {
        clienteDao = new EscolaDAO();
    }

    @Override
    public void salvar(Escola e) throws BusinessException, ExceptionDAO {

        clienteDao.salvar(e);
    }

    @Override
    public void atualizar(Escola e) throws BusinessException, ExceptionDAO {
        clienteDao.atualizar(e);
    }

    @Override
    public Escola getById(Long id) throws BusinessException, ExceptionDAO {
        return clienteDao.getById(id);
    }

    @Override
    public List<Escola> getTodos() throws BusinessException, ExceptionDAO {
        return clienteDao.getTodos();
    }

    @Override
    public Escola getporNome(String nome) throws BusinessException, ExceptionDAO {
        return clienteDao.getporNome(nome);
    }

    @Override
    public void realizarCadastro(Long id, String nome,TipoDeEscola tipoEscola,String rua, String numeroDaRua, String bairro, String cep,
            String cidade, String estado, List<Contato> listaContatos) throws BusinessException, ExceptionDAO {

          UtilitariosStrategy utilitarios = new UtilitariosStrategy();
        
        

        Endereco endereco = new Endereco();
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setNumero(numeroDaRua);
        endereco.setCep(cep);

        Escola e = new Escola();

        e.setId(id);
        e.setNome(nome);      
        e.setTipoDeEscola(tipoEscola);
        e.setDataCadastro(Calendar.getInstance());
        e.setContato(listaContatos);
        e.setEndereco(endereco);
        System.out.println(e.getNome()+ "" + e.getDataCadastro().getTime() + "" + e.getContato());

        if (id == null) {
            ////VALIDAÇÕES VEM AQUI
            salvar(e);
            JOptionPane.showMessageDialog(null, MensagensUtilStrategy.getValor(MensagensUtilStrategy.MSG_SUCESSO_SALVAR, "  "));
          

        } else {
            atualizar(e);
            JOptionPane.showMessageDialog(null, MensagensUtilStrategy.getValor(MensagensUtilStrategy.MSG_EDITADO, "   "));
           
            
            

        }

    }

    @Override
    public void gerarTabelaEscola(JTable tabela) throws BusinessException {
        
        //JTableRenderer jTableRenderer = new JTableRenderer();
        DefaultTableModel modelo = new DefaultTableModel();
        Escola e = new Escola();

        modelo = (DefaultTableModel) tabela.getModel();

        
        
        
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Tipo Escola");
//        modelo.addColumn("");

        //Definindo o tamanho das colunas
        tabela.getColumnModel().getColumn(1).setPreferredWidth(280);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
//        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);

        //Definindo tamanho 0 a coluna ID
        tabela.getColumnModel().getColumn(0).setMinWidth(0);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabela.getColumnModel().getColumn(0).setMaxWidth(0);

        tabela.setRowHeight(25);
        modelo.setNumRows(0);

        List<Escola> listaEscola = new ArrayList<Escola>();
      
        try {
          // Icon editar = new ImageIcon(getClass().getResource(caminho da imagem));
          // Icon excluir = new ImageIcon(getClass().getResource(caminho da imagem));
          listaEscola = getTodos();
        } catch (Exception ex) {

        }

        if (!listaEscola.isEmpty()) {

            for (int i = 0; i < listaEscola.size(); i++) {
                Vector linha = new Vector();
                linha.add(listaEscola.get(i).getId());
                linha.add(listaEscola.get(i).getNome());
                linha.add(listaEscola.get(i).getTipoDeEscola());
//                linha.add(listaEscola.get(i).get());
              
                modelo.addRow(linha);

            }

        }

    }

    @Override
    public void gerarTelaEditarEscola(Escola e) throws BusinessException {

        TelaCadastrarEscolas ce = new TelaCadastrarEscolas(null, true);
        UtilitariosStrategy fd = new UtilitariosStrategy();

//        ce.jTextFieldNome.setText(e.getNome());
//        ce.jTextFieldBairro.setText(e.getEndereco().getBairro());
//        ce.jComboBoxEstado.setSelectedItem(e.getEndereco().getEstado());
//        ce.jComboBoxEstadoCivil.setSelectedItem(e.getSexo());
//        ce.jTextFieldCPF.setText(e.getCpf());
//        ce.jTextFieldCEP.setText(e.getEndereco().getCep());
//        ce.jTextFieldCidade.setText(e.getEndereco().getCidade());
//        ce.jTextFieldNumeroDaRua.setText(e.getEndereco().getNumero());
//        ce.jTextFieldOrgaoEmissor.setText(e.getRg().getOrgao());
//        ce.jTextFieldRG.setText(e.getRg().getNumero());
//        ce.jTextFieldRua.setText(e.getEndereco().getRua());
//        ce.jComboBoxEstadoCivil.setSelectedItem(e.getEstadoCivil());
//        ce.jFormattedTextFieldDataExpedição.setText(fd.pasarCalendarParaString(e.getRg().getDataExpedicao()));
//        ce.jFormattedTextFieldDataDeNascimento.setText(fd.pasarCalendarParaString(e.getDataNascimento()));
//        ce.id = e.getId();

        ce.setVisible(true);

    }

}
