/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosservicio;

/**
 *
 * @author mildr
 */
public abstract class GeneradorCodigos {
    /** prefijo que identifica el tipo de codigo */
    protected String prefijo;

    // metodo abstracto validador
    /**
     * valida si un código tiene el formato correcto
     * @param codigo el codigo a validar
     * @return true si es válido, false en caso contrario
     */
    public abstract boolean tieneFormatoValido(String codigo);

    /**
     * Genera un nuevo código siguiendo un formato específico.
     * @return El código generado.
     */
    public abstract String generarCodigo();
}

