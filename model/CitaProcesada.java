package Model;

public class CitaProcesada extends Cita{
    private String diagnostico;

    public CitaProcesada(int id, String e, String d) {
        super(id, d);
        this.diagnostico = d;
    }

    public String getDiagnostico(){
        return diagnostico;
    }

    public void setDiagnostico(String d){
        this.diagnostico = d;
    }

    @Override
    public String toString(){
        return "El paciente: " + getIdPaciente() + ", atendio a la cita de la especialidad " + getEspecialidad() + ", tuvo el siguiente diagnostico: " + getDiagnostico() + ".";
    }
}
