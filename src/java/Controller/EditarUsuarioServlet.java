/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 17/03/2022
Fecha actualizacion= 23/03/2022
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
        out.println("<link rel='stylesheet' href='" + request.getContextPath() + "/Resources/CSS/estiloIndex.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<section class='forma'>");
        out.println("<div class='header'><h1 class='principal'> Restaurante Flor de Loto</h1></div>");
        out.println("<nav>");
        out.println("<ul id='menu'>");
        out.println("<li><a href='" + request.getContextPath() + "/Pages/index.html'>Inicio</a>");
        out.println("<ul>");
        out.println("<li><a href='" + request.getContextPath() + "/Pages/CrearRegistro.html'>Crear</a></li>");
        out.println("<li><a href='ListarUsuarioServlet'>Listar</a></li>");
        out.println("<li><a href='ListarUsuarioServlet'>Editar</a></li>");
        out.println("<li><a href='ListarUsuarioServlet'>Eliminar</a></li>");
        out.println("</ul>");
        out.println("<li><a href='" + request.getContextPath() + "/Pages/Acercade.html'>Acercade...</a></li>");
        out.println("</li>");
        out.println("</ul>");
        out.println("</nav>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("</section>");
        out.println("<section class='forma_registro'>");
        out.println("<form action='GuardarEditarUsuarioServlet' method='GET'>");
        out.println("<input type='hidden' name='idUsuario1' value='" + usuario.getcodigo() + "'>");
        out.println("<label>Nombre de Usuario: </label><br>");
        out.println("<input type='text' name='nombreusu' value='" + usuario.getnombre_usuario() + "' required pattern='[A-Za-z]{1,}' ><br>");
        out.println("<label>Nombre: </label><br>");
        out.println("<input type='text' name='contraseña' value='" + usuario.getcontraseña() + "' required pattern='[A-Za-z]{1,}' ><br>");
        out.println("<label>Contrasena: </label><br>");
        out.println("<input type='text' name='nombre' value='" + usuario.getNombre() + "' required pattern='[A-Za-z]{1,}' ><br>");
        out.println("<label>Sexo: </label><br>");
        out.println("<input type='text' name='sexo' value='" + usuario.getSexo() + "' required pattern='[A-Za-z]{1,}' ><br>");
        out.println("<label>Edad: </label><br>");
        out.println("<input type='number' name='edad' min='18' value='" + usuario.getEdad() + "' ><br>");
        out.println("<br>");
        out.println("<button  class='button'>Guardar</button>");
        out.println("</section>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

}
