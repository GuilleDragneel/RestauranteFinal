/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 16/03/2022
Fecha actualizacion= 16/03/2022
Descripcion= Clase de usuario del paquete Service
 */
package Service;

import Entity.Usuario;
import Model.IUsuarioModel;
import Model.UsuarioModelImpl;
import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService {
    
    IUsuarioModel modelo = new UsuarioModelImpl();
    
    @Override
    public void crearRegisto(Usuario usuario) {
        modelo.crearRegisto(usuario);
    }
    
    @Override
    public void actualizarRegistro(Usuario usuario) {
        modelo.actualizarRegistro(usuario);
    }
    
    @Override
    public List<Usuario> obtenerRegistros() {
        return modelo.obtenerRegistros();
    }
    
    @Override
    public Usuario obtenerRegistro(int idUsuario) {
        return modelo.obtenerRegistro(idUsuario);
    }
    
    @Override
    public void eliminarResgistro(int idUsuario) {
        modelo.eliminarResgistro(idUsuario);
    }
    
}
