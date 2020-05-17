package io.fraudes.scheduler;

import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.fraudes.monitoramento.ProcessaTransacoes;
import io.reactivex.Flowable;

@ApplicationScoped
public class AgregaTransacoes {

  @Inject
  ProcessaTransacoes processaTransacoes;

  @Outgoing("transacao-banco")
  Flowable<String> processarBanco() {
    return Flowable.interval(5, TimeUnit.SECONDS).map(o -> processaTransacoes.banco());
  }

  @Outgoing("transacao-cartao")
  Flowable<String> processarCartao() {
    return Flowable.interval(5, TimeUnit.SECONDS).map(o -> processaTransacoes.cartao());
  }

  @Outgoing("transacao-financiamento")
  Flowable<String> processarFinanciamento() {
    return Flowable.interval(5, TimeUnit.SECONDS).map(o -> processaTransacoes.financiamento());
  }

}