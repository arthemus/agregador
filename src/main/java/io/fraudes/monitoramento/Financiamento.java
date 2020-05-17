package io.fraudes.monitoramento;

import io.fraudes.domain.Transacao;
import io.fraudes.utils.TransacaoFalsa;

public class Financiamento implements MonitoraTransacoes {

  @Override
  public Transacao buscar() {
    return TransacaoFalsa.financiamento();
  }

}