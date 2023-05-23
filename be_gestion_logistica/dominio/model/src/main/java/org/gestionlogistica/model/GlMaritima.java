package org.gestionlogistica.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class GlMaritima {

    @Column(value = "TIPO_PRODUCTO")
    private String tipoProducto;
    @Column(value = "CANTIDAD_PRODUCTO")
    private int cantidadProdcuto;
    @Column(value = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;
    @Column(value = "FECHA_ENTREGA")
    private LocalDateTime fechaEntrega;
    @Column(value = "BODEGA_ENTREGA")
    private int bodegaEntrega;
    @Column(value = "PRECIO_ENVIO")
    private BigDecimal precioEnvio;
}
