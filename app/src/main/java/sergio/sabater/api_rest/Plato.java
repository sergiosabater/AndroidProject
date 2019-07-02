package sergio.sabater.api_rest;

import java.io.Serializable;

public class Plato implements Serializable {

    private int idPlato;
    private String nombre;
    private int kcal;
    private int tmpPreparacion;

    public Plato() {
    }

    public Plato(int idPlato, String nombre, int kcal, int tmpPreparacion) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.kcal = kcal;
        this.tmpPreparacion = tmpPreparacion;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public int getKcal() {
        return kcal;
    }

    public int getTmpPreparacion() {
        return tmpPreparacion;
    }
}
