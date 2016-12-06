/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intersys.igestao.modulos.cadastro.produto;

import java.io.Serializable;

/**
 *
 * @author LUIS-GUSTAVO
 */
public class ProdutoCtrl implements Serializable {

  private static ProdutoCtrl instancia;

  public static synchronized ProdutoCtrl getInstancia() {
    if (instancia == null) {
      instancia = new ProdutoCtrl();
    }
    return instancia;
  }

  private ProdutoView produtoView;

  public void inserir() throws Exception {
    ProdutoBO produtoBO = ProdutoBO.getInstancia();
    produtoBO.setProdutoView(produtoView);
    produtoBO.inserir();
  }

  public ProdutoView getProdutoView() {
    return produtoView;
  }

  public void setProdutoView(ProdutoView produtoView) {
    this.produtoView = produtoView;
  }
}
