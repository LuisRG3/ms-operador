package com.compra.operador.servicio;

import com.compra.operador.modelo.request.CompraRequest;
import com.compra.operador.modelo.response.CompraResponse;
import com.compra.operador.modelo.response.CompraCompleta;

import java.util.List;

public interface CompraServicio {
    com.compra.operador.modelo.basedatos.Compra validarRequest(CompraRequest request);
    CompraResponse crearEncabezado(CompraRequest request);
    CompraCompleta getCompra(Long idCompra);
    List<CompraCompleta> getCompra();
}
