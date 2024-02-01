package com.compra.operador.data;

import com.compra.operador.modelo.basedatos.Compra;
import com.compra.operador.modelo.basedatos.CompraDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompraDetalleJpaRepository extends JpaRepository<CompraDetalle, Long>, JpaSpecificationExecutor<CompraDetalle> {
}
