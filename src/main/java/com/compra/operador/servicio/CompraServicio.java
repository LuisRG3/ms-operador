package com.compra.operador.servicio;

import com.compra.operador.modelo.basedatos.Compra;
import com.compra.operador.modelo.request.CompraRequest;
import com.compra.operador.modelo.response.CompraResponse;
import com.compra.operador.modelo.response.ConsultaResponseById;

public interface CompraServicio {
    Compra validarRequest(CompraRequest request);
    CompraResponse crearEncabezado(CompraRequest request);

    ConsultaResponseById getCompra(Long idCompra);
}
