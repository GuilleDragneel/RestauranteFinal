/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 17/03/2022
Fecha actualizacion= 19/03/2022
Descripcion= Servlet eliminar del paquete controller
 */
package Controller;

import Service.IUsuarioService;
import Service.UsuarioServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        IUsuarioService service = new UsuarioServiceImpl();
        service.eliminarResgistro(idUsuario);
        response.sendRedirect("ListarUsuarioServlet");
    }

}
