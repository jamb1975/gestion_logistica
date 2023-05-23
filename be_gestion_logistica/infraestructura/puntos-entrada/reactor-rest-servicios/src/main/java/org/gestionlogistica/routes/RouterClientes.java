package org.gestionlogistica.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.gestionlogistica.usecase.GlClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;



/**
 * 
 * @author javier.murcia
 * @since 1.0
 * @mail ingenierojaviermurcia@gmail.com
 * @company ISOFT
 */

@Configuration
public class RouterClientes {
		
	@Bean
	public RouterFunction<ServerResponse> routes(GlClientUseCase glClientUseCase) {
		 
		return route(POST("/api/clientes/create"), glClientUseCase::save)
				.andRoute(DELETE("/api/clientes/{id}"), glClientUseCase::delete)
				.andRoute(GET("/api/clientes/{patttern}"), glClientUseCase::findClientes)
				.andRoute(PUT("/api/clientes"), glClientUseCase::save);
				
	}

}
