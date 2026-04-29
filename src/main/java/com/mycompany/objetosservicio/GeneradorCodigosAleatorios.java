/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosservicio;

import java.util.Random;
/**
 *
 * @author mildr
 */
public class GeneradorCodigosAleatorios extends GeneradorCodigos {
    
public GeneradorCodigosAleatorios() {
        this.prefijo = "ALE";
    }

    /**
     * Genera un numero aleatorio formateado a 4 dígitos.
     * @return string con numero entre 0001 y 9998.
     */
    public static String obtenerAleatorio() {
        Random random = new Random();
        int numero = random.nextInt(9998) + 1;
        return String.format("%04d", numero);
    }

    @Override
    public boolean tieneFormatoValido(String codigo) {
        if (codigo == null || !codigo.startsWith("ALE-")) return false;
        String parteNumerica = codigo.substring(4);
        return parteNumerica.length() == 4 && parteNumerica.chars().allMatch(Character::isDigit);
    }

    @Override
    public String generarCodigo() {
        System.out.println("código generado");
        return "ALE-" + obtenerAleatorio();
    }
}
