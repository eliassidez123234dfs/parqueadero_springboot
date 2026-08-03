package com.sena.parqueadero.repository;

import com.sena.parqueadero.entity.Vehiculo;

import java.sql.Struct;

public class VehiculoRepository {

    Vehiculo v = new Vehiculo();
    // Conectarse a mysql y ejecutar el delete con placa
    public boolean eliminarVehiculo(String placa){
        return true;
    }

    public Vehiculo consultarVehiculo(String placa){
        v.getPlaca();
        v.setMarca("Mazda");
        return v;
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo){
        return vehiculo;
    }
}
