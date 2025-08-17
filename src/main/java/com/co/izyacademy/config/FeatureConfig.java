package com.co.izyacademy.config;

public class FeatureConfig {
    private final String rutaFeature;
    private final String rutaExcel;
    private final Class<?> claseModelo;
    private final String[] nombresCampos;

    public FeatureConfig(String rutaFeature, String rutaExcel, Class<?> claseModelo, String... nombresCampos) {
        this.rutaFeature = rutaFeature;
        this.rutaExcel = rutaExcel;
        this.claseModelo = claseModelo;
        this.nombresCampos = nombresCampos;
    }

    // Getters
    public String getRutaFeature() { return rutaFeature; }
    public String getRutaExcel() { return rutaExcel; }
    public Class<?> getClaseModelo() { return claseModelo; }
    public String[] getNombresCampos() { return nombresCampos; }

}
