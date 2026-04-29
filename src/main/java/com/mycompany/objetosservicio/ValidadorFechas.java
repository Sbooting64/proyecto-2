/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosservicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.Period;
/**
 *
 * @author mildr
 */
public class ValidadorFechas {
    public static boolean esFechaFutura(LocalDate fecha) {
        return fecha.isAfter(LocalDate.now());
    }

    public static boolean esFechaPasada(LocalDate fecha) {
        return fecha.isBefore(LocalDate.now());
    }

    public static boolean esMayorEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    public static boolean estaDentroRango(LocalDate fecha, LocalDate desde, LocalDate hasta) {
        return (fecha.isEqual(desde) || fecha.isAfter(desde)) && 
               (fecha.isEqual(hasta) || fecha.isBefore(hasta));
    }

    public static boolean esFinSemana(LocalDate fecha) {
        DayOfWeek dia = fecha.getDayOfWeek();
        return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
    }

    public static boolean esHorarioLaboral(LocalDateTime fecha) {
        DayOfWeek dia = fecha.getDayOfWeek();
        int hora = fecha.getHour();
        
        if (dia == DayOfWeek.SUNDAY) return false;
        if (dia == DayOfWeek.SATURDAY) return hora >= 8 && hora < 13;
        return hora >= 8 && hora < 18; // Lunes a Viernes
    }
    
}
