package com.compra.operador.data;

import com.compra.operador.data.utils.SearchCriteria;
import com.compra.operador.data.utils.SearchOperation;
import com.compra.operador.data.utils.SearchStatement;
import com.compra.operador.modelo.basedatos.Compra;
import com.compra.operador.modelo.basedatos.CompraDetalle;
import com.compra.operador.modelo.response.ConsultaResponseById;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class CompraRepository {
    private final CompraJpaRepository repository;
    private final CompraDetalleJpaRepository repositoryDetalle;
    public Compra guardarEncabezado(Compra compra){
        return repository.save(compra);
    }
    public CompraDetalle guardarDetalle(CompraDetalle compraDetalle){
        return repositoryDetalle.save(compraDetalle);
    }

    public ConsultaResponseById getById(Long id) {
        ConsultaResponseById resultado = new ConsultaResponseById();
        Compra encabezado = repository.findById(id).orElse(null);
        if (Objects.nonNull(encabezado)){
            SearchCriteria<CompraDetalle> spec = new SearchCriteria<>();
            spec.add(new SearchStatement("idCompra", encabezado.getId(), SearchOperation.EQUAL));
            List<CompraDetalle> listaDetalles = repositoryDetalle.findAll(spec);
            resultado.setCompra(encabezado);
            resultado.setDetalle(listaDetalles);
            return resultado;
        }else{
            return null;
        }
    }
}
