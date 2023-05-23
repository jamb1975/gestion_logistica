package org.gestionlogistica.gateways;

import org.gestionlogistica.model.GlClient;
import org.gestionlogistica.model.GlMaritima;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GlMaritimaAdapterRepository {

    public Mono<GlMaritima> save(GlMaritima glMaritima);
    public Mono<Void> delete(String id);
    public Flux<GlMaritima> findMaritima(String pattern);

}
