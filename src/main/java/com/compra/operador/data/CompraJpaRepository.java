package com.compra.operador.data;

import com.compra.operador.modelo.basedatos.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompraJpaRepository extends JpaRepository<Compra, Long>, JpaSpecificationExecutor<Compra> {
}
