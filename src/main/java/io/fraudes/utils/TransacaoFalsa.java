package io.fraudes.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import io.fraudes.commons.Canal;
import io.fraudes.commons.Produto;
import io.fraudes.commons.Operacao;
import io.fraudes.domain.Cliente;
import io.fraudes.domain.Transacao;

public final class TransacaoFalsa {

  private static final Random RND = new Random();

  private static final Canal[] CANAIS = Canal.values();

  private static final Operacao[] OPERACOES = Operacao.values();

  private static final Instant INICIAL = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();

  private static final Instant FINAL = LocalDate.now().plusDays(30).atStartOfDay(ZoneId.systemDefault()).toInstant();

  private static final String[] CLIENTES = { "Jose", "Maria", "Manuel", "Arthemus", "Vanessa" };

  public static Transacao banco() {
    Transacao transacao = new Transacao();
    transacao.setProduto(Produto.BANCO.name());
    transacao.setCanal(CANAIS[RND.nextInt(CANAIS.length)].name());
    transacao.setOperacao(OPERACOES[RND.nextInt(OPERACOES.length)].name());
    transacao.setData(new Date(ThreadLocalRandom.current().nextLong(INICIAL.toEpochMilli(), FINAL.toEpochMilli())));
    transacao.setCliente(new Cliente(CLIENTES[RND.nextInt(CLIENTES.length)], RND.nextInt(9999), RND.nextInt(99999)));
    return transacao;
  }

  public static Transacao cartao() {
    Transacao transacao = new Transacao();
    transacao.setProduto(Produto.CARTAO_CREDITO.name());
    transacao.setCanal(CANAIS[RND.nextInt(CANAIS.length)].name());
    transacao.setOperacao(Operacao.PAGAMENTO_CARTAO.name());
    transacao.setData(new Date(ThreadLocalRandom.current().nextLong(INICIAL.toEpochMilli(), FINAL.toEpochMilli())));
    transacao.setCliente(new Cliente(CLIENTES[RND.nextInt(CLIENTES.length)], RND.nextInt(9999), RND.nextInt(99999)));
    return transacao;
  }

  public static Transacao financiamento() {
    Transacao transacao = new Transacao();
    transacao.setProduto(Produto.FINANCIAMENTO.name());
    transacao.setCanal(CANAIS[RND.nextInt(CANAIS.length)].name());
    transacao.setOperacao(Operacao.EMPRESTIMO.name());
    transacao.setData(new Date(ThreadLocalRandom.current().nextLong(INICIAL.toEpochMilli(), FINAL.toEpochMilli())));
    transacao.setCliente(new Cliente(CLIENTES[RND.nextInt(CLIENTES.length)], RND.nextInt(9999), RND.nextInt(99999)));
    return transacao;
  }

}