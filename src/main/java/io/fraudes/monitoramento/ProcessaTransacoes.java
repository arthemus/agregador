package io.fraudes.monitoramento;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import io.fraudes.domain.Transacao;

@ApplicationScoped
public class ProcessaTransacoes {

  private final Set<MonitoraTransacoes> monitoradores;

  private final Registrador registrador;

  public ProcessaTransacoes(Registrador registrador) {
    this.registrador = registrador;
    this.monitoradores = Collections.synchronizedSet(new HashSet<>());
    this.monitoradores.add(new Banco());
  }

  public void start() {
    for (MonitoraTransacoes monitor : monitoradores) {
      Collection<Transacao> transacoes = monitor.transacoes();
      transacoes.stream().map(this.registrador::salvarTransacao).forEach(System.out::println);
    }
  }

}