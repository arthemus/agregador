package io.fraudes.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String produto;

  private String canal;

  @Temporal(TemporalType.DATE)
  private Date data;

  @ManyToOne
  private Cliente cliente;

  private String operacao;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Transacao other = (Transacao) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
