package io.fraudes.monitoramento;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

import io.fraudes.domain.Transacao;

@ApplicationScoped
public class Registrador {

  String salvarTransacao(Transacao transacao) {
    System.out.println(transacao);
    return UUID.randomUUID().toString();
  }
}
