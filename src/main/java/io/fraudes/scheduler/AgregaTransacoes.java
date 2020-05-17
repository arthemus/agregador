package io.fraudes.scheduler;

import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.fraudes.monitoramento.Banco;
import io.fraudes.monitoramento.CartaoCredito;
import io.fraudes.monitoramento.Financiamento;
import io.fraudes.monitoramento.MonitoraTransacoes;
import io.fraudes.monitoramento.ProcessaTransacoes;
import io.reactivex.Flowable;

@ApplicationScoped
public class AgregaTransacoes {

  @Inject
  ProcessaTransacoes processaTransacoes;

  @Inject
  Banco banco;

  @Inject
  CartaoCredito cartaoCredito;

  @Inject
  Financiamento financiamento;

  @Outgoing("transacao-banco")
  Flowable<GrupoTransacao> processarBanco() {
    return Flowable.interval(1, TimeUnit.SECONDS).map(o -> {
      return new GrupoTransacao(processaTransacoes.processar(banco));
    });
  }

  @Outgoing("transacao-cartao")
  Flowable<GrupoTransacao> processarCartao() {
    return Flowable.interval(1, TimeUnit.SECONDS).map(o -> {
      return new GrupoTransacao(processaTransacoes.processar(cartaoCredito));
    });
  }

  @Outgoing("transacao-financiamento")
  Flowable<GrupoTransacao> processarFinanciamento() {
    return Flowable.interval(1, TimeUnit.SECONDS).map(o -> {
      return new GrupoTransacao(processaTransacoes.processar(financiamento));
    });
  }

}