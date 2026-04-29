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
public class ValidadorStrings {
    public static boolean superaTamanioMaximo(String texto, int max) {
        return texto != null && texto.length() > max;
    }

    public static boolean careceTamanioMinimo(String texto, int min) {
        return texto == null || texto.length() < min;
    }

    public static boolean estaVacio(String texto) {
        // uso de pipelines para validación
        return Optional.ofNullable(texto)
                .map(String::trim)
                .map(String::isEmpty)
                .orElse(true);
    }

    public static boolean contieneSoloNumeros(String texto) {
        if (estaVacio(texto)) return false;
        for (char c : texto.toCharArray()) {
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    public static boolean contieneSoloLetras(String texto) {
        // Uso de regex por instrucción IA
        return texto != null && texto.matches("[a-zA-ZñÑ ]+");
    }

    public static boolean esPasswordValido(String texto) {
        // Uso de pipelines para validación compleja
        if (texto == null || texto.length() < 8 || texto.length() > 12) return false;
        
        boolean tieneMayus = texto.chars().anyMatch(Character::isUpperCase);
        boolean tieneMinus = texto.chars().anyMatch(Character::isLowerCase);
        boolean tieneDigito = texto.chars().anyMatch(Character::isDigit);
        boolean tieneEspecial = texto.chars().anyMatch(c -> "$%-_#@".indexOf(c) != -1);
        
        return tieneMayus && tieneMinus && tieneDigito && tieneEspecial;
    }

    public static boolean esPalindromo(String texto) {
        if (estaVacio(texto)) return false;
        String limpio = texto.replace(" ", "").toLowerCase();
        int i = 0, j = limpio.length() - 1;
        while (i < j) {
            if (limpio.charAt(i++) != limpio.charAt(j--)) return false;
        }
        return true;
    }

    public static boolean esFechaValida(String texto) {
        if (texto == null || texto.length() != 10) return false;
        // Formato esperado: dd/mm/aaaa
        try {
            int dia = Integer.parseInt(texto.substring(0, 2));
            int mes = Integer.parseInt(texto.substring(3, 5));
            int anio = Integer.parseInt(texto.substring(6, 10));
            return (dia >= 1 && dia <= 31) && (mes >= 1 && mes <= 12);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
