package io.fraudes.monitoramento;

import javax.enterprise.context.ApplicationScoped;

import io.fraudes.domain.Transacao;
import io.fraudes.repository.TransacaoModelo;

@ApplicationScoped
public class Registrador {

  String salvarTransacao(Transacao transacao) {
    try {
      TransacaoModelo existente = TransacaoModelo.find("idInterno", transacao.getId()).firstResult();
      if (existente == null) {
        TransacaoModelo modelo = new TransacaoModelo(transacao);
        modelo.persist();
        return modelo.id.toString();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "-1";
  }

}
