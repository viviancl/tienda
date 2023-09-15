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
public class PedidoClienteDto {

    private Integer idCliente;
    private List<PedidoProductoDto> productos;

    public PedidoClienteDto() {
    }

    public PedidoClienteDto(Integer idCliente, List<PedidoProductoDto> productos) {
        this.idCliente = idCliente;
        this.productos = productos;
    }    

}
