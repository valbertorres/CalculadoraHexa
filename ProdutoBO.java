/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intersys.igestao.modulos.cadastro.produto;

import com.intersys.igestao.sistema.util.UtilMessage;
import com.intersys.igestao.sistema.util.UtilVariados;
import java.io.Serializable;

/**
 *
 * @author LUIS-GUSTAVO
 */
public class ProdutoBO implements Serializable {

  private static ProdutoBO instancia;

  public static synchronized ProdutoBO getInstancia() {
    if (instancia == null) {
      instancia = new ProdutoBO();
    }
    return instancia;
  }

  private ProdutoView produtoView;
  private ProdutoTO produtoTO;

  private void validar() throws Exception {
    String codigo = this.produtoView.getTfCodigo().getText();
    String descricao = this.produtoView.getTfDescricao().getText();

    if (codigo.isEmpty()) {
      throw new Exception("Código deve ser preenchido!");
    }

    if (UtilVariados.naoEnumero(codigo)) {
      throw new Exception("Código deve ser somente numeros!");
    }
    
    if (descricao.isEmpty()) {
      throw new Exception("Descrição deve ser preenchido!");
    }
    
    produtoTO = new ProdutoTO();
    produtoTO.setCodigo(new Long(codigo));
    produtoTO.setDescricao(descricao);
  }

  public void inserir() throws Exception {
    this.validar();

    this.produtoView.getTfaResposta().setText(produtoTO.toString());
  }

  public ProdutoView getProdutoView() {
    return produtoView;
  }

  public void setProdutoView(ProdutoView produtoView) {
    this.produtoView = produtoView;
  }

  public ProdutoTO getProdutoTO() {
    return produtoTO;
  }

  public void setProdutoTO(ProdutoTO produtoTO) {
    this.produtoTO = produtoTO;
  }
}
