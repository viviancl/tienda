package ppm.ejercicio.tienda.Controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ppm.ejercicio.tienda.Services.PedidoService;
import ppm.ejercicio.tienda.DTOs.Request.PedidoClienteDto;
import ppm.ejercicio.tienda.DTOs.Response.PedidoDto;
import ppm.ejercicio.tienda.Entities.Pedidos;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> consultarPorIdTienda(@PathVariable Integer id) throws Exception {
        try {
            return ResponseEntity.ok(pedidoService.ConsultarPorIdPedido(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> consultarPedidoPorClienteRangoFecha(
            @RequestParam("cliente") Integer idCliente)
            throws Exception {
        try {
            List<PedidoDto> pedidos = pedidoService.consultarPedidoPorClienteRangoFecha(idCliente);
            return ResponseEntity.ok(pedidos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Pedidos> crearPedido(@RequestBody PedidoClienteDto pedido) throws Exception {
        try {
            Pedidos result = pedidoService.crearPedido(pedido);
            return ResponseEntity.created(new URI("/api/pedidos/" + result.getIdPedido())).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
