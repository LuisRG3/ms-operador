package com.compra.operador.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGenerator {

    public String generateJsonString(int cantidadDisponible) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(new JsonData(cantidadDisponible));
            return jsonString;
        } catch (Exception e) {
            // Manejar la excepción, por ejemplo, imprimir un mensaje de error
            e.printStackTrace();
            return null;
        }
    }

    static class JsonData {
        private int cantidadisponible;

        public JsonData(int cantidadisponible) {
            this.cantidadisponible = cantidadisponible;
        }

        public int getCantidadisponible() {
            return cantidadisponible;
        }

        public void setCantidadisponible(int cantidadisponible) {
            this.cantidadisponible = cantidadisponible;
        }
    }
}

