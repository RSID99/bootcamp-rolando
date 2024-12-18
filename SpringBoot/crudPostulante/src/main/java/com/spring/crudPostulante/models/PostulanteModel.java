package com.spring.crudPostulante.models;


import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;


@Entity
@Table(name="postulante")
public class PostulanteModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    @Column(name = "nro_cedula", nullable = false, unique = true)
    private int nrocedula;
    private String correo;
    private String telefono;
    private String direccion;
    private boolean experiencia_laboral;
    private boolean estudio_universitario;
    private boolean notebook;
    private int bootcamp_id;
    private boolean aceptado;

    public PostulanteModel() {
    }

    public PostulanteModel(int nrocedula, String nombre, String apellido, String telefono, String direccion, String correo, boolean experiencia_laboral, boolean estudio_universitario, boolean notebook, int bootcamp_id, boolean aceptado) {
        this.nrocedula = nrocedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.experiencia_laboral = experiencia_laboral;
        this.estudio_universitario = estudio_universitario;
        this.notebook = notebook;
        this.bootcamp_id = bootcamp_id;
        this.aceptado = aceptado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNrocedula(int nrocedula) {
        this.nrocedula = nrocedula;
    }

    public int getNrocedula() {
        return nrocedula;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setExperiencia_laboral(boolean experiencia_laboral) {
        this.experiencia_laboral = experiencia_laboral;
    }

    public boolean getExperiencia_laboral() {
        return experiencia_laboral;
    }

    public void setEstudio_univerditario(boolean estudio_universitario) {
        this.estudio_universitario = estudio_universitario;
    }

    public boolean getEstudio_univerditario() {
        return estudio_universitario;
    }

    public void setNotebook(boolean notebook) {
        this.notebook = notebook;
    }

    public boolean getNotebook() {
        return notebook;
    }

    public void setBootcamp_id(int bootcamp_id) {
        this.bootcamp_id = bootcamp_id;
    }

    public int getBootcamp_id() {
        return bootcamp_id;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public boolean getAceptado() {
        return aceptado;
    }




}
