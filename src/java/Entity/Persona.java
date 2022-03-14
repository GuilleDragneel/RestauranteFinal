/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 07/03/2022
Fecha actualizacion= 07/03/2022
Descripcion= Paquete de entity y clase persona
 */
package Entity;

public abstract class Persona {

    private String nombre;
    private String sexo;
    private Integer edad;

    public Persona() { 
    }

    public Persona(String nombre, String sexo, Integer edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
