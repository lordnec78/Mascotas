package com.example.nkta_.mascotas;

import java.io.Serializable;

/**
 * Created by nkta_ on 31/05/2017.
 */

public class Mascotas implements Serializable {

    private int imgfoto;
    private String nombre;
    private int huesolike=0;
     private int contador=0;

    public Mascotas(int imgfoto, String nombre, int huesolike,int contador) {
        this.imgfoto = imgfoto;
        this.nombre = nombre;
        this.huesolike = huesolike;
        this.contador=contador;
    }

    public int getImgfoto() {
        return imgfoto;
    }

    public void setImgfoto(int imgfoto) {
        this.imgfoto = imgfoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHuesolike() {
        return huesolike;
    }

    public void setHuesolike(int huesolike) {

        this.huesolike = ++huesolike;
        contador=huesolike;
    }

    public int getContador() {
        return contador;
    }

    public void setContador() {
        this.contador =++ huesolike;
    }
}
