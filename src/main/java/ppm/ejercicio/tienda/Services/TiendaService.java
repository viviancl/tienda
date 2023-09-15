package ppm.ejercicio.tienda.Services;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppm.ejercicio.tienda.DTOs.Request.ProductoDto;
import ppm.ejercicio.tienda.DTOs.Request.TiendaDto;
import ppm.ejercicio.tienda.DTOs.Response.TiendaProductosDto;
import ppm.ejercicio.tienda.Entities.Productos;
import ppm.ejercicio.tienda.Entities.Tiendas;
import ppm.ejercicio.tienda.Repositories.ProductoRepository;
import ppm.ejercicio.tienda.Repositories.TiendaRepository;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Tiendas> consultarTodas() {
        return (List<Tiendas>) tiendaRepository.findAll();
    }

    public Tiendas consultarPorIdTienda(Integer idTienda) {
        return (Tiendas) tiendaRepository.findById(idTienda).get();
    }

    public Tiendas crearTienda(TiendaDto tienda)
            throws ParserConfigurationException, UnknownHostException {

        Tiendas newTienda = new Tiendas();
        newTienda.setNombre(tienda.getNombre());
        newTienda.setDireccion(tienda.getDireccion());
        newTienda.setTelefono(tienda.getTelefono());

        return tiendaRepository.save(newTienda);
    }

    public Tiendas actualizarTienda(Integer idTienda, Tiendas tienda)
            throws ParserConfigurationException, UnknownHostException {

        Tiendas updTienda = tiendaRepository.findById(idTienda).get();

        if (tienda.getNombre() != null) {
            updTienda.setNombre(tienda.getNombre());
        }
        if (tienda.getDireccion() != null) {
            updTienda.setDireccion(tienda.getDireccion());
        }
        if (tienda.getTelefono() != null) {
            updTienda.setTelefono(tienda.getTelefono());
        }

        return tiendaRepository.save(updTienda);
    }

    public List<Productos> agregarProductos(Integer idTienda, List<ProductoDto> productos)
            throws ParserConfigurationException, UnknownHostException {
        List<Productos> productosAgregados = new ArrayList<Productos>();
        for (ProductoDto producto : productos) {

            Productos newProducto = new Productos();
            newProducto.setNombre(producto.getNombre());
            newProducto.setPrecio(producto.getPrecio());
            newProducto.setIdTienda(idTienda);
            productoRepository.save(newProducto);
            productosAgregados.add(newProducto);
        }

        return productosAgregados;
    }

    public List<TiendaProductosDto> consultarTiendasProductos()
            throws ParserConfigurationException, UnknownHostException {
        List<Tiendas> tiendas = consultarTodas();
        List<TiendaProductosDto> result = new ArrayList<TiendaProductosDto>();

        for (Tiendas tienda : tiendas) {

            TiendaProductosDto tiendaProductosDto = new TiendaProductosDto();
            tiendaProductosDto.setNombre(tienda.getNombre());
            tiendaProductosDto.setDireccion(tienda.getDireccion());
            tiendaProductosDto.setTelefono(tienda.getTelefono());
            tiendaProductosDto.setProductos(productoRepository.findByIdTienda(tienda.getIdTienda()));
            result.add(tiendaProductosDto);
        }

        return result;
    }

    public List<Productos> consultarProductosTienda(Integer idTienda) {
        return productoRepository.findByIdTienda(idTienda);
    }
}
