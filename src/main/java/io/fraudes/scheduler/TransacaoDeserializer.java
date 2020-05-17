package io.fraudes.scheduler;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class TransacaoDeserializer extends JsonbDeserializer<GrupoTransacao> {

  public TransacaoDeserializer() {
    super(GrupoTransacao.class);
  }

}