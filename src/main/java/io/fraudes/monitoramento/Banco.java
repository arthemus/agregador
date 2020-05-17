package io.fraudes.monitoramento;

import io.fraudes.domain.Transacao;
import io.fraudes.utils.TransacaoFalsa;

public class Banco implements MonitoraTransacoes {

  @Override
  public Transacao buscar() {
    return TransacaoFalsa.banco();
  }

}