package ppm.ejercicio.tienda.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ppm.ejercicio.tienda.Entities.Tiendas;

public interface TiendaRepository extends CrudRepository<Tiendas, Integer> {

    public List<Tiendas> findByIdTienda(Integer idTienda);

}