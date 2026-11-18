package Model;

public class CitaNueva extends Cita {
    private String problema;

    public CitaNueva(int id, String especialidad, String problema){
        super(id, especialidad);
        this.problema = problema;
    }

    public String getProblema(){
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    @Override
    public String toString(){
        return "Cita sin procesar para el id: " + getIdPaciente() + ", de la especialidad " + getEspecialidad() + ", tiene la siguiente consulta: " + getProblema() + ".";
    }

}
