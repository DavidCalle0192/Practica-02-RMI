package servidorDeAlertas.dto;

import java.io.Serializable;


public class ClsAsintomaticoDTO implements Serializable
{	
    //Atributos propios del paciente 
    private int id;
    private String tipo_id;
    private String nombres;
    private String apellidos;
    private float temperatura;
   

    public ClsAsintomaticoDTO(int id, String tipo_id, String nombres, String apellidos, float temperatura) {
        this.id = id;
        this.tipo_id = tipo_id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.temperatura = temperatura;
   
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    

    
    

}
