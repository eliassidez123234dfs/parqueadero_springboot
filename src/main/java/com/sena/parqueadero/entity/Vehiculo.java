package com.sena.parqueadero.entity;

//
public class Vehiculo {
    private long id;
    private String placa;
    private String marca;
    private String modelo;
    private String propietario;

    public long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
