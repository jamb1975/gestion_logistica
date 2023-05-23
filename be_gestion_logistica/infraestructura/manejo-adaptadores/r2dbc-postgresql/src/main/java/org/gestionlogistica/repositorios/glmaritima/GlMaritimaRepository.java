package org.gestionlogistica.repositorios.glmaritima;

import org.gestionlogistica.model.GlCamiones;
import org.gestionlogistica.model.GlClient;
import org.gestionlogistica.model.GlMaritima;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface GlMaritimaRepository extends ReactiveCrudRepository<GlMaritima, String> {
    @Query("SELECT * FROM GL_CLIENTE WHERE LOWER(NOMBRE_CLIENTE) LIKE LOWER(%:pattern%)")
    public Flux<GlMaritima> findMaritima(String pattern);
}
