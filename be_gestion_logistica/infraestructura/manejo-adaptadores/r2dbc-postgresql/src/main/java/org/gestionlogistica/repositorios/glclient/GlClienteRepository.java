package org.gestionlogistica.repositorios.glclient;

import org.gestionlogistica.model.GlClient;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface GlClienteRepository extends ReactiveCrudRepository<GlClient, String> {
    @Query("SELECT * FROM GL_CLIENTE WHERE LOWER(NOMBRE_CLIENTE) LIKE LOWER(%:pattern%)")
    public Flux<GlClient> findClientes(String pattern);
}
