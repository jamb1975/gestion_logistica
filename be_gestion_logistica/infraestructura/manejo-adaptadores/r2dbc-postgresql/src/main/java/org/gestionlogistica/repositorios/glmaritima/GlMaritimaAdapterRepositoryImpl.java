package org.gestionlogistica.repositorios.glmaritima;

import org.gestionlogistica.gateways.GlClientAdapterRepository;
import org.gestionlogistica.gateways.GlMaritimaAdapterRepository;
import org.gestionlogistica.model.GlClient;
import org.gestionlogistica.model.GlMaritima;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GlMaritimaAdapterRepositoryImpl implements GlMaritimaAdapterRepository
{
    private final GlMaritimaRepository glMaritimaRepository;

    public GlMaritimaAdapterRepositoryImpl(GlMaritimaRepository glMaritimaRepository){
        this.glMaritimaRepository = glMaritimaRepository;
    }

    public Mono<GlMaritima> save(GlMaritima glMaritima){
        return glMaritimaRepository.save(glMaritima);
    }

    public Mono<Void> delete(String id){
         return glMaritimaRepository.deleteById(id);
    }

    public Flux<GlMaritima> findClientes(String pattern){
            return glMaritimaRepository.findMaritima(pattern);
    }
}
