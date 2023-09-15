package ppm.ejercicio.tienda.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ppm.ejercicio.tienda.Entities.Productos;
import ppm.ejercicio.tienda.Services.ProductoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Productos>> ConsultarTodas() throws Exception {
        try {
            return ResponseEntity.ok(productoService.ConsultarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> consultarProductoPorId(@PathVariable Integer id) throws Exception {
        try {
            return ResponseEntity.ok(productoService.ConsultarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/tienda/{id}")
    public ResponseEntity<List<Productos>> consultarProductoPorIdTienda(@PathVariable Integer id)
            throws Exception {
        try {
            return ResponseEntity.ok(productoService.ConsultarPorIdTienda(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Integer id, @RequestBody Productos producto)
            throws Exception {
        try {
            return ResponseEntity.ok().body(productoService.actualizarProducto(id, producto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
