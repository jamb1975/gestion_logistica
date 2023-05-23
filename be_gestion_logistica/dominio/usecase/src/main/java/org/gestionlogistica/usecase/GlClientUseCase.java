package org.gestionlogistica.usecase;

import org.gestionlogistica.gateways.GlClientAdapterRepository;
import org.gestionlogistica.gateways.GlClienteUseCaseRepository;
import org.gestionlogistica.model.GlClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GlClientUseCase implements GlClienteUseCaseRepository {

    private final GlClientAdapterRepository glClientRepository;

    public GlClientUseCase(GlClientAdapterRepository glClientRepository){
        this.glClientRepository = glClientRepository;
    }


    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
      return  request.bodyToMono(GlClient.class)
                .flatMap(glCliente ->glClientRepository.save(glCliente))
                .then(ServerResponse.ok().build())
                .onErrorResume(e -> ServerResponse.badRequest().build());



    }

    @Override
    public Mono<ServerResponse> delete(ServerRequest request) {
     return
                glClientRepository.delete(request.pathVariable("id"))
                .then()
                .then(ServerResponse.noContent().build())
                .onErrorResume(e -> ServerResponse.badRequest().build());
    }

    @Override
    public Mono<ServerResponse> findClientes(ServerRequest request) {
      return  request.bodyToMono(String.class)
                .flatMap(pat -> glClientRepository.findClientes(pat)
                        .collectList())
                .flatMap(glClientList ->ServerResponse.ok().bodyValue(glClientList))
                .onErrorResume(e -> ServerResponse.badRequest().build());

    }
}
