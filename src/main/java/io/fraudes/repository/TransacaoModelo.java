package io.fraudes.repository;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;

import io.fraudes.domain.Cliente;
import io.fraudes.domain.Transacao;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class TransacaoModelo extends PanacheMongoEntity {

  public ObjectId id;

  public String produto;

  public String canal;

  public Date data;

  public Cliente cliente;

  public String operacao;

  public TransacaoModelo() {

  }

  public TransacaoModelo(Transacao transacao) {
    this.produto = transacao.getProduto();
    this.canal = transacao.getCanal();
    this.data = transacao.getData();
    this.cliente = transacao.getCliente();
    this.operacao = transacao.getOperacao();
  }

}