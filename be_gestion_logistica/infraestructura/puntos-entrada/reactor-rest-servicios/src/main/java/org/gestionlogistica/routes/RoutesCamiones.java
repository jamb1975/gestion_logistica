package org.gestionlogistica.routes;

import org.gestionlogistica.usecase.GlCamionesUseCase;
import org.gestionlogistica.usecase.GlClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutesCamiones {

    @Bean
    public RouterFunction<ServerResponse> routes(GlCamionesUseCase glCamionesUseCase) {

        return route(POST("/api/camiones/create"), glCamionesUseCase::save)
                .andRoute(DELETE("/api/camiones/{id}"), glCamionesUseCase::delete)
                .andRoute(GET("/api/camiones/{patttern}"), glCamionesUseCase::findClientes)
                .andRoute(PUT("/api/camiones"), glCamionesUseCase::save);

    }
}
