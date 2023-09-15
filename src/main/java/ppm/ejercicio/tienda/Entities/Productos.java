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
@Table(name = "Productos", catalog = "PPM_TIENDA", schema = "dbo")
public class Productos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "id_tienda")
    private Integer idTienda;



    public Productos() {
    }


    public Productos(Integer idProducto, String nombre, Float precio, Integer idTienda) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.idTienda = idTienda;
    }

    



}
