/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 11/03/2022
Fecha actualizacion= 11/03/2022
Descripcion= Interface usuario en paquete de modelo
 */
package Model;

import Entity.Usuario;
import java.util.List;

public interface IUsuarioModel {

    public void crearRegisto(Usuario usuario);

    public void actualizarRegistro(Usuario usuario);

    public List<Usuario> obtenerRegistros();

    public Usuario obtenerRegistro(int idUsuario);

    public void eliminarResgistro(int idUsuario);
}
