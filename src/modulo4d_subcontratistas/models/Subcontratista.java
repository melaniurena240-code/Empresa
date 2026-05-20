package modulo4d_subcontratistas.models;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Modelo de Subcontratista
 */
public class Subcontratista implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int idSubcontratista;
    private String nombreSubcontratista;
    private String representante;
    private String ciSubcontratista;
    private String telefonoSubcontratista;
    private String emailSubcontratista;
    private String direccionSubcontratista;
    private String especialidad;
    private LocalDateTime fechaRegistro;
    
    public Subcontratista() {
        this.fechaRegistro = LocalDateTime.now();
    }
    
    public Subcontratista(String nombreSubcontratista, String especialidad, String telefonoSubcontratista,
                          String emailSubcontratista, String ciSubcontratista) {
        this.nombreSubcontratista = nombreSubcontratista;
        this.especialidad = especialidad;
        this.telefonoSubcontratista = telefonoSubcontratista;
        this.emailSubcontratista = emailSubcontratista;
        this.ciSubcontratista = ciSubcontratista;
        this.fechaRegistro = LocalDateTime.now();
    }
    
    // Getters y Setters
    public int getIdSubcontratista() { return idSubcontratista; }
    public void setIdSubcontratista(int idSubcontratista) { this.idSubcontratista = idSubcontratista; }
    
    public String getNombreSubcontratista() { return nombreSubcontratista; }
    public void setNombreSubcontratista(String nombreSubcontratista) { this.nombreSubcontratista = nombreSubcontratista; }
    
    public String getRepresentante() { return representante; }
    public void setRepresentante(String representante) { this.representante = representante; }
    
    public String getCiSubcontratista() { return ciSubcontratista; }
    public void setCiSubcontratista(String ciSubcontratista) { this.ciSubcontratista = ciSubcontratista; }
    
    public String getTelefonoSubcontratista() { return telefonoSubcontratista; }
    public void setTelefonoSubcontratista(String telefonoSubcontratista) { this.telefonoSubcontratista = telefonoSubcontratista; }
    
    public String getEmailSubcontratista() { return emailSubcontratista; }
    public void setEmailSubcontratista(String emailSubcontratista) { this.emailSubcontratista = emailSubcontratista; }
    
    public String getDireccionSubcontratista() { return direccionSubcontratista; }
    public void setDireccionSubcontratista(String direccionSubcontratista) { this.direccionSubcontratista = direccionSubcontratista; }
    
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    @Override
    public String toString() {
        return nombreSubcontratista + " (" + especialidad + ")";
    }
}
