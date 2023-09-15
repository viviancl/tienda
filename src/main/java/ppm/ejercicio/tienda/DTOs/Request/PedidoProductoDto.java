package ppm.ejercicio.tienda.DTOs.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PedidoProductoDto {

    private Integer idProducto;
    private Integer cantidad;    

    public PedidoProductoDto() {
    }


    public PedidoProductoDto(Integer idProducto, Integer cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    

}
