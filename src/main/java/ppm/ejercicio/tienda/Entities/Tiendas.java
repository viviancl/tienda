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
@Table(name = "Tiendas", catalog = "PPM_TIENDA", schema = "dbo")
public class Tiendas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda", nullable = false)
    private Integer idTienda;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;


    public Tiendas() {
    }

    public Tiendas(Integer idTienda, String nombre, String direccion, String telefono) {
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "{" +
            " idTienda='" + getIdTienda() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", telefono='" + getTelefono() + "'" +
            "}";
    }



}
