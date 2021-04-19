/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fases;

/**
 *
 * @author Alonso289
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Conexion {
    
	private static Logger logger = LogManager.getLogger(Conexion.class);
	static String bd = "prueba_serbatic";
	static String login = "root";
	static String password = "";
	static String host = "127.0.0.1"; //localhost
	
	static String url = "jdbc:mysql://";
	static Connection conexion; //atributo para  guardar el objeto Connection
        
        
	
    public static Connection getConexion() {
	    if (conexion == null) {
	    	crearConexion();
                System.out.println("Conexion creada");
                logger.info("Conexion creada");
	    }
	    return conexion;
    }
    
    // devuelve true si se ha creado correctamente
    public static boolean crearConexion() {
	    try {
	        //cargo el driver
	        Class.forName("com.mysql.jdbc.Driver");
	        conexion = DriverManager.getConnection(url + host + "/"+ bd, login, password);
	      
                conexion.setAutoCommit(false);
	        
	    } catch (SQLException e) {
	    	return false;
	    }
	    catch (Exception e) {
	    	return false;
	    }
	    return true;
    }

    public static void desconectar(){
    	try {
            conexion.close();
            conexion = null;
            System.out.println("\nLa conexion a la  base de datos " + bd + " ha terminado");
            logger.info("La conexion a la  base de datos " + bd + " ha terminado");
    	
    	} catch (SQLException e) {
    		System.out.println("Error al cerrar la conexion");
    		logger.error("Error al cerrar la conexion");
        }
    }
   
}
