/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 11/03/2022
Fecha actualizacion= 11/03/2022
Descripcion= Implementacion interface usuario 
 */
package Model;

import Entity.Usuario;
import bd.Conexion;
import java.sql.*;
import java.util.List;

public class UsuarioModelmpl implements IUsuarioModel {

    private Conexion conexion;
    private Connection connection;

    @Override
    public void crearRegisto(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConnection();
            String sql = "insert into usuario(nombre_usuario, contraseña, nombre, sexo, edad) values(?,?,?,?,?);";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, usuario.getnombre_usuario());
            st.setString(2, usuario.getcontraseña());
            st.setString(3, usuario.getNombre());
            st.setString(4, usuario.getSexo());
            st.setInt(5, usuario.getEdad());
            st.executeUpdate();
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error de crear registro= " + ex);
        }
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConnection();
            String sql = "update usuario set nombre_usuario=?, contraseña=?, nombre=?, sexo=?, edad=? where codigo=" + usuario.getcodigo() + ";";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, usuario.getnombre_usuario());
            st.setString(2, usuario.getcontraseña());
            st.setString(3, usuario.getNombre());
            st.setString(4, usuario.getSexo());
            st.setInt(5, usuario.getEdad());
            st.executeUpdate();
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error de crear registro= " + ex);
        }
    }

    @Override
    public List<Usuario> obtenerRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtenerRegistro(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarResgistro(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        Usuario a = new Usuario();
        a.setcodigo("1");
        a.setnombre_usuario("Aventura");
        a.setcontraseña("jake");
        a.setNombre("Finn");
        a.setSexo("Hombre");
        a.setEdad(18);
        UsuarioModelmpl um = new UsuarioModelmpl();
        um.actualizarRegistro(a);
    }
}
