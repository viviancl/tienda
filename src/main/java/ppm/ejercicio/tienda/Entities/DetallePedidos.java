package ppm.ejercicio.tienda.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Detalle_Pedidos", catalog = "PPM_TIENDA", schema = "dbo")
public class DetallePedidos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle", nullable = false)
    private Integer idDetalle;

    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "id_producto")   
    private Integer idProducto;

    @Column(name = "cantidad")
    private Integer cantidad;


    public DetallePedidos() {
    }


    public DetallePedidos(Integer idDetalle, Integer idPedido, Integer idProducto, Integer cantidad) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }




}
