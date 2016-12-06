/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intersys.igestao.modulos.cadastro.produto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author LUIS-GUSTAVO
 */
public class ProdutoTO implements Serializable {

  private Long codigo;
  private String descricao;

  public ProdutoTO() {
    this.iniciarVariaveis();
  }

  public void iniciarVariaveis() {
    this.codigo = null;
    this.descricao = "";
  }

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public String toString() {
    return "ProdutoTO{" + "codigo=" + codigo + ", descricao=" + descricao + '}';
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.codigo);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ProdutoTO other = (ProdutoTO) obj;
    if (!Objects.equals(this.codigo, other.codigo)) {
      return false;
    }
    return true;
  }

}
