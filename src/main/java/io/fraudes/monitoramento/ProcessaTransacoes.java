package io.fraudes.monitoramento;

import javax.enterprise.context.ApplicationScoped;

import io.fraudes.domain.Transacao;

@ApplicationScoped
public class ProcessaTransacoes {

  private final Registrador registrador;

  private final MonitoraTransacoes banco = new Banco();

  private final MonitoraTransacoes cartao = new CartaoCredito();

  private final MonitoraTransacoes financiamento = new Financiamento();

  public ProcessaTransacoes(Registrador registrador) {
    this.registrador = registrador;
  }

  public String banco() {
    Transacao transacao = this.banco.buscar();
    return this.registrador.salvarTransacao(transacao);
  }

  public String cartao() {
    Transacao transacao = this.cartao.buscar();
    return this.registrador.salvarTransacao(transacao);
  }

  public String financiamento() {
    Transacao transacao = this.financiamento.buscar();
    return this.registrador.salvarTransacao(transacao);
  }

}