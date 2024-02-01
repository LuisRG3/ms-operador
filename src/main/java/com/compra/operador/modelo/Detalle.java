package com.compra.operador.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Detalle {
    private Long idCompra;
    private Long idProducto;
    private Float valorUnitario;
    private Long cantidad;
    private Float valorTotal;
}
