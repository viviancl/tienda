package ppm.ejercicio.tienda.DTOs.Response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PedidoDto {

    private Integer idPedido;
    private Integer idCliente;
    private String nombreCliente;
    private Date fechaPedido;

    public PedidoDto() {
    }

    public PedidoDto(Integer idPedido, Integer idCliente, String nombreCliente, Date fechaPedido) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.fechaPedido = fechaPedido;
    }
}
