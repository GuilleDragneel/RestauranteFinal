/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 17/03/2022
Fecha actualizacion= 22/03/2022
Descripcion= Servlet guardar y editar del paquete controller
 */
package Controller;

import Entity.Usuario;
import Service.IUsuarioService;
import Service.UsuarioServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GuardarEditarUsuarioServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUsuarioService service = new UsuarioServiceImpl();
        Usuario u = new Usuario();
        int idUsuario1 = Integer.parseInt(request.getParameter("idUsuario1"));
        u.setcodigo(request.getParameter("idUsuario1"));
        u.setnombre_usuario(request.getParameter("nombreusu"));
        u.setcontraseña(request.getParameter("contraseña"));
        u.setNombre(request.getParameter("nombre"));
        u.setSexo(request.getParameter("sexo"));
        u.setEdad(Integer.parseInt(request.getParameter("edad")));
        service.actualizarRegistro(u);
        response.sendRedirect("ListarUsuarioServlet");
    }
    
}
