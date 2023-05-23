package org.gestionlogistica.repositorios.glclient;

import org.gestionlogistica.gateways.GlClientAdapterRepository;
import org.gestionlogistica.model.GlClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GlClientAdapterRepositoryImpl implements GlClientAdapterRepository
{
    private final GlClienteRepository glClienteRepository;

    public GlClientAdapterRepositoryImpl(GlClienteRepository glClienteRepository){
        this.glClienteRepository = glClienteRepository;
    }

    public Mono<GlClient> save(GlClient glClient){
        return glClienteRepository.save(glClient);
    }

    public Mono<Void> delete(String id){
         return glClienteRepository.deleteById(id);
    }

    public Flux<GlClient> findClientes(String pattern){
            return glClienteRepository.findClientes(pattern);
    }
}
