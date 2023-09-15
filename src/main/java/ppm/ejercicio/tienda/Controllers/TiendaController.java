package ppm.ejercicio.tienda.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ppm.ejercicio.tienda.DTOs.Request.ProductoDto;
import ppm.ejercicio.tienda.DTOs.Request.TiendaDto;
import ppm.ejercicio.tienda.DTOs.Response.TiendaProductosDto;
import ppm.ejercicio.tienda.Entities.Productos;
import ppm.ejercicio.tienda.Entities.Tiendas;
import ppm.ejercicio.tienda.Services.TiendaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tiendas")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;
    

    @GetMapping
    public ResponseEntity<List<TiendaProductosDto>> consultarTiendasProductos() throws Exception {
        try {
            return ResponseEntity.ok(tiendaService.consultarTiendasProductos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tiendas> consultarTiendaPorId(@PathVariable Integer id) throws Exception {
        try {
            return ResponseEntity.ok(tiendaService.consultarPorIdTienda(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Tiendas> crearTienda(@RequestBody TiendaDto tienda) throws Exception {
        try {
            Tiendas result = tiendaService.crearTienda(tienda);
            return ResponseEntity.created(new URI("/api/tiendas/" + result.getIdTienda())).body(result);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tiendas> actualizarTienda(@PathVariable Integer id, @RequestBody Tiendas tienda)
            throws Exception {
        try {
            return ResponseEntity.ok().body(tiendaService.actualizarTienda(id, tienda));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }    

    @PostMapping("/{id}/productos")
    public ResponseEntity<List<Productos>> agregarProductos(@PathVariable Integer id,
            @RequestBody List<ProductoDto> productos) throws Exception {
        try {
            List<Productos> result = tiendaService.agregarProductos(id, productos);
            return ResponseEntity.created(new URI("/api/productos/" + id.toString())).body(result);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/productos")
    public ResponseEntity<List<Productos>> consultarProductosTienda(@PathVariable Integer id) throws Exception {
        try {
            List<Productos> result = tiendaService.consultarProductosTienda(id);
            return ResponseEntity.created(new URI("/api/productos/tienda" + id.toString())).body(result);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
