package ppm.ejercicio.tienda.Services;

import java.net.UnknownHostException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppm.ejercicio.tienda.Entities.Productos;
import ppm.ejercicio.tienda.Repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Productos> ConsultarTodos() {
        return (List<Productos>) productoRepository.findAll();
    }  
    
    public Productos ConsultarPorId(Integer idProducto) {
        return (Productos) productoRepository.findById(idProducto).get();
    } 
    
    public List<Productos> ConsultarPorIdTienda(Integer idTienda) {
        return (List<Productos>) productoRepository.findByIdTienda(idTienda);
    }

    public Productos actualizarProducto(Integer idProducto, Productos producto)
            throws ParserConfigurationException, UnknownHostException {

        Productos updProducto = productoRepository.findById(idProducto).get();

        if (producto.getNombre() != null) {
            updProducto.setNombre(producto.getNombre());
        }
        if (producto.getPrecio() != null) {
            updProducto.setPrecio(producto.getPrecio());
        }
        if (producto.getIdTienda() != null) {
            updProducto.setIdTienda(producto.getIdTienda());
        }

        return productoRepository.save(updProducto);
    }
}
