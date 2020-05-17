package io.fraudes.monitoramento;

import java.util.Date;
import java.util.List;

import io.fraudes.domain.Transacao;

public interface MonitoraTransacoes {

  List<Transacao> buscar(Date data);

}