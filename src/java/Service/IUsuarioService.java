/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 16/03/2022
Fecha actualizacion= 16/03/2022
Descripcion= Interface de usuario del paquete Service
 */
package Service;

import Entity.Usuario;
import java.util.List;

public interface IUsuarioService {

    public void crearRegisto(Usuario usuario);

    public void actualizarRegistro(Usuario usuario);

    public List<Usuario> obtenerRegistros();

    public Usuario obtenerRegistro(int idUsuario);

    public void eliminarResgistro(int idUsuario);
}
