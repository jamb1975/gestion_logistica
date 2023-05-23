package org.gestionlogistica.gateways;

import org.gestionlogistica.model.GlClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GlClientAdapterRepository {
    public Mono<GlClient> save(GlClient glClient);
    public Mono<Void> delete(String id);
    public Flux<GlClient> findClientes(String pattern);
}
