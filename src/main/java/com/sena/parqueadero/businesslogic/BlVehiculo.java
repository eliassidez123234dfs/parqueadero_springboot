package com.sena.parqueadero.businesslogic;

import com.sena.parqueadero.entity.Vehiculo;
import com.sena.parqueadero.repository.VehiculoRepository;

public class BlVehiculo {

    VehiculoRepository vr = new VehiculoRepository();

    public boolean validarVehiculo(Vehiculo v){
        if(v != null){
            if(v.getPlaca().length() == 6){
                if(!v.getMarca().isBlank()){
                    if(v.getModelo().length() == 4){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean eliminarVehiculo(String placa){
        if(placa.length()==6){
            return vr.eliminarVehiculo(placa);
        }
        return false;
    }

    public Vehiculo consultarVehiculo(String placa){
        if (placa.length() == 6){
            return vr.consultarVehiculo(placa);
         }else {
            return null;
        }
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo){
        if (validarVehiculo(vehiculo)){
            return vr.crearVehiculo(vehiculo);
        }
        return null;
    }
}
