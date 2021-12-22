package modelo;

import java.io.Serializable;

public class Evaluador implements Serializable {

    String idEvaluador, nombres, area, imgJPG, imgJpg;

    public Evaluador() {
    }

    public Evaluador(String idEvaluador, String nombres, String area, String imgJPG, String imgJpg) {
        this.idEvaluador = idEvaluador;
        this.nombres = nombres;
        this.area = area;
        this.imgJPG = imgJPG;
        this.imgJpg = imgJpg;
    }

    public String getIdEvaluador() {
        return idEvaluador;
    }

    public void setIdEvaluador(String idevaluador) {
        this.idEvaluador = idevaluador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
