/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sebastian
 */
public class ClsConexion {

    private String driver = "org.postgresql.Driver"; //nombre del driver
    private String connectString = "jdbc:mysql://localhost:3306/ps"; //ubicacion de la base de datos, para mysql esta es por defecto
    private String user = "root"; //usuario de la base de datos
    private String password = "Sapol100200300"; //password de la base de datos
    private Connection conexionDB; // variable que permite la conexion
    private Statement sentenciaSQL; //permite la ejecucion de sentencias SQL
    private ResultSet resultadoDB;//almacena el resultado de una consulta

    
    
    public void conectar() {
        // 1. CREAR CONEXIÓN
        try {
            Class.forName(driver); //se carga el driver en memoria
            conexionDB = DriverManager.getConnection(connectString, user, password);//conexion a la base de datos
            // 2. CREAR EL STATEMENT    
            sentenciaSQL = conexionDB.createStatement();//variable que permite ejecutar las sentencias SQL                                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Desconecta la conexion de la base de datos
     *
     * @author Julian Velez
     * @version 20 Marzo 2022
     */
    public void desconectar() {
        try {
            sentenciaSQL.close();//cierra la consulta
            conexionDB.close();//cierra conexion
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    public Statement getSentenciaSQL() {
        return sentenciaSQL;
    }

    public void setSentenciaSQL(Statement sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    public ResultSet getResultadoDB() {
        return resultadoDB;
    }

    public void setResultadoDB(ResultSet resultadoDB) {
        this.resultadoDB = resultadoDB;
    }

  

}
