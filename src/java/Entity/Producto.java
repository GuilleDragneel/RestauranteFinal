/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 07/03/2022
Fecha actualizacion= 08/03/2022
Descripcion= Paquete de entity y clase producto
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private String codigo;
    private String nombre;
    private Double precio;
    private String descripcion;

    public Producto() {

    }

    public Producto(String nombre, Double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static void main(String[] args) {
        Producto a = new Producto("Papas fritas", 12.5, "Papas ultra ketchup");
        Producto b = new Producto("La ultra lite", 50.0, "Hamburguesa vegana");
        Producto c = new Producto("Tallarines", 30.5, "Talla-mini");

        List<Producto> lista = new ArrayList<Producto>();
        lista.add(a);
        lista.add(b);
        lista.add(c);
        for (Producto i : lista) {
            System.out.println("Nombre: " + i.getNombre());
            System.out.println("Precio: " + i.getPrecio());
            System.out.println("Descripcion: " + i.getDescripcion());
            System.out.println("\n\n");
        }

    }
}
