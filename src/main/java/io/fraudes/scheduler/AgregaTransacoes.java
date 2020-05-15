package io.fraudes.scheduler;

import javax.enterprise.context.ApplicationScoped;

import io.fraudes.monitoramento.ProcessaTransacoes;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class AgregaTransacoes {

  private final ProcessaTransacoes processaTransacoes;

  AgregaTransacoes(ProcessaTransacoes processaTransacoes) {
    this.processaTransacoes = processaTransacoes;
  }

  @Scheduled(every = "{agregador.schedule.buscarTransacoes.time}")
  void processarTransacoes() {
    this.processaTransacoes.start();
  }

}