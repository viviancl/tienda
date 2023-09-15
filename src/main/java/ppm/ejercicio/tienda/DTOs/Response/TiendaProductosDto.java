package ppm.ejercicio.tienda.DTOs.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import ppm.ejercicio.tienda.Entities.Productos;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TiendaProductosDto {

    private String nombre;
    private String direccion;
    private String telefono;
    private List<Productos> productos;

    public TiendaProductosDto() {
    }

    public TiendaProductosDto(String nombre, String direccion, String telefono, List<Productos> productos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.productos = productos;
    }

}
