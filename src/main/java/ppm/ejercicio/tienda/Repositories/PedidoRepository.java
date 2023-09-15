package ppm.ejercicio.tienda.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ppm.ejercicio.tienda.DTOs.Response.PedidoDto;
import ppm.ejercicio.tienda.Entities.Pedidos;

public interface PedidoRepository extends CrudRepository<Pedidos, Integer> {

        @Query("select new ppm.ejercicio.tienda.DTOs.Response.PedidoDto (p.idPedido, p.idCliente, c.nombre, p.fechaPedido) "
                        + "from Pedidos p "
                        + "inner join Clientes c on (c.idCliente = p.idCliente) "
                        + "where p.idCliente = :idCliente ")
        public List<PedidoDto> consultarPedidoPorClienteRangoFecha(
                        @Param("idCliente") Integer idCliente);
}