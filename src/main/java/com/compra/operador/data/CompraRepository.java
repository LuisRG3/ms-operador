package com.compra.operador.data;

import com.compra.operador.data.utils.SearchCriteria;
import com.compra.operador.data.utils.SearchOperation;
import com.compra.operador.data.utils.SearchStatement;
import com.compra.operador.modelo.basedatos.Compra;
import com.compra.operador.modelo.basedatos.CompraDetalle;
import com.compra.operador.modelo.response.CompraCompleta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public CompraCompleta getById(Long id) {
        CompraCompleta resultado = new CompraCompleta();
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

    public List<CompraCompleta> findAllCompras() {
        List<CompraCompleta> resultado = new ArrayList<>();
        List<Compra> compras = repository.findAll();
        if (!compras.isEmpty()){
            for (Compra compraUnica : compras) {
                CompraCompleta compratotal = new CompraCompleta();
                SearchCriteria<CompraDetalle> spec = new SearchCriteria<>();
                spec.add(new SearchStatement("idCompra", compraUnica.getId(), SearchOperation.EQUAL));
                List<CompraDetalle> listaDetalles = repositoryDetalle.findAll(spec);
                compratotal.setCompra(compraUnica);
                compratotal.setDetalle(listaDetalles);
                resultado.add(compratotal);
            }
            return resultado;
        }else{
            return null;
        }
    }
}
