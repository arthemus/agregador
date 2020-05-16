package io.fraudes.monitoramento;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.fraudes.domain.Transacao;
import io.fraudes.utils.TransacaoFalsa;

public class Financiamento implements MonitoraTransacoes {

  @Override
  public Collection<Transacao> transacoes() {
    return Stream.generate(TransacaoFalsa::financiamento).limit(1).collect(Collectors.toList());
  }

}