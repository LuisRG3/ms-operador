package com.compra.operador.modelo.response;

import com.compra.operador.modelo.basedatos.Compra;
import com.compra.operador.modelo.basedatos.CompraDetalle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaResponseById {
    private Compra compra;
    private List<CompraDetalle> detalle;
}
