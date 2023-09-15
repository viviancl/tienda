package ppm.ejercicio.tienda.DTOs.Request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AgregarProductoDto {

    private List<ProductoDto> productos;  


    public AgregarProductoDto() {
    }
    

    public AgregarProductoDto(List<ProductoDto> productos) {
        this.productos = productos;
    }



}
