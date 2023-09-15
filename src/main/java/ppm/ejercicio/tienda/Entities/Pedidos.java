package ppm.ejercicio.tienda.Entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Pedidos", catalog = "PPM_TIENDA", schema = "dbo")
public class Pedidos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido", nullable = false)
    private Integer idPedido;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "fecha_pedido")
    private Date fechaPedido;


    public Pedidos() {
    }


    public Pedidos(Integer idPedido, Integer idCliente, Date fechaPedido) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.fechaPedido = fechaPedido;
    }




}
