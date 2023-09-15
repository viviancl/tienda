package ppm.ejercicio.tienda.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ppm.ejercicio.tienda.Entities.DetallePedidos;

public interface DetallePedidoRepository extends CrudRepository<DetallePedidos, Integer> {

    
     public List<DetallePedidos> findByIdPedido(Integer idPedido);

}