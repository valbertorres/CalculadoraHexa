/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intersys.igestao.modulos.cadastro.produto;

import com.intersys.igestao.sistema.util.UtilMessage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author LUIS-GUSTAVO
 */
public class ProdutoViewCtrl implements Serializable {

  private static ProdutoViewCtrl instancia;

  public static synchronized ProdutoViewCtrl getInstancia() {
    if (instancia == null) {
      instancia = new ProdutoViewCtrl();
    }
    return instancia;
  }

  private ProdutoView produtoView;

  private JButton btnGravar;
  private JButton btnHabilitar;

  public void inicializar() {
    this.iniciarComponentes();
    this.desabilitarComponentes();
    this.iniciarListener();
  }

  private void iniciarComponentes() {
    this.btnGravar = this.produtoView.getBtnGravar();
    this.btnHabilitar = this.produtoView.getBtnHabilitarDesabilitar();
  }

  private void iniciarListener() {
    this.btnGravar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          ProdutoCtrl produtoCtrl = ProdutoCtrl.getInstancia();
          produtoCtrl.setProdutoView(produtoView);
          produtoCtrl.inserir();
          
          UtilMessage.messageConfirmar("Produto gravado com sucessso!");
        } catch (Exception ex) {
          validarMensagem(ex.getMessage());
        }
      }
    });

    this.btnHabilitar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (btnHabilitar.getText().equals("Habilitar")) {
          btnHabilitar.setText("Desabilitar");
          habilitarComponentes();
        } else {
          btnHabilitar.setText("Habilitar");
          desabilitarComponentes();
        }
      }
    });
  }

  private void habilitarComponentes() {
    this.habilitarDesabilitarComponentes(true);
  }

  private void desabilitarComponentes() {
    this.habilitarDesabilitarComponentes(false);
  }

  private void habilitarDesabilitarComponentes(boolean habilitar) {
    if (habilitar) {
      this.produtoView.getTfCodigo().setEditable(true);
      this.produtoView.getTfDescricao().setEditable(true);
      this.produtoView.getTfaResposta().setEditable(true);

      this.produtoView.getBtnGravar().setEnabled(true);
      
      this.produtoView.getTfCodigo().requestFocus();
    } else {
      this.produtoView.getTfCodigo().setEditable(false);
      this.produtoView.getTfDescricao().setEditable(false);
      this.produtoView.getTfaResposta().setEditable(false);

      this.produtoView.getBtnGravar().setEnabled(false);
    }
  }

  private void validarMensagem(String strMessage) {
    int resposta = UtilMessage.messageConfirmar(strMessage);
          System.out.println("testese de mesnagem "+strMessage);

    if (resposta == 0) {
      if (strMessage.contains("Código")) {
        this.produtoView.getTfCodigo().requestFocus();

        if (this.produtoView.getTfCodigo().getText().length() > 0) {
          this.produtoView.getTfCodigo().selectAll();
        }
      }

      if (strMessage.contains("Descrição")) {
        this.produtoView.getTfDescricao().requestFocus();

        if (this.produtoView.getTfDescricao().getText().length() > 0) {
          this.produtoView.getTfDescricao().selectAll();
        }
      }
    }
  }

  public ProdutoView getProdutoView() {
    return produtoView;
  }

  public void setProdutoView(ProdutoView produtoView) {
    this.produtoView = produtoView;
  }

  public JButton getBtnGravar() {
    return btnGravar;
  }

  public void setBtnGravar(JButton btnGravar) {
    this.btnGravar = btnGravar;
  }

  public JButton getBtnHabilitar() {
    return btnHabilitar;
  }

  public void setBtnHabilitar(JButton btnHabilitar) {
    this.btnHabilitar = btnHabilitar;
  }
}
