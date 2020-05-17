package io.fraudes.monitoramento;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import io.fraudes.commons.Produto;
import io.fraudes.domain.Transacao;

@ApplicationScoped
public class CartaoCredito implements MonitoraTransacoes {

  private final EntityManager entityManager;

  public CartaoCredito(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Transacao> buscar(Date data) {
    synchronized(entityManager) {
      TypedQuery<Transacao> query = this.entityManager.createQuery(
          "SELECT t FROM Transacao t WHERE (1=1) AND (t.produto = :produto) AND (t.data = :data)", Transacao.class);
      query.setParameter("produto", Produto.CARTAO_CREDITO.name());
      query.setParameter("data", data);
      return query.getResultList();
    }
  }

}