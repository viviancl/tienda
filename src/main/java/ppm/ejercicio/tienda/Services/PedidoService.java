package ppm.ejercicio.tienda.Services;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ppm.ejercicio.tienda.DTOs.Request.PedidoClienteDto;
import ppm.ejercicio.tienda.DTOs.Request.PedidoProductoDto;
import ppm.ejercicio.tienda.Entities.DetallePedidos;
import ppm.ejercicio.tienda.Entities.Pedidos;
import ppm.ejercicio.tienda.Repositories.DetallePedidoRepository;
import ppm.ejercicio.tienda.Repositories.PedidoRepository;
import ppm.ejercicio.tienda.DTOs.Response.PedidoDto;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public Pedidos ConsultarPorIdPedido(Integer idPedido) {
        return (Pedidos) pedidoRepository.findById(idPedido).get();
    }

    @Transactional
    public Pedidos crearPedido(PedidoClienteDto pedido)
            throws ParserConfigurationException, UnknownHostException {

        Pedidos newPedido = new Pedidos();
        newPedido.setIdCliente(pedido.getIdCliente());
        
        newPedido.setFechaPedido( new Date());

        Pedidos pedidoCreado = pedidoRepository.save(newPedido);

        for (PedidoProductoDto producto : pedido.getProductos()) {

            DetallePedidos newDetalle = new DetallePedidos();

            newDetalle.setIdPedido(pedidoCreado.getIdPedido());
            newDetalle.setIdProducto(producto.getIdProducto());
            newDetalle.setCantidad(producto.getCantidad());

            detallePedidoRepository.save(newDetalle);
        }
        return pedidoCreado;
    }

    public void eliminarPedido(int id) {

        List<DetallePedidos> detalles = detallePedidoRepository.findByIdPedido(id);
       
        for (DetallePedidos detalle : detalles) {
            detallePedidoRepository.deleteById(detalle.getIdDetalle());
        }  

        pedidoRepository.deleteById(id);
    } 

    public List<PedidoDto>consultarPedidoPorClienteRangoFecha(Integer idCliente)
    {
        return  pedidoRepository.consultarPedidoPorClienteRangoFecha(idCliente);
    }
}
