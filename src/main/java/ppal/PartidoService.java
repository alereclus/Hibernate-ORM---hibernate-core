/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppal;

/**
 *
 * @author alereclus
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PartidoService {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public PartidoService() {
        emf = Persistence.createEntityManagerFactory("mydb");
        em = emf.createEntityManager();
    }

    public void jugarPartido(Long idEquipoLocal, Long idEquipoVisitante, int golesLocal, int golesVisitante) {
        try {
            em.getTransaction().begin();

            // Registrar el partido y obtener puntos para cada equipo
            int[] puntos = registrarPartido(idEquipoLocal, idEquipoVisitante, golesLocal, golesVisitante);

            // Actualizar la base de datos 'Posiciones' basado en el resultado del partido
            actualizarPosiciones(idEquipoLocal, idEquipoVisitante, golesLocal, golesVisitante, puntos[0], puntos[1]);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    private int[] registrarPartido(Long idEquipoLocal, Long idEquipoVisitante, int golesLocal, int golesVisitante) {
        Partido partido = new Partido();
        partido.setEquipoLocal(em.find(EquipoDeFutbol.class, idEquipoLocal));
        partido.setEquipoVisitante(em.find(EquipoDeFutbol.class, idEquipoVisitante));
        partido.setGolesLocal(golesLocal);
        partido.setGolesVisitante(golesVisitante);

        // Lógica para determinar puntos basados en el resultado del partido
        int puntosLocal = golesLocal > golesVisitante ? 3 : golesLocal == golesVisitante ? 1 : 0;
        int puntosVisitante = golesVisitante > golesLocal ? 3 : golesVisitante == golesLocal ? 1 : 0;

        partido.setPuntosLocal(puntosLocal);
        partido.setPuntosVisitante(puntosVisitante);
        em.persist(partido);

        return new int[]{puntosLocal, puntosVisitante};
    }

    private void actualizarPosiciones(Long idEquipoLocal, Long idEquipoVisitante, int golesLocal, int golesVisitante, int puntosLocal, int puntosVisitante) {
        Posicion posicionLocal = em.createQuery("SELECT p FROM Posicion p WHERE p.equipo.id = :idEquipo", Posicion.class)
                                   .setParameter("idEquipo", idEquipoLocal)
                                   .getSingleResult();
        Posicion posicionVisitante = em.createQuery("SELECT p FROM Posicion p WHERE p.equipo.id = :idEquipo", Posicion.class)
                                        .setParameter("idEquipo", idEquipoVisitante)
                                        .getSingleResult();

        actualizarEstadisticasEquipo(posicionLocal, puntosLocal, golesLocal, golesVisitante);
        actualizarEstadisticasEquipo(posicionVisitante, puntosVisitante, golesVisitante, golesLocal);

        em.merge(posicionLocal);
        em.merge(posicionVisitante);
    }

    private void actualizarEstadisticasEquipo(Posicion posicion, int puntos, int golesFavor, int golesContra) {
        posicion.setPuntos(posicion.getPuntos() + puntos);
        posicion.setPartidosJugados(posicion.getPartidosJugados() + 1);
        posicion.setGolesAFavor(posicion.getGolesAFavor() + golesFavor);
        posicion.setGolesEnContra(posicion.getGolesEnContra() + golesContra);
    }

    public Long obtenerIdPorNombreEquipo(String nombreEquipo) {
        EquipoDeFutbol equipo = em.createQuery("SELECT e FROM EquipoDeFutbol e WHERE e.nombre = :nombre", EquipoDeFutbol.class)
                                  .setParameter("nombre", nombreEquipo)
                                  .getSingleResult();
        return equipo != null ? equipo.getId() : null;
    }
}
