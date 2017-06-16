/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.strategy;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.gui.CadastrarEscola;

import br.com.controleDeEstoque.gui.CadastrarFornecedor;
import br.com.controleDeEstoque.gui.CadastrarFuncionario;
import br.com.controleDeEstoque.gui.CadastrarProduto;
import br.com.controleDeEstoque.model.Escola;
import br.com.controleDeEstoque.model.Contato;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan Santos Diniz
 */
public class UtilitariosStrategy {

    public Calendar pasarStringParaCalendar(String dataString) {

        Date d = null;
        Calendar c = null;
        try {

            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

            c = Calendar.getInstance();
            c.setTime(formatoData.parse(dataString));

        } catch (Exception e) {
           return null;
        }

        return c;
    }

    public String pasarCalendarParaString(Calendar dataCalendar) {
        String dataString = "";
        try {

            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

            Calendar hoje = new GregorianCalendar();

            dataString = formatoData.format(hoje.getTime());

        } catch (Exception e) {
           return null;
        }
        return dataString;
    }

    public void limparCamposTelaCliente() throws BusinessException {

        CadastrarEscola cd = new CadastrarEscola(null, true);
        UtilitariosStrategy fd = new UtilitariosStrategy();

        cd.jTextFieldNome.setText("");
        cd.jTextFieldBairro.setText("");
        cd.jComboBoxEstado.setSelectedItem("");
        cd.jComboBoxEstadoCivil.setSelectedItem("");
        cd.jTextFieldCPF.setText("");
        cd.jTextFieldCEP.setText("");
        cd.jTextFieldCidade.setText("");
        cd.jTextFieldNumeroDaRua.setText("");
        cd.jTextFieldOrgaoEmissor.setText("");
        cd.jTextFieldRG.setText("");
        cd.jTextFieldRua.setText("");
        cd.jComboBoxEstadoCivil.setSelectedItem("");
        cd.jFormattedTextFieldDataExpedição.setText("");
        cd.jFormattedTextFieldDataDeNascimento.setText("");
        cd.setVisible(true);

    }

    public void limparCamposTelaFuncionario(CadastrarFuncionario cf) throws BusinessException {

       
        UtilitariosStrategy fd = new UtilitariosStrategy();

        cf.jTextFieldNome.setText("");
        cf.jTextFieldBairro.setText("");
        cf.boxEstado.setSelectedItem("");
        cf.jComboBoxEstadoCivil.setSelectedItem("");
        cf.jTextFieldCPF.setText("");
        cf.jTextFieldCEP.setText("");
        cf.jTextFieldCidade.setText("");
        cf.jTextFieldNumeroDaRua.setText("");
        cf.jTextFieldOrgaoEmisor.setText("");
        cf.jTextFieldRG.setText("");
        cf.jTextFieldRua.setText("");
        cf.jComboBoxEstadoCivil.setSelectedItem("");
        cf.jFormattedTextFieldDataExpedição.setText(" ");
        cf.jFormattedTextFieldDataDeNascimento.setText(" ");
        
        cf.setVisible(true);

    }

   

    public void limparCamposTelaFornecedor() throws BusinessException {

        CadastrarFornecedor cf = new CadastrarFornecedor(null, true);
        UtilitariosStrategy fd = new UtilitariosStrategy();

        cf.jTextFieldBairro.setText("");
        cf.jTextFieldCEP.setText("");
        cf.jComboBoxEstado.setSelectedItem("");
        cf.jTextFieldCidade.setText("");
        cf.jTextFieldNumeroDaRua.setText("");
        cf.jTextFieldRua.setText("");
        cf.jTextFieldCNPJ.setText("");
        cf.jTextFieldRazãoSocial.setText("");
        cf.setVisible(true);

    }

    public void limparCamposTelaProduto() throws BusinessException {

        CadastrarProduto cp = new CadastrarProduto(null, true);
        UtilitariosStrategy fd = new UtilitariosStrategy();

        cp.jTextFieldPrecoAtacado.setText("");
        cp.jTextFieldPrecoVarejo.setText("");
        cp.jTextFieldPercoDeCompra.setText("");
        cp.jTextFieldQuantidade.setText("");
        cp.jTextFieldDescricao.setText("");
   
        cp.jComboBoxComposicao.setSelectedItem("");
         cp.jComboBoxTipo.setSelectedItem("");
  
        cp.setVisible(true);

   
    }
    
     public void gerarTabelaContatos(JTable tabela) throws BusinessException {

        
            DefaultTableModel modelo = new DefaultTableModel();
            modelo = (DefaultTableModel) tabela.getModel();
            
            modelo.addColumn("Id");
            modelo.addColumn("Número");
            modelo.addColumn("Operadora");
            modelo.addColumn("Email");
            modelo.addColumn("Obs");

            //Definindo o tamanho das colunas
            tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
            
              
        tabela.getColumnModel().getColumn(0).setMinWidth(0);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabela.getColumnModel().getColumn(0).setMaxWidth(0);

            //Definindo tamanho 0 a coluna ID
//        tabela.getColumnModel().getColumn(0).setMinWidth(0);
//        tabela.getColumnModel().getColumn(0).setPreferredWidth(0);
//        tabela.getColumnModel().getColumn(0).setMaxWidth(0);
            tabela.setRowHeight(25);
            modelo.setNumRows(0);


    }

    public void preencherTabelaContatos(JTable tabela, List<Contato> listaContatos) throws BusinessException {

        DefaultTableModel modelo = new DefaultTableModel();

        modelo = (DefaultTableModel) tabela.getModel();

      
        
        
        tabela.setRowHeight(25);
        modelo.setNumRows(0);

        if (!listaContatos.isEmpty()) {

            for (int i = 0; i < listaContatos.size(); i++) {
                Vector linha = new Vector();
                
                linha.add(listaContatos.get(i).getId());
                linha.add(listaContatos.get(i).getNumero());
                linha.add(listaContatos.get(i).getOperadora());
                linha.add(listaContatos.get(i).getEmail());
                linha.add(listaContatos.get(i).getObs());
                
        
                modelo.addRow(linha);

            }

        }

    }


}
