package io.fraudes.domain;

public class Cliente {

  private String nome;

  private int agencia;

  private int conta;

  public Cliente() {

  }

  public Cliente(String nome, int agencia, int conta) {
    this.nome = nome;
    this.agencia = agencia;
    this.conta = conta;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getAgencia() {
    return agencia;
  }

  public void setAgencia(int agencia) {
    this.agencia = agencia;
  }

  public int getConta() {
    return conta;
  }

  public void setConta(int conta) {
    this.conta = conta;
  }

  @Override
  public String toString() {
    return "Cliente [agencia=" + agencia + ", conta=" + conta + ", nome=" + nome + "]";
  }

}
