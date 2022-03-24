/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 23/03/2022
Fecha actualizacion= 24/03/2022
Descripcion= Servlet de guardar y crear usuario 
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

public class GuardarCrearUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUsuarioService service = new UsuarioServiceImpl();
        Usuario u = new Usuario();
        u.setcodigo(request.getParameter("idUsuario1"));
        u.setnombre_usuario(request.getParameter("nombreusu"));
        u.setcontraseña(request.getParameter("contraseña"));
        u.setNombre(request.getParameter("nombre"));
        u.setSexo(request.getParameter("sexo"));
        u.setEdad(Integer.parseInt(request.getParameter("edad")));
        service.crearRegisto(u);
        response.sendRedirect("ListarUsuarioServlet");
    }
}
