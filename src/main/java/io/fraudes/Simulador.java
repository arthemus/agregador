package io.fraudes;

import io.fraudes.commons.Canal;
import io.fraudes.commons.Operacao;
import io.fraudes.commons.Produto;
import io.fraudes.domain.Cliente;
import io.fraudes.domain.Transacao;
import io.fraudes.scheduler.AgregaTransacoes;
import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * Essa classe simula a criação de 10 transações dos tipo BANCO, CARTOES e
 * FINANCIAMENTO de forma randômica de 10 em 10 segundos. A data de cada
 * transação pode estar entre o dia corrente e 15 dias a frente. As transações
 * são salvas na instancia do banco MySQL e posteriormente lidas e processadas
 * pela classe {@link AgregaTransacoes}.
 */
@ApplicationScoped
public class Simulador {

    private static final Random RND = new Random();

    private static final Canal[] CANAIS = Canal.values();

    private static final Operacao[] OPERACOES = Operacao.values();

    private static final Instant INICIAL = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();

    private static final Instant FINAL = LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant();

    private static final String[] CLIENTES = {"Jose", "Maria", "Manuel", "Arthemus", "Vanessa"};

    @Inject
    EntityManager entityManager;

    @Scheduled(every = "10s")
    void gerarTransacoesTeste() {
        Cliente cliente = this.buscarNovoCliente();
        this.criarTransacoesBanco(cliente);
        this.criarTransacoesCartao(cliente);
        this.criarTransacoesFinanciamento(cliente);
    }

    @Transactional
    Cliente buscarNovoCliente() {
        Cliente cliente = new Cliente(CLIENTES[RND.nextInt(CLIENTES.length)], RND.nextInt(9999), RND.nextInt(99999));
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    void criarTransacoesBanco(Cliente cliente) {
        IntStream.range(1, 10).forEach(o -> {
            Transacao transacao = new Transacao();
            transacao.setProduto(Produto.BANCO.name());
            transacao.setCanal(CANAIS[RND.nextInt(CANAIS.length)].name());
            transacao.setOperacao(OPERACOES[RND.nextInt(OPERACOES.length)].name());
            transacao.setData(new Date(ThreadLocalRandom.current().nextLong(INICIAL.toEpochMilli(),
                    FINAL.toEpochMilli())));
            transacao.setCliente(cliente);
            entityManager.persist(transacao);
        });
    }

    @Transactional
    void criarTransacoesCartao(Cliente cliente) {
        IntStream.range(1, 10).forEach(o -> {
            Transacao transacao = new Transacao();
            transacao.setProduto(Produto.CARTAO_CREDITO.name());
            transacao.setCanal(CANAIS[RND.nextInt(CANAIS.length)].name());
            transacao.setOperacao(Operacao.PAGAMENTO_CARTAO.name());
            transacao.setData(new Date(ThreadLocalRandom.current().nextLong(INICIAL.toEpochMilli(),
                    FINAL.toEpochMilli())));
            transacao.setCliente(cliente);
            entityManager.persist(transacao);
        });
    }

    @Transactional
    void criarTransacoesFinanciamento(Cliente cliente) {
        IntStream.range(1, 10).forEach(o -> {
            Transacao transacao = new Transacao();
            transacao.setProduto(Produto.FINANCIAMENTO.name());
            transacao.setCanal(CANAIS[RND.nextInt(CANAIS.length)].name());
            transacao.setOperacao(Operacao.EMPRESTIMO.name());
            transacao.setData(new Date(ThreadLocalRandom.current().nextLong(INICIAL.toEpochMilli(),
                    FINAL.toEpochMilli())));
            transacao.setCliente(cliente);
            entityManager.persist(transacao);
        });
    }

}