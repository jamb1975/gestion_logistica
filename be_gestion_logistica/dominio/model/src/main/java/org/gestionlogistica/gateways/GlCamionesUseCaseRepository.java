package org.gestionlogistica.gateways;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface GlCamionesUseCaseRepository {
    public Mono<ServerResponse> save(ServerRequest request);
    public Mono<ServerResponse> delete(ServerRequest request);
    public Mono<ServerResponse> findClientes(ServerRequest request);
}
