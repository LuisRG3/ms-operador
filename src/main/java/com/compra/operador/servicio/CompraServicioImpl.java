package com.compra.operador.servicio;

import com.compra.operador.data.CompraRepository;
import com.compra.operador.modelo.Detalle;
import com.compra.operador.modelo.basedatos.Compra;
import com.compra.operador.modelo.basedatos.CompraDetalle;
import com.compra.operador.modelo.request.CompraRequest;
import com.compra.operador.modelo.response.CompraResponse;
import com.compra.operador.modelo.response.CompraCompleta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class CompraServicioImpl implements CompraServicio {
    @Autowired
    private CompraRepository repository;
    @Override
    public com.compra.operador.modelo.basedatos.Compra validarRequest(CompraRequest request) {
        return null;
    }

    public CompraResponse crearEncabezado(CompraRequest request){
        CompraResponse response = new CompraResponse();
        Compra resultadoCompra = new Compra();
        CompraDetalle compraDetalle = new CompraDetalle();
        if (request != null && StringUtils.hasLength(request.getEncabezado().getComprador().trim())
                && StringUtils.hasLength(request.getEncabezado().getCiudad().trim())
                && StringUtils.hasLength(request.getEncabezado().getFecha().trim())
                && StringUtils.hasLength(request.getEncabezado().getPais().trim())
                && request.getEncabezado().getIdentificacion() != null
                && request.getEncabezado().getValorTotal() != null) {

            Compra compra = Compra.builder().comprador(request.getEncabezado().getComprador()).ciudad(request.getEncabezado().getCiudad())
                    .pais(request.getEncabezado().getPais()).identificacion(request.getEncabezado().getIdentificacion()).
                    fecha(request.getEncabezado().getFecha()).valorTotal(request.getEncabezado().getValorTotal()).build();
            resultadoCompra = repository.guardarEncabezado(compra);
            if (!request.getDetalles().isEmpty()){
                for (Detalle det : request.getDetalles()){
                    if ( det.getCantidad() > 0 && det.getValorTotal() > 0 && det.getValorUnitario() > 0 && det.getIdProducto() > 0 ){
                        CompraDetalle detalle = CompraDetalle.builder().idCompra(resultadoCompra.getId()).cantidad(det.getCantidad()).valorUnitario(det.getValorUnitario()).valorTotal(det.getValorTotal()).
                                idProducto(det.getIdProducto()).build();
                        compraDetalle = repository.guardarDetalle(detalle);
                    } else {
                        return null;
                    }
                }
            }
            response.setIdCompra(resultadoCompra.getId());
            response.setDescripcion("Compra Realizada Exitosamente");
            return response;
        } else {
            return null;
        }
    }

    @Override
    public CompraCompleta getCompra(Long idCompra) {
        CompraCompleta consultaResponseById = new CompraCompleta();
        consultaResponseById = repository.getById(idCompra);

        return consultaResponseById;
    }

    @Override
    public List<CompraCompleta> getCompra() {
        List<CompraCompleta> orders = repository.findAllCompras();
        return orders.isEmpty() ? null : orders;
    }


}
