/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppal;

/**
 *
 * @author alereclus
 */
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "Partidos")
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipoLocal_fk")
    private EquipoDeFutbol equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipoVisitante_fk")
    private EquipoDeFutbol equipoVisitante;

    private int golesLocal;
    private int golesVisitante;
    private LocalDateTime fecha;

    // Constructor
    public Partido() {
    }

    // Constructor 
    public Partido(EquipoDeFutbol equipoLocal, EquipoDeFutbol equipoVisitante, int golesLocal, int golesVisitante, LocalDateTime fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipoDeFutbol getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(EquipoDeFutbol equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public EquipoDeFutbol getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(EquipoDeFutbol equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    void setPuntosLocal(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setPuntosVisitante(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
