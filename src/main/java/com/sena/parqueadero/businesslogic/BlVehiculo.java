package com.sena.parqueadero.businesslogic;

import com.sena.parqueadero.entity.Vehiculo;
import com.sena.parqueadero.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlVehiculo {

    private final VehiculoRepository vr;

    public BlVehiculo(VehiculoRepository vr) {
        this.vr = vr;
    }


    // VALIDAR VEHICULO
    public boolean validarVehiculo(Vehiculo v) {

        if (v != null) {

            if (v.getPlaca() != null && v.getPlaca().length() == 6) {

                if (v.getMarca() != null && !v.getMarca().isBlank()) {

                    if (v.getModelo() != null && v.getModelo().length() == 4) {

                        if (v.getPropietario() != null && !v.getPropietario().isBlank()) {

                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }


    // CREAR VEHICULO
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {

        if (validarVehiculo(vehiculo)) {

            return vr.crearVehiculo(vehiculo);
        }

        return null;
    }


    // CONSULTAR TODOS
    public List<Vehiculo> consultarVehiculos() {

        return vr.consultarVehiculos();
    }


    // CONSULTAR UNO
    public Vehiculo consultarVehiculo(String placa) {

        if (placa != null && placa.length() == 6) {

            return vr.consultarVehiculo(placa);
        }

        return null;
    }


    // ACTUALIZAR
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {

        if (validarVehiculo(vehiculo)) {

            return vr.actualizarVehiculo(vehiculo);
        }

        return null;
    }


    // ELIMINAR
    public boolean eliminarVehiculo(long id) {

        if (id > 0) {

            return vr.eliminarVehiculo(id);
        }

        return false;
    }
}