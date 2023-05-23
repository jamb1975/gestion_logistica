package org.gestionlogistica.routes;

import org.gestionlogistica.usecase.GlCamionesUseCase;
import org.gestionlogistica.usecase.GlClientUseCase;
import org.gestionlogistica.usecase.GlMaritimaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutesMaritima {


    @Bean
    public RouterFunction<ServerResponse> routes(GlMaritimaUseCase glMaritimaUseCase) {

        return route(POST("/api/maritima/create"), glMaritimaUseCase::save)
                .andRoute(DELETE("/api/maritima/{id}"), glMaritimaUseCase::delete)
                .andRoute(GET("/api/maritima/{patttern}"), glMaritimaUseCase::findClientes)
                .andRoute(PUT("/api/maritima"), glMaritimaUseCase::save);

    }
}
