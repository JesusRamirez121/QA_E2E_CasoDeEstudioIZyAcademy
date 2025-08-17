package com.co.izyacademy.utils;

import com.co.izyacademy.models.CrearCategoriaModel;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableCrearCategoriaDefinition {
    @DataTableType
    public CrearCategoriaModel crearCategoriaModelEntry(Map<String, String> entry) {
        return CrearCategoriaModel.builder()
                .nombreCategoria(entry.get("nombreCategoria"))
                .descripcion(entry.get("descripcion"))
                .dificultad(entry.get("dificultad"))
                .build();
    }
}
