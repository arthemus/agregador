package io.fraudes.monitoramento;

import io.fraudes.domain.Transacao;

import java.util.Date;
import java.util.List;

public interface MonitoraTransacoes {

  List<Transacao> buscar(Date data);

}