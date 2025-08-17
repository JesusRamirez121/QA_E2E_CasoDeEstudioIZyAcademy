package com.co.izyacademy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrearCategoriaModel {
    private String nombreCategoria;
    private String descripcion;
    private String dificultad;
}
