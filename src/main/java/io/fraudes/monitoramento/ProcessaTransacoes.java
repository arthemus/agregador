package io.fraudes.monitoramento;

import io.fraudes.domain.Transacao;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProcessaTransacoes {

  private final Registrador registrador;

  public ProcessaTransacoes(Registrador registrador) {
    this.registrador = registrador;
  }

  /**
   * Retorna apenas novas transações processadas.
   */
  public List<String> processar(MonitoraTransacoes monitor) {
    List<Transacao> transacoes = monitor.buscar(new Date());
    return transacoes.stream()
            .map(this.registrador::salvarTransacao)
            .filter(o -> !o.equals("-1"))
            .collect(Collectors.toList());
  }

}