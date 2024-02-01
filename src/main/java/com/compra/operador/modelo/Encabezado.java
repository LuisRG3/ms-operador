package com.compra.operador.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Encabezado {
    private Integer identificacion;
    private Float valorTotal;
    private String comprador;
    private String fecha;
    private String ciudad;
    private String pais;
}
