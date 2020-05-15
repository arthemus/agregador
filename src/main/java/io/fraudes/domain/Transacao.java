package io.fraudes.domain;

import java.io.Serializable;
import java.util.Date;

public class Transacao implements Serializable {

  private static final long serialVersionUID = 2201170286032164365L;

  private String produto;

  private String canal;

  private Date data;

  private Cliente cliente;

  private String operacao;

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public String getCanal() {
    return canal;
  }

  public void setCanal(String canal) {
    this.canal = canal;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getOperacao() {
    return operacao;
  }

  public void setOperacao(String operacao) {
    this.operacao = operacao;
  }

  @Override
  public String toString() {
    return "Transacao [canal=" + canal + ", cliente=" + cliente + ", data=" + data + ", operacao=" + operacao
        + ", produto=" + produto + "]";
  }

}
