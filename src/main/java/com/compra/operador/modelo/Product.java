package com.compra.operador.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {

    private Long idproducto;
    private String codigo;
    private String nombre;
    private String categoria;
    private String descripcioncorta;
    private String descripcionlarga;
    private String imagen;
    private Double valorunitario;
    private Integer cantidadisponible;
    private Boolean indEliminado;
    private String imagenbase64;
}

