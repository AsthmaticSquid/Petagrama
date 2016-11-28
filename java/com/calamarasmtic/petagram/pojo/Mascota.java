package com.calamarasmtic.petagram.pojo;

/**
 * Created by Calamar Asmàtic on 30/10/2016.
 */

public class Mascota implements Comparable<Mascota>{

    private String id;
    private String urlfoto;
    private String nombre;
    private int votos = 0;

    public Mascota(String urlfoto, String nombre, int votos){
        this.urlfoto = urlfoto;
        this.nombre = nombre;
        this.votos = votos;
    }

    public Mascota(String urlfoto, int votos){
        this.urlfoto = urlfoto;
        this.votos = votos;
    }

    public Mascota() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public int compareTo(Mascota mascota) {
        if (this.votos < mascota.votos) return -1;
        if (this.votos > mascota.votos) return 1;
        return 0;
    }
}
