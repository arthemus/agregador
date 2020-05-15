package io.fraudes.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import io.fraudes.commons.Canal;
import io.fraudes.commons.Produto;
import io.fraudes.domain.Cliente;
import io.fraudes.domain.Operacao;
import io.fraudes.domain.Transacao;

public final class TransacaoFalsa {

  private static final Random RND = new Random();

  private static final Produto[] PRODUTOS = Produto.values();

  private static final Canal[] CANAIS = Canal.values();

  private static final Operacao[] OPERACOES = Operacao.values();

  private static final Instant INICIAL = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();

  private static final Instant FINAL = LocalDate.now().plusDays(30).atStartOfDay(ZoneId.systemDefault()).toInstant();

  public static Transacao get() {
    Transacao transacao = new Transacao();
    transacao.setProduto(PRODUTOS[RND.nextInt(PRODUTOS.length)].name());
    transacao.setCanal(CANAIS[RND.nextInt(CANAIS.length)].name());
    transacao.setOperacao(OPERACOES[RND.nextInt(OPERACOES.length)].name());
    transacao.setData(new Date(ThreadLocalRandom.current().nextLong(INICIAL.toEpochMilli(), FINAL.toEpochMilli())));
    transacao.setCliente(new Cliente("Jose", 0001, 31320));
    return transacao;
  }

}