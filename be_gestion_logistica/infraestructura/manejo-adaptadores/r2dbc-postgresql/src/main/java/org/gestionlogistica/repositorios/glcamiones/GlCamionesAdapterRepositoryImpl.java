package org.gestionlogistica.repositorios.glcamiones;

import org.gestionlogistica.gateways.GlCamionesAdapterRepository;
import org.gestionlogistica.gateways.GlClientAdapterRepository;
import org.gestionlogistica.model.GlCamiones;
import org.gestionlogistica.model.GlClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GlCamionesAdapterRepositoryImpl implements GlCamionesAdapterRepository
{
    private final GlCamionesRepository glCamionesRepository;

    public GlCamionesAdapterRepositoryImpl(GlCamionesRepository glCamionesRepository){
        this.glCamionesRepository = glCamionesRepository;
    }

    public Mono<GlCamiones> save(GlCamiones glClient){
        return glCamionesRepository.save(GlCamiones.builder().build());
    }

    public Mono<Void> delete(String id){
         return glCamionesRepository.deleteById(id);
    }

    public Flux<GlCamiones> findCamiones(String pattern){
            return glCamionesRepository.findClientes(pattern);
    }
}
