package com.compra.operador.controlador;

import com.compra.operador.modelo.request.CompraRequest;
import com.compra.operador.modelo.response.CompraResponse;
import com.compra.operador.modelo.response.CompraCompleta;
import com.compra.operador.servicio.CompraServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CompraControlador {
    private final CompraServicio servicio;

    @PostMapping("/compras")
    @Operation(
            operationId = "Insertar una venta",
            description = "Operacion de escritura",
            summary = "Se crea una venta a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la venta a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraRequest.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el producto con el identificador indicado.")
    public ResponseEntity<CompraResponse> crearCompra(@RequestBody CompraRequest request){
        CompraResponse compra = servicio.crearEncabezado(request);
        if(compra != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(compra);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/compras")
    @Operation(operationId = "Obtener la compra",
            description = "Operacion de lectura",
            summary = "Se devuelve la compra realizada a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraCompleta.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado la compra con el identificador indicado.")
    public ResponseEntity<List<CompraCompleta>> getOrders() {

        List<CompraCompleta> compras = servicio.getCompra();
        if (compras != null) {
            return ResponseEntity.ok(compras);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/compras/{idCompra}")
    @Operation(operationId = "Obtener la compra",
            description = "Operacion de lectura",
            summary = "Se devuelve la compra realizada a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompraCompleta.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado la compra con el identificador indicado.")
    public ResponseEntity<CompraCompleta> getCompra(@PathVariable Long idCompra){
        CompraCompleta consultaCompra = servicio.getCompra(idCompra);
        if (consultaCompra != null) {
            return ResponseEntity.ok(consultaCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
