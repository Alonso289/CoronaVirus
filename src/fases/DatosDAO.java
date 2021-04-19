package fases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatosDAO {

    private static Statement st;
    
    //Obtenemos una lista de usuarios
	public static ArrayList<Persona> obtenerUsuariosCiudad(DatosDTO datos) throws SQLException {

		Connection conexion = Conexion.getConexion();
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        st = conexion.createStatement();
        String query = "SELECT * FROM personas Where id_ciudad=" + datos.getNombreCiudad();
        ResultSet rs = st.executeQuery(query);


        while (rs.next()) {
            int id = rs.getInt(1); 
            int id_ciudad = rs.getInt(2); 
            String nombre = rs.getString(3); 
            String tipo = rs.getString(4); 
            boolean infectado = rs.getBoolean(5); 

            Persona persona = new Persona(id, id_ciudad, nombre, tipo, infectado);
            listaPersonas.add(persona);

        }
        rs.close();
        return listaPersonas;
        
    }
}
