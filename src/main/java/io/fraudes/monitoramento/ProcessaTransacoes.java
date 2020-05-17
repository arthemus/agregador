package io.fraudes.monitoramento;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import io.fraudes.domain.Transacao;

@ApplicationScoped
public class ProcessaTransacoes {

  private final Registrador registrador;

  public ProcessaTransacoes(Registrador registrador) {
    this.registrador = registrador;
  }

  public List<String> processar(MonitoraTransacoes monitor) {
    List<Transacao> transacoes = monitor.buscar(new Date());
    return transacoes.stream()
        .map(this.registrador::salvarTransacao)
        .filter(o -> !o.equals("-1"))
        .collect(Collectors.toList());
  }

}