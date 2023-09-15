package ppm.ejercicio.tienda.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ppm.ejercicio.tienda.Entities.Productos;

public interface ProductoRepository extends CrudRepository<Productos, Integer> {

     public List<Productos> findByIdTienda(Integer idTienda);

}