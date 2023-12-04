/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppal;

/**
 *
 * @author alereclus
 */
import java.util.Scanner;

public class AplicacionPrincipal {

    public static void main(String[] args) {
        PartidoService service = new PartidoService();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese los detalles del partido:");

            System.out.print("Nombre del Equipo Local: ");
            String nombreEquipoLocal = scanner.nextLine();
            Long idEquipoLocal = service.obtenerIdPorNombreEquipo(nombreEquipoLocal);

            System.out.print("Nombre del Equipo Visitante: ");
            String nombreEquipoVisitante = scanner.nextLine();
            Long idEquipoVisitante = service.obtenerIdPorNombreEquipo(nombreEquipoVisitante);

            System.out.print("Goles Equipo Local: ");
            int golesLocal = Integer.parseInt(scanner.nextLine());

            System.out.print("Goles Equipo Visitante: ");
            int golesVisitante = Integer.parseInt(scanner.nextLine());

            // Verificar si se obtuvieron correctamente los ID de los equipos
            if (idEquipoLocal == null || idEquipoVisitante == null) {
                System.out.println("No se encontró uno o ambos equipos. Asegúrese de que los nombres estén correctos.");
            } else {
                // Llamar al servicio para jugar el partido
                service.jugarPartido(idEquipoLocal, idEquipoVisitante, golesLocal, golesVisitante);

                System.out.println("Partido registrado y posiciones actualizadas.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en la entrada de datos. Asegúrese de ingresar números válidos para los goles.");
        } catch (Exception e) {
            System.out.println("Error al registrar el partido: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}