package io.fraudes.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.reactivestreams.Publisher;

import io.fraudes.repository.TransacaoModelo;
import io.fraudes.resources.response.TransacaoResponse;
import io.fraudes.scheduler.GrupoTransacao;
import io.quarkus.panache.common.Sort;

@Path("/api")
public class TransacoesResource {

    @Inject
    @Channel("banco")
    Publisher<GrupoTransacao> ultimaTransacaoBanco;

    @Inject
    @Channel("cartao")
    Publisher<GrupoTransacao> ultimaTransacaoCartao;

    @Inject
    @Channel("financiamento")
    Publisher<GrupoTransacao> ultimaTransacaoFinanciamento;

    @GET
    @Path("/stream/{canal}")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.APPLICATION_JSON)
    public Publisher<GrupoTransacao> onStream(@PathParam String canal) {
        switch (canal) {
            case "banco":
                return ultimaTransacaoBanco;
            case "cartao":
                return ultimaTransacaoCartao;
            case "financiamento":
                return ultimaTransacaoFinanciamento;
            default:
                return null;
        }
    }

    @GET
    @Path("/trasacoes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TransacaoResponse> onBuscarTransacoes() {
        List<TransacaoModelo> data = TransacaoModelo.findAll(Sort.by("data").descending()).range(0, 1000).list();
        return data.stream().map(TransacaoResponse::new).collect(Collectors.toList());
    }
}
