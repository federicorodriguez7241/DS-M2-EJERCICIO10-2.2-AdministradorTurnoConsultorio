import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class AdministradorTurnos {

    private static AdministradorTurnos instancia;
    private List<Turno> agenda;

    private AdministradorTurnos() {
        this.agenda = new ArrayList<>();
    }

    public static AdministradorTurnos getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorTurnos();
        }
        return instancia;
    }

    public void cargarTurnoDisponible(String profesional, LocalDate fecha, LocalTime hora) {
        this.agenda.add(new Turno(profesional, fecha, hora));
    }

    public void reservarTurno(String profesional, LocalDate fecha, LocalTime hora, String paciente) {
        for (Turno t : this.agenda) {
            if (t.getProfesional().equals(profesional) && t.getFecha().equals(fecha) && t.getHora().equals(hora)) {

                // verificamos disponibilidad y asignamos en el mismo bloque
                if (t.isLibre()) {
                    t.setPaciente(paciente);
                    System.out.println(" Éxito: Turno asignado a " + paciente);
                } else {
                    System.out.println(" Rechazado: El turno ya está ocupado por " + t.getPaciente());
                }
                return;
            }
        }
        System.out.println("Error: El turno solicitado no existe en la agenda.");
    }

    public void cancelarTurno(String profesional, LocalDate fecha, LocalTime hora) {
        for (Turno t : this.agenda) {
            if (t.getProfesional().equals(profesional) && t.getFecha().equals(fecha) && t.getHora().equals(hora)) {

                if (!t.isLibre()) {
                    t.setPaciente(null);
                    System.out.println("Turno cancelado correctamente. Horario liberado.");
                } else {
                    System.out.println("Ignorado: El turno ya estaba libre, no se modificó nada.");
                }
                return;
            }
        }
    }

    public void consultarAgenda() {
        System.out.println("\n--- AGENDA ACTUALIZADA ---");
        for (Turno t : this.agenda) {
            System.out.println(t.toString());
        }
        System.out.println("------\n");
    }
}
