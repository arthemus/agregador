package io.fraudes.monitoramento;

import io.fraudes.domain.Transacao;
import io.fraudes.repository.TransacaoModelo;

import javax.enterprise.context.ApplicationScoped;

/**
 * Verifica e salva os dados já processados na base MongoDB.
 */
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
