package model;

public abstract class Cita {
    private int idPaciente;
    private String especialidad;


    public Cita(int id, String especialidad) {
        this.idPaciente = id;
        this.especialidad = especialidad;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getEspecialidad(){
        return especialidad;
    }

}
