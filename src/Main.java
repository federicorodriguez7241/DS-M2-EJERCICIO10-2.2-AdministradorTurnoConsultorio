import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        AdministradorTurnos admin = AdministradorTurnos.getInstancia();

        System.out.println("--- CARGANDO AGENDA ---");
        admin.cargarTurnoDisponible("Perez", LocalDate.of(2026, 11, 20), LocalTime.of(10, 0));
        admin.consultarAgenda();

        System.out.println("--- INTENTOS DE RESERVA ---");
        // Intento 1: Funciona perfecto
        admin.reservarTurno("Perez", LocalDate.of(2026, 11, 20), LocalTime.of(10, 0), "Paciente 1");

        // Intento 2: El sistema lo rechaza porque ya se ocupó arriba
        admin.reservarTurno("Perez", LocalDate.of(2026, 11, 20), LocalTime.of(10, 0), "Paciente 2");

        System.out.println("\n--- CANCELANDO TURNO ---");
        admin.cancelarTurno("Perez", LocalDate.of(2026, 11, 20), LocalTime.of(10, 0));

        admin.consultarAgenda();
    }
}
