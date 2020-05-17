package io.fraudes.commons;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

/**
 * Permite obter os dados publicados na fila de mensageria e converte-los para a
 * classe {GrupoTransacao}.
 */
public class TransacaoDeserializer extends JsonbDeserializer<GrupoTransacao> {

  public TransacaoDeserializer() {
    super(GrupoTransacao.class);
  }

}