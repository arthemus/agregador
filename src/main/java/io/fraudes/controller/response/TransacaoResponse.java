package io.fraudes.controller.response;

import java.util.Date;

import io.fraudes.domain.Cliente;
import io.fraudes.repository.TransacaoModelo;

public class TransacaoResponse {

    public String id;

    public String produto;

    public String canal;

    public Date data;

    public Cliente cliente;

    public String operacao;

    public TransacaoResponse(TransacaoModelo modelo) {
        this.id = modelo.id.toString();
        this.produto = modelo.produto;
        this.canal = modelo.canal;
        this.data = modelo.data;
        this.cliente = modelo.cliente;
        this.operacao = modelo.operacao;
    }

}