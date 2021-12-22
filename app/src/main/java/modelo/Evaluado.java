package modelo;

import java.io.Serializable;

public class Evaluado implements Serializable {

    String id, idEvaluado, nombres, genero, situacion, cargo, fechaInicio, fechaFin, imgJPG, imgJpg;

    public Evaluado() {
    }

    public Evaluado(String id, String idEvaluado, String nombres, String genero, String situacion,
                    String cargo, String fechaInicio, String fechaFin, String imgJPG, String imgJpg) {
        this.id = id;
        this.idEvaluado = idEvaluado;
        this.nombres = nombres;
        this.genero = genero;
        this.situacion = situacion;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imgJPG = imgJPG;
        this.imgJpg = imgJpg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEvaluado() {
        return idEvaluado;
    }

    public void setIdEvaluado(String idEvaluado) {
        this.idEvaluado = idEvaluado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImgJPG() {
        return imgJPG;
    }

    public void setImgJPG(String imgJPG) {
        this.imgJPG = imgJPG;
    }

    public String getImgJpg() {
        return imgJpg;
    }

    public void setImgJpg(String imgJpg) {
        this.imgJpg = imgJpg;
    }
}
