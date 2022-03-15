/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 11/03/2022
Fecha actualizacion= 14/03/2022
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
            System.out.println("Error de actualizar registro= " + ex);
        }
    }

    @Override
    public List<Usuario> obtenerRegistros() {
        Object[] usu = new Object[6];
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConnection();
            String sql = "select * from usuario;";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                usu[1] = rs.getInt(1);
                usu[2] = rs.getString(2);
                usu[3] = rs.getString(3);
                usu[4] = rs.getString(4);
                usu[5] = rs.getString(5);
                usu[6] = rs.getInt(6);
            }
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error al obtener registros= " + ex);
        }
        return null;
    }

    @Override
    public Usuario obtenerRegistro(int idUsuario) {
        Object[] usu1 = new Object[6];
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConnection();
            String sql = "select from usuario where codigo=" + idUsuario + ";";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                usu1[1] = rs.getInt(1);
                usu1[2] = rs.getString(2);
                usu1[3] = rs.getString(3);
                usu1[4] = rs.getString(4);
                usu1[5] = rs.getString(5);
                usu1[6] = rs.getInt(6);

            }
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error de obetener registro= " + ex);
        }
        return null;
    }

    @Override
    public void eliminarResgistro(int idUsuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConnection();
            String sql = "delete from usuario where codigo=" + idUsuario + ";";
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error de eliminar registro= " + ex);
        }
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
//        um.actualizarRegistro(a);
//        um.eliminarResgistro(1);
    }
}
