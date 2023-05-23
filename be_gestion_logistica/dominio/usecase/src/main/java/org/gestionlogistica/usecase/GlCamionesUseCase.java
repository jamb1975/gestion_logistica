package org.gestionlogistica.usecase;

import org.gestionlogistica.gateways.GlCamionesAdapterRepository;
import org.gestionlogistica.gateways.GlCamionesUseCaseRepository;
import org.gestionlogistica.gateways.GlClientAdapterRepository;
import org.gestionlogistica.gateways.GlClienteUseCaseRepository;
import org.gestionlogistica.model.GlCamiones;
import org.gestionlogistica.model.GlClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class GlCamionesUseCase implements GlCamionesUseCaseRepository {

    private final GlCamionesAdapterRepository glCamionesAdapterRepository;

    public GlCamionesUseCase(GlCamionesAdapterRepository glCamionesAdapterRepository){
        this.glCamionesAdapterRepository = glCamionesAdapterRepository;
    }


    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
      return  request.bodyToMono(GlCamiones.class)
                .flatMap(glCamiones ->glCamionesAdapterRepository.save(glCamiones))
                .then(ServerResponse.ok().build())
                .onErrorResume(e -> ServerResponse.badRequest().build());



    }

    @Override
    public Mono<ServerResponse> delete(ServerRequest request) {
     return
             glCamionesAdapterRepository.delete(request.pathVariable("id"))
                .then()
                .then(ServerResponse.noContent().build())
                .onErrorResume(e -> ServerResponse.badRequest().build());
    }

    @Override
    public Mono<ServerResponse> findClientes(ServerRequest request) {
      return  request.bodyToMono(String.class)
                .flatMap(pat -> glCamionesAdapterRepository.findCamiones(pat)
                        .collectList())
                .flatMap(glClientList ->ServerResponse.ok().bodyValue(glClientList))
                .onErrorResume(e -> ServerResponse.badRequest().build());

    }
}
