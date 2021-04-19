package Hilos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fases.Ciudad;
import fases.Conexion;
import fases.Pacientes;

public class InsertaDatosHilo implements Runnable{
	
	static int contador =  0;
	static ArrayList<Pacientes> listaPacientes = Ciudad.listaPacientes;
	boolean inserta = false;
	public void run() {

		insertaBucle();			
	}
	
	//Bucle que controla la insercion de pacientes
	static synchronized private void insertaBucle() {
		for(; contador<listaPacientes.size();contador++) {
			try {
				
				insertar(listaPacientes.get(contador));													
				Thread.sleep(500);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}			
	}

	//Inserta paciente en la tabla personas_informe
	public static boolean insertar(Pacientes paciente) throws SQLException {

        boolean insertado = true;

        Connection conexion = Conexion.getConexion();
        
        PreparedStatement ps = conexion.prepareStatement("INSERT INTO personas_informe (id, id_ciudad, Nombre, Tipo, Infectado) " + "VALUES (?, ?, ?, ?, ?)");
        ps.setInt(1, paciente.getId());
        ps.setInt(2, paciente.getId_ciudad());
        ps.setString(3, paciente.getNombre());
        ps.setString(4, paciente.getTipo());
        ps.setBoolean(5, paciente.getInfectado());
        int resultado = ps.executeUpdate();

        if (resultado == 0) {
            System.out.println("NO se ha podido insertar");
            insertado = false;
        }

        conexion.commit();
        ps.close();


        return insertado;
    }

}
