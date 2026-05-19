package com.example.demo.models;

import java.util.Date;

public class Trip {

    private String nombre;
    private String destino;
    private Date fecha;

    public Trip() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Trip [nombre=" + nombre + ", destino=" + destino + ", fecha=" + fecha + "]";
    }
}