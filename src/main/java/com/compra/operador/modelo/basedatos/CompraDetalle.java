package com.compra.operador.modelo.basedatos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "compraDetalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CompraDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idCompra", unique = true)
    private Long idCompra;

    @Column(name = "idProducto")
    private Long idProducto;

    @Column(name = "valorUnitario")
    private Float valorUnitario;

    @Column(name = "cantidad")
    private Long cantidad;

    @Column(name = "valorTotal")
    private Float valorTotal;
}
