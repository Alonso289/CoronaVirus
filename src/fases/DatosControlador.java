package fases;

import java.sql.SQLException;
import java.util.ArrayList;

public class DatosControlador {

	//Valida el nombre entero de la ciudad
	 public static boolean validarNombreCiudad(DatosDTO datos) {
	        boolean validar = false;
	        if (datos.getNombreCiudad()>0) {
	            validar = true;
	        }

	        return validar;
	 }
	 
	 //Obtiene la lista de usuarios si la validacion es correcta
	 public static ArrayList<Persona> obtenerDatos(DatosDTO datos) throws SQLException {
		 ArrayList<Persona> listaPersonas = null;

	        if (validarNombreCiudad(datos))
	        	 listaPersonas = DatosDAO.obtenerUsuariosCiudad(datos);
	        

	      return listaPersonas;
	  }
}
