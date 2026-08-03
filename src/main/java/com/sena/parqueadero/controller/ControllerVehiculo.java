package com.sena.parqueadero.controller;

import com.sena.parqueadero.businesslogic.BlVehiculo;
import com.sena.parqueadero.entity.Vehiculo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos") // definir ruta vehiculos
public class ControllerVehiculo {
    // Esta clase tendra el CRUD de vehiculo
    // metodo
    BlVehiculo bl = new BlVehiculo();

    @DeleteMapping("/eliminar")
    public boolean deleteVehiculo(@RequestParam String placa){
        return bl.eliminarVehiculo(placa);
    }

    @GetMapping("/consultar")
    public Vehiculo consultarVehiculo(@RequestParam String placa){
        return bl.consultarVehiculo(placa);
    }

    @PostMapping("/crear")
    public Vehiculo crearVehiculo(@RequestBody Vehiculo vehiculo){
        return vehiculo;
    }
}
