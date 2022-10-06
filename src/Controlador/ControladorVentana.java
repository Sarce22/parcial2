/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClsConexion;
import Modelo.ClsUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class ControladorVentana {

    ClsConexion conexion = new ClsConexion();

    public ControladorVentana() {
    }

    public boolean regitrarse(String cedula, String nombre, String apellido, String correo, String contraseña) {
        ClsUsuario usuario = new ClsUsuario(cedula, nombre,
                apellido, correo, contraseña);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute("insert into usuario(cedula,nombre,apellido,correo,contraseña) "
                    + "values('" + usuario.getCedula() + "','"
                    + usuario.getNombre() + "','"
                    + usuario.getApellido() + "',"
                    + usuario.getCorreo() + "',"
                    + usuario.getContraseña()+ ")");//consulta
            conexion.desconectar();//se desconecta de la base de datos          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();//se desconecta de la base de datos          
            return false;
        }
    }

    public List<String> buscarPersona(String cedula) {

        List<String> temp = new ArrayList<String>();

        conexion.conectar();

        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select usuario,cedula,nombre,"
                            + "apellido,correo,contraseña from usuario where "
                            + "cedula='" + cedula + "'"));//consulta        

            if (conexion.getResultadoDB().next()) {
                temp.add(conexion.getResultadoDB().getString("cedula"));
                temp.add(conexion.getResultadoDB().getString("nombre"));
                temp.add(conexion.getResultadoDB().getString("apellido"));
                temp.add(conexion.getResultadoDB().getString("correo"));
                temp.add(conexion.getResultadoDB().getString("contraseña") + "");
            }
            conexion.desconectar();//se desconecta de la base de datos                
        } catch (SQLException ex) {
            Logger.getLogger(ClsUsuario.class.getName())
                    .log(Level.SEVERE, null, ex);
            conexion.desconectar();//se desconecta de la base de datos
        }
        return temp;
    }

    public boolean modificarUsuario(String nombre, String apellido, String cedula, String correo, String contraseña) {
        ClsUsuario usuario = new ClsUsuario(nombre, apellido, cedula, correo, contraseña);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute("update usuario set nombre='" + usuario.getCedula()
                    + "',apellido='" + usuario.getNombre() + "',"
                    + "cedula=" + usuario.getApellido() + "',"
                    + "correo" + usuario.getCorreo() + "',"
                    + "contraseña" + usuario.getContraseña()
                    + " where cedula='" + usuario.getCedula() + "'");//consulta
            conexion.desconectar();//se desconecta de la base de datos          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();//se desconecta de la base de datos          
            return false;
        }
    }

    public boolean eliminarDeudor(String cedula) {

        conexion.conectar();

        try {
            conexion.getSentenciaSQL().execute("delete from usuario where cedula='" + cedula + "'");//consulta
            conexion.desconectar();//se desconecta de la base de datos          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();//se desconecta de la base de datos          
            return false;
        }
    }

    
  
    
    
    public boolean loginUsuario(String correo, String contraseña) {

        if (correo.equals(correo) && contraseña.equals(contraseña)) {
            return true;

        }

        return false;
    }
}
