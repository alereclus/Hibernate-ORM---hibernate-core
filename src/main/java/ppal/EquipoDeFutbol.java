/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppal;

import jakarta.persistence.Entity;

/**
 *
 * @author alereclus
 * 
 * extends: lleva a una clase superior, la extiende
 */
@Entity
public class EquipoDeFutbol extends Equipo {
    // Constructor
    public EquipoDeFutbol(String nombre, int titulares, int suplentes, String dt, int puntos, int partidosJugados) {
        super(nombre, titulares, suplentes, dt, puntos, partidosJugados);
    }

    // Implementación del método jugarPartido
    public void jugarPartido(Partido partido) {

    }

    @Override
    public void jugarPartido() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
