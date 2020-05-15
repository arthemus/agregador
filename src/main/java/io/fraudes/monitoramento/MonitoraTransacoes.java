package io.fraudes.monitoramento;

import java.util.Collection;

import io.fraudes.domain.Transacao;

public interface MonitoraTransacoes {

  Collection<Transacao> transacoes();

}