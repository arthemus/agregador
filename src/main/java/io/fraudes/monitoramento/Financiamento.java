package io.fraudes.monitoramento;

import io.fraudes.commons.Produto;
import io.fraudes.domain.Transacao;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class Financiamento implements MonitoraTransacoes {

  private final EntityManager entityManager;

  public Financiamento(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Transacao> buscar(Date data) {
    synchronized (entityManager) {
      TypedQuery<Transacao> query = this.entityManager.createQuery(
              "SELECT t FROM Transacao t WHERE (1=1) AND (t.produto = :produto) AND (t.data = :data)", Transacao.class);
      query.setParameter("produto", Produto.FINANCIAMENTO.name());
      query.setParameter("data", data);
      return query.getResultList();
    }
  }

}