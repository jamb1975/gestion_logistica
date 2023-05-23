package org.gestionlogistica.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder(toBuilder = true)
public class GlClient {


    @Column(value = "ID_CLIENTE")
    private String idCliente;
    @Column(value = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Column(value = "DIR_CLIENTE")
    private String dirCliente;
    @Column(value = "CELULAR_CLIENTE")
    private String celularCliente;
    @Column(value = "EMAIL_CLIENTE")
    private Long emailCliente;
}
