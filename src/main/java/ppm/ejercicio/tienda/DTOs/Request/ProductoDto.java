package ppm.ejercicio.tienda.DTOs.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ProductoDto {

    private String nombre;
    private Float precio;
    private Integer idTienda;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, Float precio, Integer idTienda) {
        this.nombre = nombre;
        this.precio = precio;
        this.idTienda = idTienda;
    }

    public ProductoDto(String nombre, Float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    

}
