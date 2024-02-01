package com.compra.operador.modelo.request;

import com.compra.operador.modelo.Detalle;
import com.compra.operador.modelo.Encabezado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraRequest {
    private Encabezado encabezado;
    private List<Detalle> detalles;
}
