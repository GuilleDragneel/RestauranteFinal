/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 17/03/2022
Fecha actualizacion= 22/03/2022
Descripcion= Servlet editar del paquete controller
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

public class EditarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int idUsuario1 = Integer.parseInt(request.getParameter("idUsuario1"));
        IUsuarioService service = new UsuarioServiceImpl();
        Usuario usuario = new Usuario();
        usuario = service.obtenerRegistro(idUsuario1);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='GuardarEditarUsuarioServlet' method='GET'>");
        out.println("<input type='hidden' name='idUsuario1' value='" + usuario.getcodigo() + "'>");
        out.println("<p>Nombre de Usuario: <input type='text' name='nombreusu' value='" + usuario.getnombre_usuario() + "'></p>");
        out.println("<p>Contraseña: <input type='text' name='contraseña' value='" + usuario.getcontraseña() + "'></p>");
        out.println("<p>Nombre: <input type='text' name='nombre' value='" + usuario.getNombre() + "'></p>");
        out.println("<p>Sexo: <input type='text' name='sexo' value='" + usuario.getSexo() + "'></p>");
        out.println("<p>Edad: <input type='number' name='numero' min='18' value='" + usuario.getEdad() + "'></p>");
        out.println("<input type='submit' value='Enviar'");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }

}
