/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppal;

/**
 *
 * @author alereclus
 */
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Posiciones")
public class Posicion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "equipo_fk")
    private EquipoDeFutbol equipo;

    private int puntos;
    private int partidosJugados;
    private int golesFavor;
    private int golesContra;
    private int diferenciaGol;

    // Constructor vacío necesario para JPA
    public Posicion() {
    }

    // Constructor con todos los atributos
    public Posicion(EquipoDeFutbol equipo, int puntos, int partidosJugados, int golesFavor, int golesContra, int diferenciaGol) {
        this.equipo = equipo;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.diferenciaGol = diferenciaGol;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipoDeFutbol getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoDeFutbol equipo) {
        this.equipo = equipo;
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

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getDiferenciaGoles() {
        return diferenciaGol;
    }

    public void setDiferenciaGol(int diferenciaGol) {
        this.diferenciaGol = diferenciaGol;
    }

    int getGolesAFavor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getGolesEnContra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setGolesAFavor(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setGolesEnContra(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
