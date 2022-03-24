/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 15/03/2022
Fecha actualizacion= 20/03/2022
Descripcion= Servlet de listar usuarios del paquete controller
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
import java.io.PrintWriter;
import java.util.List;

public class ListarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");

        out.println("<head>");
        out.println("<link rel='stylesheet' href='" + request.getContextPath() + "/Resources/CSS/estilo.css'>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1> Servlet </h1>");
        out.println("<table border='2'>");
        out.println(" <tr>");
        out.println("<th>Nombre Usuario</th>");
        out.println("<th>Contraseña</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Sexo</th>");
        out.println("<th>Edad</th>");
        out.println("<th>Editar</th>");
        out.println("<th>Eliminar</th>");
        out.println("</tr>");
        IUsuarioService service = new UsuarioServiceImpl();
        List<Usuario> listaUsuario = service.obtenerRegistros();
        out.println("<tbody>");
        for (Usuario usuario : listaUsuario) {
            out.println("<tr>");
            out.println("<td>" + usuario.getnombre_usuario() + "</td>");
            out.println("<td>" + usuario.getcontraseña() + "</td>");
            out.println("<td>" + usuario.getNombre() + "</td>");
            out.println("<td>" + usuario.getSexo() + "</td>");
            out.println("<td>" + usuario.getEdad() + "</td>");
            out.println("<th><a href='EditarUsuarioServlet?idUsuario1=" + usuario.getcodigo() + "'>Editar</a></th>");
            out.println("<th><a href='EliminarUsuarioServlet?idUsuario=" + usuario.getcodigo() + "' onclick=\"return confirm('Desea eliminar el usuario?');\")>Eliminar</a></th>");
        }
        out.println("</tbody>");
        out.println("</table>");

        out.println("</body>");

        out.println("</html>");
    }

}
