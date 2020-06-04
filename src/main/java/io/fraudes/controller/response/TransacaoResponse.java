package io.fraudes.controller.response;

import io.fraudes.domain.Cliente;
import io.fraudes.repository.TransacaoModelo;

import java.util.Date;

public class TransacaoResponse {

  public final String id;

  public final String produto;

  public final String canal;

  public final Date data;

  public final Cliente cliente;

  public final String operacao;

  public TransacaoResponse(TransacaoModelo modelo) {
    this.id = modelo.id.toString();
    this.produto = modelo.produto;
    this.canal = modelo.canal;
    this.data = modelo.data;
    this.cliente = modelo.cliente;
    this.operacao = modelo.operacao;
  }

}