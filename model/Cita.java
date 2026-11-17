package Model;

public class Cita {
    private int idPaciente;
    private String especialidad;
    private String problema;
    private String atencionPrestada;

    public Cita(int id, String especialidad, String problema) {
        this.idPaciente = id;
        this.especialidad = especialidad;
        this.problema = problema;
    }

    public String getAtencionPrestada() {
        return atencionPrestada;
    }

    public void setAtencionPrestada(String atencion){
        this.atencionPrestada = atencion;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema){
        this.problema = problema;
    }
}
