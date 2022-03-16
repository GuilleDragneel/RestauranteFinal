/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 07/03/2022
Fecha actualizacion= 08/03/2022
Descripcion= Paquete de entity y clase usuario que hereda de persona
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {

    private String codigo;
    private String nombre_usuario;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(String codigo, String nombre_usuario, String contraseña, String nombre, String sexo, Integer edad) {
        super(nombre, sexo, edad);
        this.codigo = codigo;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }

    public Usuario(String string, String string0, String string1, String string2, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getnombre_usuario() {
        return nombre_usuario;
    }

    public void setnombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getcontraseña() {
        return contraseña;
    }

    public void setcontraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public static void main(String[] args) {
        Usuario a = new Usuario("159", "Hice_King", "hunter", "Simon", "Hombre", 18);
        Usuario b = new Usuario("171", "Gloob", "licht", "Lincon", "Mujer", 20);
        Usuario c = new Usuario("357", "Peace_Maker", "eaglee", "Chris", "Hombre", 22);

        List<Usuario> lista = new ArrayList<Usuario>();
        lista.add(a);
        lista.add(b);
        lista.add(c);
        for (Usuario i : lista) {
            System.out.println("Codigo: " + i.getcodigo());
            System.out.println("Nombre usuario: " + i.getnombre_usuario());
            System.out.println("Contraseña: " + i.getcontraseña());
            System.out.println("Nombre: " + i.getNombre());
            System.out.println("Sexo: " + i.getSexo());
            System.out.println("Edad: " + i.getEdad());
            System.out.println("\n\n");
        }
    }

}
