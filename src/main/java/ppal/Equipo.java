/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ppal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alereclus
 */

@Entity
@Table(name = "Equipos")
public abstract class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Atributos
    private String nombre;
    private int titulares;
    private int suplentes;
    private String dt; 
    private int puntos;
    private int partidosJugados;

    // Constructor
    public Equipo(String nombre, int titulares, int suplentes, String dt, int puntos, int partidosJugados) {
        this.nombre = nombre;
        this.titulares = titulares;
        this.suplentes = suplentes;
        this.dt = dt;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTitulares() {
        return titulares;
    }

    public void setTitulares(int titulares) {
        this.titulares = titulares;
    }

    public int getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(int suplentes) {
        this.suplentes = suplentes;
    }

    public String getdt() {
        return dt;
    }

    public void setdt(String dt) {
        this.dt = dt;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    // Método abstracto
    public abstract void jugarPartido();
}
