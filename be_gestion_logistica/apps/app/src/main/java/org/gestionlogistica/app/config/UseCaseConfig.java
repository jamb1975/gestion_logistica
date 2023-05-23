package org.gestionlogistica.app.config;

import org.gestionlogistica.gateways.GlClientAdapterRepository;
import org.gestionlogistica.gateways.GlClienteUseCaseRepository;
import org.gestionlogistica.usecase.GlClientUseCase;
import org.springframework.context.annotation.Bean;

public class UseCaseConfig {

    @Bean
    public GlClienteUseCaseRepository glClienteUseCaseRepository(GlClientAdapterRepository glClientRepository){
        return new GlClientUseCase(glClientRepository);
    }

}
