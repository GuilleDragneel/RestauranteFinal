/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 11/03/2022
Fecha actualizacion= 15/03/2022
Descripcion= Implementacion interface usuario 
 */
package Model;

import Entity.Usuario;
import bd.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModelImpl implements IUsuarioModel {

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
        Usuario usu = null;
        List<Usuario> lista = null;
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConnection();
            String sql = "select * from usuario;";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                usu = new Usuario();
                usu.setcodigo(rs.getString("codigo"));
                usu.setnombre_usuario(rs.getString("nombre_usuario"));
                usu.setcontraseña(rs.getString("contraseña"));
                usu.setNombre(rs.getString("nombre"));
                usu.setSexo(rs.getString("sexo"));
                usu.setEdad(rs.getInt("edad"));
                lista.add(usu);
            }
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error al obtener registros= " + ex);
        }
        return lista;
    }

    @Override
    public Usuario obtenerRegistro(int idUsuario) {
        Usuario usu1 = null;
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConnection();
            String sql = "select * from usuario where codigo=" + idUsuario + ";";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            usu1 = new Usuario();
            while (rs.next()) {
                usu1.setcodigo(rs.getString("codigo"));
                usu1.setnombre_usuario(rs.getString("nombre_usuario"));
                usu1.setcontraseña(rs.getString("contraseña"));
                usu1.setNombre(rs.getString("nombre"));
                usu1.setSexo(rs.getString("sexo"));
                usu1.setEdad(rs.getInt("edad"));
            }
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error de obetener registro= " + ex);
        }
        return usu1;
    }

    @Override
    public void eliminarResgistro(int idUsuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConnection();
            String sql = "delete from usuario where codigo=" + idUsuario + ";";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(sql);
            conexion.Desconectar();
        } catch (Exception ex) {
            System.out.println("Error de eliminar registro= " + ex);
        }
    }

    public static void main(String[] args) {
        Usuario a = new Usuario();
        a.setcodigo("1");
        a.setnombre_usuario("Hice King");
        a.setcontraseña("bett");
        a.setNombre("Simon");
        a.setSexo("Hombre");
        a.setEdad(1880);
        UsuarioModelImpl um = new UsuarioModelImpl();

        um.crearRegisto(a);
        //um.actualizarRegistro(a);
        //um.eliminarResgistro(1);
        a = um.obtenerRegistro(3);
        System.out.println(a.getNombre());

        List<Usuario> listaUsuario = um.obtenerRegistros();

        for (Usuario u : listaUsuario) {
            System.out.println("NOmbre: " + u.getNombre());
        }
        //System.out.println(um.obtenerRegistros());
    }
}
