package org.gestionlogistica.gateways;

import org.gestionlogistica.model.GlCamiones;
import org.gestionlogistica.model.GlClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GlCamionesAdapterRepository {

    public Mono<GlCamiones> save(GlCamiones glCamiones);
    public Mono<Void> delete(String id);
    public Flux<GlCamiones> findCamiones(String pattern);

}
