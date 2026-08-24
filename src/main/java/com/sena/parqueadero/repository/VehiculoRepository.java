package com.sena.parqueadero.repository;

import com.sena.parqueadero.entity.Vehiculo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehiculoRepository {

    private final JdbcTemplate jdbcTemplate;

    public VehiculoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREAR VEHICULO
    public Vehiculo crearVehiculo(Vehiculo vehiculo) {

        String sql = """
                INSERT INTO vehiculo
                (placa, marca, modelo, propietario)
                VALUES (?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                vehiculo.getPlaca(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getPropietario()
        );

        return vehiculo;
    }


    // CONSULTAR TODOS LOS VEHICULOS
    public List<Vehiculo> consultarVehiculos() {

        String sql = "SELECT * FROM vehiculo";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Vehiculo vehiculo = new Vehiculo();

            vehiculo.setId(rs.getLong("id"));
            vehiculo.setPlaca(rs.getString("placa"));
            vehiculo.setMarca(rs.getString("marca"));
            vehiculo.setModelo(rs.getString("modelo"));
            vehiculo.setPropietario(rs.getString("propietario"));

            return vehiculo;
        });
    }


    // CONSULTAR UN VEHICULO POR PLACA
    public Vehiculo consultarVehiculo(String placa) {

        String sql = "SELECT * FROM vehiculo WHERE placa = ?";

        List<Vehiculo> lista = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    Vehiculo vehiculo = new Vehiculo();

                    vehiculo.setId(rs.getLong("id"));
                    vehiculo.setPlaca(rs.getString("placa"));
                    vehiculo.setMarca(rs.getString("marca"));
                    vehiculo.setModelo(rs.getString("modelo"));
                    vehiculo.setPropietario(rs.getString("propietario"));

                    return vehiculo;
                },
                placa
        );

        if (lista.isEmpty()) {
            return null;
        }

        return lista.get(0);
    }


    // ACTUALIZAR VEHICULO
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {

        String sql = """
                UPDATE vehiculo
                SET placa = ?,
                    marca = ?,
                    modelo = ?,
                    propietario = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                vehiculo.getPlaca(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getPropietario(),
                vehiculo.getId()
        );

        return vehiculo;
    }


    // ELIMINAR VEHICULO
    public boolean eliminarVehiculo(long id) {

        String sql = "DELETE FROM vehiculo WHERE id = ?";

        int filas = jdbcTemplate.update(sql, id);

        return filas > 0;
    }
}