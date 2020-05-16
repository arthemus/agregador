package io.fraudes.resources;

import io.fraudes.repository.TransacaoModelo;
import io.fraudes.resources.response.TransacaoResponse;
import io.quarkus.panache.common.Sort;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/transacao")
public class TransacoesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TransacaoResponse> onBuscarTransacoes() {
        List<TransacaoModelo> data = TransacaoModelo.findAll(Sort.by("data").descending()).list();
        return data.stream().map(TransacaoResponse::new).collect(Collectors.toList());
    }
}
