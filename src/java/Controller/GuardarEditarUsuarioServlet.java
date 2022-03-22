/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 17/03/2022
Fecha actualizacion= 17/03/2022
Descripcion= Servlet guardar y editar del paquete controller
 */
package Controller;

import Service.IUsuarioService;
import Service.UsuarioServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GuardarEditarUsuarioServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario1 = Integer.parseInt(request.getParameter("idUsuario1"));
        IUsuarioService service = new UsuarioServiceImpl();
        String nombre = request.getParameter("Nombre");
        service.actualizarRegistro(usuario);
        response.sendRedirect("ListarUsuarioServlet");
    }
    
}
