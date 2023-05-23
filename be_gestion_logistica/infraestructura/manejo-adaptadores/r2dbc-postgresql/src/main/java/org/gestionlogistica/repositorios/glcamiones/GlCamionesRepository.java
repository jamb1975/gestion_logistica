package org.gestionlogistica.repositorios.glcamiones;

import org.gestionlogistica.model.GlCamiones;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface GlCamionesRepository extends ReactiveCrudRepository<GlCamiones, String> {
    @Query("SELECT * FROM GL_CLIENTE WHERE LOWER(NOMBRE_CLIENTE) LIKE LOWER(%:pattern%)")
    public Flux<GlCamiones> findClientes(String pattern);
}
