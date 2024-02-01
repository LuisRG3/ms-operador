package com.compra.operador.modelo.basedatos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "compra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identificacion")
    private Integer identificacion;

    @Column(name = "valorTotal")
    private Float valorTotal;

    @Column(name = "comprador")
    private String comprador;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "pais")
    private String pais;
}
