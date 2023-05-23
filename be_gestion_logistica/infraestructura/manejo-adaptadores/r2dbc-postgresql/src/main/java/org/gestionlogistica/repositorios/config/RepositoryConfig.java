package org.gestionlogistica.repositorios.config;

import org.gestionlogistica.gateways.GlClientAdapterRepository;
import org.gestionlogistica.repositorios.glcamiones.GlCamionesAdapterRepositoryImpl;
import org.gestionlogistica.repositorios.glcamiones.GlCamionesRepository;
import org.gestionlogistica.repositorios.glclient.GlClientAdapterRepositoryImpl;
import org.gestionlogistica.repositorios.glclient.GlClienteRepository;
import org.springframework.context.annotation.Bean;

public class RepositoryConfig {

    @Bean
    public GlClientAdapterRepository glClientAdapterRepository(GlClienteRepository glClienteRepository){
        return new GlClientAdapterRepositoryImpl(glClienteRepository);
    }
}
