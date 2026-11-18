package Model;

public abstract class Cita {
    private int idPaciente;
    private String especialidad;


    protected Cita(int id, String especialidad) {
        this.idPaciente = id;
        this.especialidad = especialidad;
    }

    protected int getIdPaciente() {
        return idPaciente;
    }

    protected String getEspecialidad(){
        return especialidad;
    }

}
