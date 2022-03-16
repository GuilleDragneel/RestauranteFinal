/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 15/03/2022
Fecha actualizacion= 15/03/2022
Descripcion= Servlet de listar usuarios del paquete controller
 */
package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ListarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1> Servlet </h1>");
    }

}
