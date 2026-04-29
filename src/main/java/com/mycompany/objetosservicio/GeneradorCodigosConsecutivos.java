/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosservicio;
import java.util.Optional;
/**
 *
 * @author mildr
 */
public class GeneradorCodigosConsecutivos extends GeneradorCodigos {
    
      /** Valor del consecutivo actual */
    private static int consecutivo = 1;

    public GeneradorCodigosConsecutivos() {
        this.prefijo = "C0N";
    }

    /**
     * Incrementa en 1 el contador estático.
     */
    public static void incrementarConsecutivo() {
        consecutivo++;
    }

    @Override
    public boolean tieneFormatoValido(String codigo) {
        // Uso de pipelines para la validación
        return Optional.ofNullable(codigo)
                .filter(c -> c.startsWith("CON-"))
                .map(c -> c.substring(4))
                .filter(num -> num.chars().allMatch(Character::isDigit))
                .isPresent();
    }

    @Override
    public String generarCodigo() {
        System.out.println("codigo generado");
        String codigo = "C0N_" + consecutivo;
        incrementarConsecutivo();
        return codigo;
    }
}

