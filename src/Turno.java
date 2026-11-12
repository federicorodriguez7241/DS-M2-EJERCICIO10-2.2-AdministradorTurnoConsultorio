import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private String profesional;
    private LocalDate fecha;
    private LocalTime hora;
    private String paciente;

    public Turno(String profesional, LocalDate fecha, LocalTime hora) {
        this.profesional = profesional;
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = null; // null significa que el turno esta libre
    }

    public String getProfesional() { return profesional; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getPaciente() { return paciente; }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public boolean isLibre() {
        return this.paciente == null;
    }

    @Override
    public String toString() {
        String estado = (paciente == null) ? "LIBRE" : "OCUPADO por " + paciente;
        return fecha + " " + hora + " | Dr. " + profesional + " -> " + estado;
    }
}