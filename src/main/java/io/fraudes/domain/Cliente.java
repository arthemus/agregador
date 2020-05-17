package io.fraudes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private Integer agencia;

  private Integer conta;

  public Cliente() {

  }

  public Cliente(String nome, Integer agencia, Integer conta) {
    this.nome = nome;
    this.agencia = agencia;
    this.conta = conta;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getAgencia() {
    return agencia;
  }

  public void setAgencia(Integer agencia) {
    this.agencia = agencia;
  }

  public Integer getConta() {
    return conta;
  }

  public void setConta(Integer conta) {
    this.conta = conta;
  }

  @Override
  public String toString() {
    return "Cliente [agencia=" + agencia + ", conta=" + conta + ", nome=" + nome + "]";
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
    Cliente other = (Cliente) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
