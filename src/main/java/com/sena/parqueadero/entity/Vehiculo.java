package com.sena.parqueadero.entity;

public class Vehiculo {
    long id;
    String placa;
    String marca;
    String modelo;
    String propietario;

    // id
    void setId(long idM){
        id = idM;
    }

    long getId(){
        return id;
    }

    //placa
    void setPlaca(String placaM){
        placa = placaM;
    }

    String getPlaca(){
        return placa;
    }

    //Marca
    void setMarca(String marcaM){
        marca = marcaM;
    }

    String getMarca(){
        return marca;
    }

    //Modelo
    void setModelo(String modeloM){
        modelo = modeloM;
    }

    String getModelo(){
        return modelo;
    }

    //Propietario
    void setPropietario(String propietarioM){
        propietario = propietarioM;
    }

    String getPropietario(){
        return propietario;
    }

    
}
