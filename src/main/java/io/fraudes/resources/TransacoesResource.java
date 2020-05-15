package io.fraudes.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.fraudes.domain.Transacao;

@Path("/transacao")
public class TransacoesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transacao> onBuscarTransacoes() {
        return new ArrayList<>();
    }
}
