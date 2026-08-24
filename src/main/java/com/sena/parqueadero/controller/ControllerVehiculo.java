package com.sena.parqueadero.controller;

import com.sena.parqueadero.businesslogic.BlVehiculo;
import com.sena.parqueadero.entity.Vehiculo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin
public class ControllerVehiculo {

    private final BlVehiculo blVehiculo;

    public ControllerVehiculo(BlVehiculo blVehiculo) {
        this.blVehiculo = blVehiculo;
    }


    // CREAR
    @PostMapping
    public Vehiculo crearVehiculo(@RequestBody Vehiculo vehiculo) {

        return blVehiculo.crearVehiculo(vehiculo);
    }


    // CONSULTAR TODOS
    @GetMapping
    public List<Vehiculo> consultarVehiculos() {

        return blVehiculo.consultarVehiculos();
    }


    // CONSULTAR UNO
    @GetMapping("/{placa}")
    public Vehiculo consultarVehiculo(@PathVariable String placa) {

        return blVehiculo.consultarVehiculo(placa);
    }


    // ACTUALIZAR
    @PutMapping
    public Vehiculo actualizarVehiculo(@RequestBody Vehiculo vehiculo) {

        return blVehiculo.actualizarVehiculo(vehiculo);
    }


    // ELIMINAR
    @DeleteMapping("/{id}")
    public boolean eliminarVehiculo(@PathVariable long id) {

        return blVehiculo.eliminarVehiculo(id);
    }
}