/*
Autor= Guillermo Daniel Cruz Ortega
Fecha creacion= 08/03/2022
Fecha actualizacion= 14/03/2022
Descripcion= Paquete de base de datos
 */
package bd;

import java.sql.*;

public class Conexion {

    private Connection connection;
    private String url = "localhost";
    private String user = "postgres";
    private String pwd = "guille";
    private String bd = "rcm";

    public Conexion() {
    }

    public Conexion(Connection conecction, String url, String user, String pwd) {
        this.connection = conecction;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    public void Conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://" + url + "/" + bd, user, pwd);
                System.out.println("Conexion exitosa");
            } catch (Exception ex) {
                System.out.println("Error de conexion: " + ex.getMessage());
            }
        }
    }

    public void Desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
                System.out.println("Desconexion exitosa");
            } catch (Exception ex) {
                System.out.println("Error de desconectar: " + ex.getMessage());
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Conexion con = new Conexion();
        con.Conectar();
        con.Desconectar();
    }

}